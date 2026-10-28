import { describe, expect, it, vi } from 'vitest';
import { getTestTypes } from '../services/testCatalogApi';

describe('GET /api/v1/tests', () => {
  it('acepta la respuesta documentada', async () => {
    const catalog = [{ code: 'BFA', name: 'Batería Factorial de Aptitudes', enabled: false }];
    const fetcher = vi.fn<typeof fetch>().mockResolvedValue(
      new Response(JSON.stringify(catalog), { status: 200 }),
    );
    await expect(getTestTypes(fetcher)).resolves.toEqual(catalog);
    expect(fetcher).toHaveBeenCalledWith('/api/v1/tests', { headers: { Accept: 'application/json' } });
  });

  it('rechaza un contrato inválido', async () => {
    const fetcher = vi.fn<typeof fetch>().mockResolvedValue(
      new Response(JSON.stringify([{ titulo: 'BFA' }]), { status: 200 }),
    );
    await expect(getTestTypes(fetcher)).rejects.toThrow('contrato');
  });
});
