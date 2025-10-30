-- Migration para criação de todas as tabelas do sistema da Barbearia
-- Ordem de criação baseada nas dependências de chaves estrangeiras

-- Tabela Endereco (sem dependências)
CREATE TABLE IF NOT EXISTS Endereco (
  IdEndereco SERIAL PRIMARY KEY,
  Rua VARCHAR(255),
  Bairro VARCHAR(100),
  Numero INTEGER,
  Cep VARCHAR(20)
);

-- Tabela Usuario (depende de Endereco)
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

-- Tabela Funcionario (depende de Usuario)
CREATE TABLE IF NOT EXISTS Funcionario (
  IdFuncionario SERIAL PRIMARY KEY,
  IdUsuario INTEGER NOT NULL REFERENCES Usuario(IdUsuario) ON DELETE CASCADE,
  Cargo VARCHAR(100) NOT NULL
);

-- Tabela Servico (sem dependências)
CREATE TABLE IF NOT EXISTS Servico (
  IdServico SERIAL PRIMARY KEY,
  Nome VARCHAR(150) NOT NULL,
  Preco DOUBLE PRECISION NOT NULL,
  Descricao VARCHAR(255)
);

-- Tabela Agendamento (depende de Usuario e Funcionario)
CREATE TABLE IF NOT EXISTS Agendamento (
  IdAgendamento SERIAL PRIMARY KEY,
  IdUsuario INTEGER NOT NULL REFERENCES Usuario(IdUsuario) ON DELETE CASCADE,
  IdFuncionario INTEGER NOT NULL REFERENCES Funcionario(IdFuncionario) ON DELETE CASCADE,
  Data DATE NOT NULL,
  Inicio TIME NOT NULL,
  Termino TIME NOT NULL
);

-- Tabela AgendamentoServico (depende de Agendamento e Servico)
CREATE TABLE IF NOT EXISTS AgendamentoServico (
  IdAgendamento INTEGER NOT NULL REFERENCES Agendamento(IdAgendamento) ON DELETE CASCADE,
  IdServico INTEGER NOT NULL REFERENCES Servico(IdServico) ON DELETE CASCADE,
  Observacao VARCHAR(255),
  PRIMARY KEY (IdAgendamento, IdServico)
);