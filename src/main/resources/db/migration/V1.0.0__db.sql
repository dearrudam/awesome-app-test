CREATE TABLE devs
(
  id      INTEGER NOT NULL,
  nome    VARCHAR(20),
  nivel   VARCHAR(20),
  salario DECIMAL(16,2) DEFAULT 0.00,
  PRIMARY KEY (id)
);
INSERT INTO devs(id, nome, nivel, salario) VALUES (65164, 'Dev 01', 'SENIOR', 20500.00);
INSERT INTO devs(id, nome, nivel, salario) VALUES (65465, 'Dev 02', 'PLENO', 11250.00 );
INSERT INTO devs(id, nome, nivel, salario) VALUES (25142, 'Dev 04', 'JUNIOR', 3280.50);
INSERT INTO devs(id, nome, nivel, salario) VALUES (51245, 'Dev 05', 'JUNIOR', 3280.50);
INSERT INTO devs(id, nome, nivel, salario) VALUES (88521, 'Dev 06', 'PLENO', 11250.00);
INSERT INTO devs(id, nome, nivel, salario) VALUES (85761, 'Dev 07', 'JUNIOR', 3280.50);
INSERT INTO devs(id, nome, nivel, salario) VALUES (88415, 'Dev 08', 'PLENO', 11250.00);
INSERT INTO devs(id, nome, nivel, salario) VALUES (82194, 'Dev 09', 'JUNIOR', 3280.50);