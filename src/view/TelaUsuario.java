package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.UsuarioController;
import models.dao.agendamento.Agendamento;
import models.dao.agendamentoservico.AgendamentoDetalhado;
import models.dao.usuario.Usuario;

public class TelaUsuario {
    
    Scanner ler = new Scanner(System.in);
    UsuarioController telaUsuario = new UsuarioController();

    ArrayList<Agendamento> agendamentos = new ArrayList<>();
    ArrayList<AgendamentoDetalhado> agendamentoDetalhado = new ArrayList<>();

    public TelaUsuario(Usuario usuario) {
        int opcoes = 0;
        String email = "";
        String senha = "";
        
        do {
            System.out.println("\nSelecione a opção que deseja realizar:");
            System.out.println("1. Fazer novo agendamento");
            System.out.println("2. Ver próximos agendamentos");
            System.out.println("3. Ver histórico de agendamentos");
            System.out.println("4. Buscar agendamentos por serviço");
            System.out.println("0. Sair");
            opcoes = ler.nextInt();

            switch (opcoes) {
            case 0:
                System.out.println("Volte Sempre");
                System.exit(0);
                break;
            case 1:
                new CadastroAgendamentoView(email, senha);
                break;
            case 2:
                telaUsuario.buscarProximosAgendamentos(usuario.getIdUsuario());
                break;
            case 3:
                telaUsuario.selecionarTodosAgendamentos(usuario.getIdUsuario());
                break;
            case 4:
                String nomeServico;
                System.out.println("Informe qual serviço que deseja procurar em seus agendamentos:");
                nomeServico = ler.next();
                telaUsuario.buscarAgendamentosPorServico(nomeServico, usuario.getIdUsuario());
                break;
            default:
                break;
            }
        } while (opcoes >= 0 || opcoes <= 3);
    }

}
