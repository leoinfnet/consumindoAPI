package br.com.infnet;

import br.com.infnet.model.Endereco;
import br.com.infnet.util.CepUtil;

import java.util.Scanner;

public class CadastroUsuario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o seu nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite o seu cep:");
        String cep = scanner.nextLine();

        CepUtil cepUtil = new CepUtil();
        System.out.println("Buscando Cep, aguarde...");
        Endereco enderecoFromCep = cepUtil.getEnderecoFromCep(cep);
        System.out.println("Seu Endereco:");
        System.out.println(enderecoFromCep);


    }
}
