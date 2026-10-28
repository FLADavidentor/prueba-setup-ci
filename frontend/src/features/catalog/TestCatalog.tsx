import { useEffect, useState } from 'react';
import { getTestTypes, type TestType } from '../../services/testCatalogApi';

export function TestCatalog() {
  const [items, setItems] = useState<TestType[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    let active = true;
    getTestTypes()
      .then((data) => { if (active) setItems(data); })
      .catch((cause: unknown) => {
        if (active) setError(cause instanceof Error ? cause.message : 'Error de conexión');
      })
      .finally(() => { if (active) setLoading(false); });
    return () => { active = false; };
  }, []);

  if (loading) return <p role="status">Cargando catálogo...</p>;
  if (error) return <p role="alert">{error}. Verifica que Spring Boot esté iniciado.</p>;

  return (
    <section aria-labelledby="catalog-title">
      <h2 id="catalog-title">Módulos de evaluación</h2>
      <p className="muted">Los módulos se habilitarán al aprobar requisitos, pruebas y reglas de calificación.</p>
      <div className="catalog-grid">
        {items.map((item, index) => (
          <article key={item.code} className="test-card">
            <span className="eyebrow">Módulo {index + 1}</span>
            <h3>{item.name}</h3>
            <span className={item.enabled ? 'pill enabled' : 'pill'}>
              {item.enabled ? 'Disponible' : 'En preparación'}
            </span>
          </article>
        ))}
      </div>
    </section>
  );
}
