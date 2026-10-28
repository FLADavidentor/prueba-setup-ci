import { TestCatalog } from './features/catalog/TestCatalog';

export function App() {
  return (
    <>
      <header className="site-header">
        <div className="container">
          <span className="eyebrow light">Ingeniería de Software II · Servicios Web</span>
          <h1>Sistema Integrado de Evaluaciones</h1>
          <p>Una plataforma compartida para cinco tipos de pruebas y un solo equipo de producto.</p>
        </div>
      </header>
      <main className="container main-content">
        <TestCatalog />
        <aside className="note">
          <strong>Base técnica disponible.</strong> El catálogo, la estructura de capas y la conexión
          con PostgreSQL son el punto de partida. Los cuestionarios, la calificación, la
          autenticación de usuarios y los reportes todavía requieren desarrollo y validación.
        </aside>
      </main>
      <footer className="site-footer container">Monorepositorio · Spring Boot + React + PostgreSQL</footer>
    </>
  );
}
