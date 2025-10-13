
drop table if EXISTS usuario;

CREATE TABLE IF NOT EXISTS Usuario (
  IdUsuario SERIAL PRIMARY KEY,
  IdEndereco INTEGER REFERENCES Endereco(IdEndereco) ON DELETE SET NULL,
  PrimeiroNome VARCHAR(100) NOT NULL,
  Sobrenome VARCHAR(100),
  DataNascimento DATE,
  Cpf varchar(11) unique not null,
  Telefone varchar(12) not null,
  Email VARCHAR(150) UNIQUE NOT NULL,
  Senha VARCHAR(255) NOT NULL,
  DataCriacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  DataAlteracao TIMESTAMP,
  Status BOOLEAN DEFAULT TRUE
);