package controller;

import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

import models.dao.endereco.EnderecoDAO;
import models.dao.usuario.UsuarioDAO;

public class TelaCadastroController {
    
        public void IniciarCadastro(){

            Cadastrar();
            
        }



        Scanner s = new Scanner(System.in);
        public String solicitarNomeUsuario(){
            
            String nome;
            
            boolean isValido;
            
            do{
                System.out.println("Por favor, Informe seu nome Completo*: ");
                nome = s.nextLine();

                if (nome == null || nome.trim().isEmpty()){
                    System.out.println("Nome é Obrigatório");
                    isValido = false;
                }else{
                    isValido = true;
                }

            } while(isValido == false);
            
            return nome;
        }
        //feito
        public String solicitarSenhaUsuario(){

            String senha;
            
            do{
                System.out.println("Informe uma Senha*: ");
                senha = s.nextLine();
            }while(!isSenhaValida(senha));
            
            return senha;
        }
        //feito
        public String solicitarEmailUsuario(){
            String email;
            
            do{
                System.out.println("Informe Seu Email*: ");
                email = s.nextLine();
            }while(!verificarEmail(email));
            return email;
        }

        public String solicitarTelefoneUsuario(){
            System.out.println("Informe Seu Telefone*: ");
            String telefone;
            telefone = s.nextLine();
            return telefone;
        }

        public static class Endereco {
          private String rua;
            private String bairro;
            private int numero;
            private String cep;

            public Endereco() {
            }

            // Getters
            public String getRua() { return rua; }
            public String getBairro() { return bairro; }
            public int getNumero() { return numero; }
            public String getCep() { return cep; }

            // Setters
            public void setRua(String rua) { this.rua = rua; }
            public void setBairro(String bairro) { this.bairro = bairro; }
            public void setNumero(int numero) { this.numero = numero; }
            public void setCep(String cep) { this.cep = cep; }
        }

public Endereco solicitarEnderecoUsuario() {

        String rua;
        String bairro;
        int numero = 0; 
        String cep;

        boolean isValido;

        System.out.println("Informe Seu Endereço");

        
        do {
            System.out.println("Informe a Rua*:");
            rua = s.nextLine();
            System.out.println("Rua Informada: " + rua);
            if (rua == null || rua.trim().isEmpty()) {
                isValido = false;
            } else {
                isValido = true;
            }
        } while (isValido == false);

        
        do {
            System.out.println("Informe o Bairro*: ");
            bairro = s.nextLine();
            if (bairro == null || bairro.trim().isEmpty()) {
                isValido = false;
            } else {
                isValido = true;
            }
        } while (isValido == false);

        do {
            System.out.println("Informe o Número*: ");
            String numeroStr = s.nextLine(); 
            
            try {
                numero = Integer.parseInt(numeroStr); 
                
                if (numero == 0) {
                    System.out.println("Número não pode ser zero.");
                    isValido = false;
                } else {
                    isValido = true; 
                }
            } catch (NumberFormatException e) {
                
                System.out.println("Entrada inválida. Por favor, digite apenas números.");
                isValido = false;
            }
        } while (isValido == false);
        
        do {
            System.out.println("Informe o CEP*: ");
            cep = s.nextLine();
            if (cep == null || cep.trim().isEmpty()) {
                isValido = false;
            } else {
                isValido = true;
            }
        } while (isValido == false);


        Endereco enderecoCompleto = new Endereco();

        enderecoCompleto.setRua(rua);
        enderecoCompleto.setBairro(bairro);
        enderecoCompleto.setNumero(numero);
        enderecoCompleto.setCep(cep);

        return enderecoCompleto;
    }

        public String solicitarDataNascimentoUsuario(){
            String dataNascimento;
            boolean isDataNascimentoVazia;
            
            do{
                System.out.println("Informe Sua Data de Nascimento* (AAAA-MM-DD):");
                dataNascimento = s.nextLine();

                if(dataNascimento == null || dataNascimento.trim().isEmpty()){
                    System.out.println("Data de Nascimento Não Pode ser Vazia!");
                    isDataNascimentoVazia = false;
                }else{

                    // Try e Catch para Ver se o Formato da Data está AAAA-MM-DD, se não, Repetir a pergunta
                    try{
                        LocalDate.parse(dataNascimento);
                        isDataNascimentoVazia = true;
                    }catch(DateTimeParseException e){
                        System.out.println("Data de Nascimento Inválida!!");
                        isDataNascimentoVazia = false;
                    }
                }
            }while(isDataNascimentoVazia == false);
            return dataNascimento;
        }

        public String solicitarCPFUsuario(){
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

            if(cpf.length() < 10 || cpf.length() > 11){
                System.out.println("CPF Com Tamanho Inválido!");
                return false;
            }
            return true;
        }
        //Fim CPF


        // Inserir no Banco ---->>>>
        public void Cadastrar(){

            Endereco enderecoColetado = solicitarEnderecoUsuario();
            String rua = enderecoColetado.getRua();
            String bairro = enderecoColetado.getBairro();
            int numero = enderecoColetado.getNumero();
            String cep = enderecoColetado.getCep();

            String nome = solicitarNomeUsuario();
            String email = solicitarEmailUsuario();
            String senha = solicitarSenhaUsuario();
            String dataNascimento = solicitarDataNascimentoUsuario();
            String cpf = solicitarCPFUsuario();
            String telefone = solicitarTelefoneUsuario();

            java.time.LocalDate hoje = java.time.LocalDate.now();
            String dataCriacao = hoje.toString();

            EnderecoDAO crudEndereco = new EnderecoDAO();

            String InserirEndereco = crudEndereco.inserirEndereco(rua, bairro, numero, cep);

            // Último Endereço Inserido tentativa Nº 23
            int idEnderecoCriado = crudEndereco.buscarUltimoIdEndereco();



            if (idEnderecoCriado > 0){
                UsuarioDAO crudUsuario = new UsuarioDAO();
                String Inserindo = crudUsuario.inserirUsuario(idEnderecoCriado, nome, null, dataNascimento, cpf, telefone, email, senha, dataCriacao, "2020-10-10", true);

                System.out.println("Usuário Inserido Com Sucesso!! -->> "+Inserindo);
            }else{
                System.out.println("Erro ao Cadastrar Endereço, Usuário Não Cadastrado -->> "+InserirEndereco);
            }       
        }

}