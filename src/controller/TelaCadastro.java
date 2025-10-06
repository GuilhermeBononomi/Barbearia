package controller;

import java.util.Scanner;

public class TelaCadastro {
        public void IniciarCadastro(){
            solicitarNomeUsuario();
            solicitarSenhaUsuario();
            solicitarEmailUsuario();
            solicitarTelefoneUsuario();
            solicitarEnderecoUsuario();
            solicitarDataNascimentoUsuario();
            solicitarCPFUsuario();
            
        }

        //feito
        public String solicitarNomeUsuario(){
            
            String nome;
            Scanner s = new Scanner(System.in);
            do{
                System.out.println("Por favor, Informe seu nome Completo*: ");
                nome = s.nextLine();

                if (nome == null || nome.trim().isEmpty()){
                    System.out.println("Nome é Obrigatório");
                }

            } while(nome != null);
            s.close();
            return nome;
        }
        //feito
        public String solicitarSenhaUsuario(){
            Scanner s = new Scanner(System.in);
            String senha;
            do{
                System.out.println("Informe uma Senha*: ");
                senha = s.nextLine();
            }while(!isSenhaValida(senha));
            s.close();
            return senha;
        }
        //feito
        public String solicitarEmailUsuario(){
            Scanner s = new Scanner(System.in);
            String email;
            do{
                System.out.println("Informe Seu Email*: ");
                email = s.nextLine();
            }while(!verificarEmail(email));
            return email;
        }

        public String solicitarTelefoneUsuario(){
            System.out.println("Informe Seu Telefone*: ");
            Scanner s = new Scanner(System.in);
            String telefone;
            telefone = s.nextLine();
            return telefone;
        }

        public String solicitarEnderecoUsuario(){
            Scanner s = new Scanner (System.in);
            String endereco;
            boolean isEnderecoValido;
            do{
                System.out.println("Informe Seu Endereço*: ");
                endereco = s.nextLine();
                if(endereco == null || endereco.trim().isEmpty()){
                    isEnderecoValido = false;
                }else{
                    isEnderecoValido = true;
                }
            }while(isEnderecoValido == false);
            return endereco;
        }

        public String solicitarDataNascimentoUsuario(){
            Scanner s = new Scanner (System.in);
            String dataNascimento;
            boolean isDataNascimentoVazia;
            
            do{
                System.out.println("Informe Sua Data de Nascimento*:");
                dataNascimento = s.nextLine();

                if(dataNascimento == null || dataNascimento.trim().isEmpty()){
                    System.out.println("Data de Nascimento Não Pode ser Vazia!");
                    isDataNascimentoVazia = false;
                }else{
                    isDataNascimentoVazia = true;
                }

            }while(isDataNascimentoVazia == false);
            return dataNascimento;
        }

        public String solicitarCPFUsuario(){
            Scanner s = new Scanner (System.in);
            String cpf;
            do{
                System.out.println("Informe Seu CPF:");
                cpf = s.nextLine();
            }while(!verificarCPF(cpf));
            return cpf;
        }

        // Verificando Coisas ->

        public boolean isSenhaValida(String senha){
            if(senha == null || senha.trim().isEmpty()){
                System.out.println("Informe uma Senha!!");
                return false;
            }

            if(senha.length() < 6){
               System.out.println("Senha Precisa Ter no Mínimo 6 caracteres!");
               return false;
            }
        // Verificar Letra Maíuscula
            boolean letraMaiscula = false;
            for(char letra : senha.toCharArray()){
                if(Character.isUpperCase(letra)){
                    letraMaiscula = true;
                    break;
                }
            }
            if(!letraMaiscula){
                System.out.println("Senha precisa Ter no Mínimo uma Letra Maíuscula!!");
                return false;
            }
            return true;
        }
        // Fim Verificar Letra Maíuscula
        // Fim senha


        //Email 
        public boolean verificarEmail(String email){

            if(email == null || email.trim().isEmpty()){
                System.out.println("Email não Pode Ser Vazio");
                return false;
            }

            if(!email.contains("@") || !email.contains(".")){
                System.out.println("Formato do Email Inválido!");
                return false;
            } 

            // Procura a Posição do Arroba
            int lugarDoArroba = email.indexOf('@');
            if(lugarDoArroba <= 0 || email.lastIndexOf('@') != lugarDoArroba){
                System.out.println("Formato do Email Inválido!");
                return false;
            }

            int lugarDoPonto = email.lastIndexOf('.');
            if(lugarDoPonto < lugarDoArroba + 2 || lugarDoPonto == email.length()){
                System.out.println("Formato do Email Inválido!");
                return false;
            }

            return true;
        }
        //Fim Email

        //Verificar CPF
        public boolean verificarCPF(String cpf){
            
            if(cpf == null || cpf.trim().isEmpty()){
                System.out.println("CPF Não Pode Ser Vazio!");
                return false;
            }

            if(cpf.length() < 12){
                System.out.println("CPF Com Tamanho Inválido!");
                return false;
            }
            return true;
        }
        //Fim CPF
}
