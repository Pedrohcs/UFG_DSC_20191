package com.github.pedrohcs.aula0204.exercicio7;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args){
        long tempoTotal, tempoInicial, tempoFinal;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número de colunas");
        int colunas = scanner.nextInt();
        System.out.println("Digite o número de linhas");
        int linhas = scanner.nextInt();

        int[][] matrix = new int[colunas][linhas];
        java.lang.Thread[] thread = new java.lang.Thread[colunas];
        Thread[] thread7 = new Thread[colunas];

        tempoInicial = System.currentTimeMillis();

        for (int contadorColunas = 0; contadorColunas < colunas; contadorColunas++){
            for (int contadorLinhas = 0; contadorLinhas < linhas; contadorLinhas++){
                matrix[contadorColunas][contadorLinhas] = ThreadLocalRandom.current().nextInt(0, 1000);
            }
        }

        int contador, soma = 0;

        for (contador = 0; contador < colunas; contador ++){
            Thread tRun = new Thread(matrix[contador]);
            thread7[contador] = tRun;
            thread[contador] = new java.lang.Thread(tRun);
            thread[contador].start();
        }

        for (java.lang.Thread t : thread){
            try{
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(Thread t : thread7){
            soma += t.getSoma();
        }

        tempoFinal = System.currentTimeMillis();

        tempoTotal = tempoFinal - tempoInicial;
        System.out.println(String.format("Somatorio de todos os números: %d", soma));
        System.out.println(String.format("Tempo total gasto: %d", tempoTotal));
    }
}
