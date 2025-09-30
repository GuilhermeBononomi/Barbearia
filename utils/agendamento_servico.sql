CREATE TABLE IF NOT EXISTS AgendamentoServico (
  IdAgendamento INTEGER NOT NULL REFERENCES Agendamento(IdAgendamento) ON DELETE CASCADE,
  IdServico INTEGER NOT NULL REFERENCES Servico(IdServico) ON DELETE CASCADE,
  Observacao VARCHAR(255),
  PRIMARY KEY (IdAgendamento, IdServico)
);