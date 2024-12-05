package exercicio12.questao2;

import java.util.Scanner;

/**
 * Classe principal para testar as funcionalidades do Retangulo.
 */
public class MainRetangulo {
    public static void main(String[] args) {
        Retangulo ret = new Retangulo();
        Scanner input = new Scanner(System.in);
        
        System.out.print("Informe a altura do retângulo: ");
        ret.setAltura(input.nextFloat());
        System.out.print("Informe a largura do retângulo: ");
        ret.setLargura(input.nextFloat());
        
        System.out.println("\nInformações do retângulo:");
        System.out.println(ret.exibe());
        
        input.close();
    }
}