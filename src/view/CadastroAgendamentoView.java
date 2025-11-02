package view;

import java.util.Scanner;

import controller.UsuarioController;

public class CadastroAgendamentoView {

    Scanner input = new Scanner(System.in);

    UsuarioController agendamento = new UsuarioController();

    public CadastroAgendamentoView(String email, String senha) {
        int escolha = 0;
        int id_servico = 0;
        int colaborador = 0;
        String data = "";
        String inicio = "";
        String termino = "";
        String observacao = "";

        System.out.println("\nSelecione qual dos servicos deseja realizar:");
        System.out.println("1. Cortar Cabelo");
        System.out.println("2. Fazer Barba");
        escolha = input.nextInt();

        switch (escolha) {
            case 0:
                break;
            case 1:
                id_servico = 1;
                break;
            case 2:
                id_servico = 1;
                break;
            default:
                break;
        }


        System.out.println("\nSelecione um barbeiro para cortar cabelo:");
        System.out.println("1. Barbeiro 1");
        System.out.println("2. Barbeiro 2");
        System.out.println("3. Barbeiro 3");
        System.out.println("4. Barbeiro 4");
        System.out.println("5. Barbeiro 5");
        escolha = input.nextInt();
        
        switch (escolha) {
            case 0:
                break;
            case 1:
                colaborador = 1;
                break;
            case 2:
                colaborador = 2;
                break;
            case 3:
                colaborador = 3;
                break;
            case 4:
                colaborador = 4;
                break;
            case 5:
                colaborador = 5;
                break;
            default:
                break;
        }

        System.out.println("\nSelecione o dia no qual deseja cortar cabelo:");
        System.out.println("1. 01-11-2025");
        System.out.println("2. 02-11-2025");
        System.out.println("3. 03-11-2025");
        System.out.println("4. 04-11-2025");
        System.out.println("5. 05-11-2025");
        System.out.println("6. 06-11-2025");
        System.out.println("7. 07-11-2025");
        System.out.println("8. 08-11-2025");
        System.out.println("9. 09-11-2025");
        System.out.println("10. 10-11-2025");
        System.out.println("11. 11-11-2025");
        System.out.println("12. 12-11-2025");
        escolha = input.nextInt();
        
        switch (escolha) {
            case 0:
                break;
            case 1:
                data = "01-11-2025";
                break;
            case 2:
                data = "02-11-2025";
                break;
            case 3:
                data = "03-11-2025";
                break;
            case 4:
                data = "04-11-2025";
                break;
            case 5:
                data = "05-11-2025";
                break;
            case 6:
                data = "06-11-2025";
                break;
            case 7:
                data = "07-11-2025";
                break;
            case 8:
                data = "08-11-2025";
                break;
            case 9:
                data = "09-11-2025";
                break;
            case 10:
                data = "10-11-2025";
                break;
            case 11:
                data = "11-11-2025";
                break;
            case 12:
                data = "12-11-2025";
                break;
            default:
                break;
        }

        System.out.println("\nSelecione o horário no qual deseja cortar cabelo:");
        System.out.println("1. 07:00 - 07:30");
        System.out.println("2. 07:30 - 08:00");
        System.out.println("3. 08:00 - 08:30");
        System.out.println("4. 08:30 - 09:00");
        System.out.println("5. 09:00 - 09:30");
        System.out.println("6. 09:30 - 10:00");
        System.out.println("7. 10:00 - 10:30");
        System.out.println("8. 10:30 - 11:00");
        System.out.println("0. Voltar");
        escolha = input.nextInt();

        switch (escolha) {
            case 0:
                break;
            case 1:
                inicio = "07:00";
                termino = "07:30";
                break;
            case 2:
                inicio = "07:30";
                termino = "08:00";
                break;
            case 3:
                inicio = "08:00";
                termino = "08:30";
                break;
            case 4:
                inicio = "08:30";
                termino = "09:00";
                break;
            case 5:
                inicio = "09:00";
                termino = "09:30";
                break;
            case 6:
                inicio = "09:30";
                termino = "10:00";
                break;
            case 7:
                inicio = "10:00";
                termino = "10:30";
                break;
            case 8:
                inicio = "10:30";
                termino = "11:00";
                break;
            default:
                break;
        }

        System.out.println("\nInsira uma observação:");
        observacao = input.next();

        agendamento.cadastrarAgendamento(email, senha, id_servico, colaborador, data, inicio, termino, observacao);
    }

}
