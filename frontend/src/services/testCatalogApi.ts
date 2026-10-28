export type TestType = {
  code: string;
  name: string;
  enabled: boolean;
};

/** El frontend consume DTOs; nunca conoce entidades JPA ni URLs internas. */
export async function getTestTypes(fetcher: typeof fetch = fetch): Promise<TestType[]> {
  const response = await fetcher('/api/v1/tests', {
    headers: { Accept: 'application/json' },
  });
  if (!response.ok) {
    throw new Error(`No se pudo cargar el catálogo (HTTP ${response.status})`);
  }
  const data: unknown = await response.json();
  if (!Array.isArray(data) || !data.every(isTestType)) {
    throw new Error('El catálogo no cumple el contrato esperado');
  }
  return data;
}

function isTestType(value: unknown): value is TestType {
  return typeof value === 'object' && value !== null
    && 'code' in value && typeof value.code === 'string'
    && 'name' in value && typeof value.name === 'string'
    && 'enabled' in value && typeof value.enabled === 'boolean';
}
