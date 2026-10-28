import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import { App } from './App';
import './styles.css';

const element = document.getElementById('root');
if (!element) throw new Error('No se encontró el contenedor raíz');

createRoot(element).render(
  <StrictMode>
    <App />
  </StrictMode>,
);
