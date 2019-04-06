package com.github.pedrohcs.aula0204.exercicio1;

public class Main {
    public static void main(String[] args){
        long tempoTotal, tempoInicial, tempoFinal;
        long contador2 = 3;
        double somatorio = 1.00;

        tempoInicial = System.currentTimeMillis();

        for (int i = 1; i < 10001; i++){
            if ((i%2) == 0){
                somatorio = somatorio + (1.00/contador2);
            } else {
                somatorio = somatorio - (1.00/contador2);
            }
            contador2 += 2;
        }

        tempoFinal = System.currentTimeMillis();

        tempoTotal = tempoFinal - tempoInicial;

        System.out.println("Soma total: " + somatorio*4);
        System.out.println("Tempo inicial: " + tempoInicial);
        System.out.println("Tempo final: " + tempoFinal);
        System.out.println("Tempo total gasto: " + tempoTotal);
    }
}
