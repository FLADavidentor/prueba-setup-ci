-- Esquema transversal mínimo. No define respuestas ni fórmulas de calificación.
CREATE TABLE test_type (
    id UUID PRIMARY KEY,
    code VARCHAR(40) NOT NULL UNIQUE,
    name VARCHAR(160) NOT NULL,
    display_order INTEGER NOT NULL UNIQUE,
    enabled BOOLEAN NOT NULL DEFAULT FALSE
);

INSERT INTO test_type (id, code, name, display_order, enabled) VALUES
('00000000-0000-0000-0000-000000000001', 'BFA', 'Batería Factorial de Aptitudes', 1, FALSE),
('00000000-0000-0000-0000-000000000002', 'WEILL', 'Inteligencia de Weill', 2, FALSE),
('00000000-0000-0000-0000-000000000003', 'THURSTONE', 'Intereses de Thurstone', 3, FALSE),
('00000000-0000-0000-0000-000000000004', 'ALLPORT', 'Valores de Allport', 4, FALSE),
('00000000-0000-0000-0000-000000000005', 'VOCACIONAL', 'Orientación Vocacional', 5, FALSE);
