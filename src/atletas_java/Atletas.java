package atletas_java;

import java.util.Locale;
import java.util.Scanner;

public class Atletas {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Qual a quantidade de atletas? ");
        int N = sc.nextInt();
        sc.nextLine(); // Limpa o buffer do scanner após nextInt()

        int generoF = 0;
        int generoM = 0;
        double pesoMedio = 0;
        double somaAlturasMulheres = 0;
        int quantidadeMulheres = 0;
        double maiorAltura = 0;
        String nomeAtletaMaisAlto = "";

        double[] alturas = new double[N];
        String[] nomesAtletas = new String[N];

        for (int i = 0; i < N; i++) {
            System.out.println("Digite os dados do atleta número " + (i + 1) + ":");

            System.out.print("Nome : ");
            nomesAtletas[i] = sc.nextLine();

            System.out.print("Sexo (F ou M) : ");
            char sexo = sc.nextLine().toUpperCase().charAt(0);
            
            while (sexo != 'F' && sexo != 'M') {
                System.out.print("Valor inválido! Favor digitar F ou M: ");
                sexo = sc.nextLine().toUpperCase().charAt(0);
            }

            System.out.print("Altura: ");
            double altura = sc.nextDouble();
            sc.nextLine(); // Limpa o buffer após nextDouble()
            
            while (altura <= 0) {
                System.out.print("Valor inválido! Favor digitar um valor positivo: ");
                altura = sc.nextDouble();
                sc.nextLine();
            }
            
            alturas[i] = altura;
            
            // Verifica se a altura é a maior
            if (altura > maiorAltura) {
                maiorAltura = altura;
                nomeAtletaMaisAlto = nomesAtletas[i];
            }

            System.out.print("Peso: ");
            double peso = sc.nextDouble();
            sc.nextLine(); // Limpa o buffer após nextDouble()
            
            while (peso <= 0) {
                System.out.print("Valor inválido! Favor digitar um valor positivo: ");
                peso = sc.nextDouble();
                sc.nextLine();
            }
            
            pesoMedio += peso;

            if (sexo == 'M') {
                generoM++;
            } else if (sexo == 'F') {
                generoF++;
                somaAlturasMulheres += altura;
                quantidadeMulheres++;
            }
        }

        pesoMedio /= N;
        double porcentagemHomens = (double) generoM / N * 100;
        double alturaMediaMulheres = (quantidadeMulheres > 0) ? somaAlturasMulheres / quantidadeMulheres : 0;

        System.out.println();
        System.out.println("RELATÓRIO:");
        System.out.println();
        System.out.printf("Peso médio dos atletas: %.2f%n", pesoMedio);
        System.out.printf("Atleta mais alto: %s%n", nomeAtletaMaisAlto);
        System.out.printf("Porcentagem de homens: %.1f %%%n", porcentagemHomens);
        System.out.printf("Altura média das mulheres: %.2f%n", alturaMediaMulheres);

        sc.close();
    }
}
