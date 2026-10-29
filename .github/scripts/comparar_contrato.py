"""Compara el contrato (docs/api/openapi.yaml) con la API real (/v3/api-docs).

Exige que coincidan endpoints, parámetros, códigos de respuesta, tipos de contenido
y nombres y tipos de los campos. Ignora textos, ejemplos, formatos y metadatos.
Uso: python comparar_contrato.py <contrato.yaml> <api-real.json>
"""
import json
import sys

import yaml

METODOS = {"get", "post", "put", "patch", "delete"}


def resolver(esquema, raiz):
    while isinstance(esquema, dict) and "$ref" in esquema:
        nodo = raiz
        for parte in esquema["$ref"].lstrip("#/").split("/"):
            nodo = nodo[parte]
        esquema = nodo
    return esquema or {}


def forma(esquema, raiz):
    esquema = resolver(esquema, raiz)
    tipo = esquema.get("type", "object" if "properties" in esquema else None)
    if tipo == "array":
        return ["array", forma(esquema.get("items", {}), raiz)]
    if tipo == "object":
        return {nombre: forma(prop, raiz) for nombre, prop in esquema.get("properties", {}).items()}
    return tipo


def contenido(cuerpo, raiz):
    cuerpo = resolver(cuerpo, raiz)
    salida = {}
    for tipo, valor in (cuerpo.get("content") or {}).items():
        salida["application/json" if tipo == "*/*" else tipo] = forma(valor.get("schema", {}), raiz)
    return salida


def firma(spec):
    resultado = {}
    for ruta, operaciones in (spec.get("paths") or {}).items():
        for metodo, op in operaciones.items():
            if metodo not in METODOS:
                continue
            parametros = sorted(
                (p["in"], p["name"], str(forma(p.get("schema", {}), spec)))
                for p in (resolver(p, spec) for p in op.get("parameters", []))
            )
            resultado[f"{metodo.upper()} {ruta}"] = {
                "parametros": parametros,
                "cuerpo": contenido(op["requestBody"], spec) if "requestBody" in op else None,
                "respuestas": {codigo: contenido(r, spec) for codigo, r in op.get("responses", {}).items()},
            }
    return resultado


def main():
    with open(sys.argv[1], encoding="utf-8") as f:
        contrato = firma(yaml.safe_load(f))
    with open(sys.argv[2], encoding="utf-8") as f:
        real = firma(json.load(f))

    errores = []
    for endpoint in sorted(contrato.keys() - real.keys()):
        errores.append(f"Falta en la API real: {endpoint}")
    for endpoint in sorted(real.keys() - contrato.keys()):
        errores.append(f"La API real tiene un endpoint que no está en el contrato: {endpoint}")
    for endpoint in sorted(contrato.keys() & real.keys()):
        for parte in ("parametros", "cuerpo", "respuestas"):
            if contrato[endpoint][parte] != real[endpoint][parte]:
                errores.append(
                    f"{endpoint} · {parte} distintos\n"
                    f"    contrato: {json.dumps(contrato[endpoint][parte], ensure_ascii=False)}\n"
                    f"    real:     {json.dumps(real[endpoint][parte], ensure_ascii=False)}"
                )

    if errores:
        print("La API no coincide con docs/api/openapi.yaml:")
        for error in errores:
            print(f"  - {error}")
        sys.exit(1)
    print(f"La API coincide con el contrato ({len(contrato)} endpoints).")


if __name__ == "__main__":
    main()
