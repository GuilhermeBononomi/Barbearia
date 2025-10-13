drop table if EXISTS endereco;

CREATE TABLE IF NOT EXISTS Endereco (
  IdEndereco SERIAL PRIMARY KEY,
  Rua VARCHAR(255),
  Bairro VARCHAR(100),
  Numero INTEGER,
  Cep VARCHAR(20)
);