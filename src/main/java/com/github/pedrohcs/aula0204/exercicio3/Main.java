package com.github.pedrohcs.aula0204.exercicio3;

public class Main {
    public static void main(String[] args){
        long numero, comparador;
        boolean verificador = true;
        long tempoInicial, tempoFinal, tempoTotal;

        tempoInicial = System.currentTimeMillis();

        for (numero = 1; numero < 300001; numero++){
            if(numero == 1){
                verificador = false;
            } else if (numero == 2){
                verificador = true;
            } else {
                for (comparador = 2; comparador < numero; comparador ++){
                    if ((numero % comparador) == 0){
                        verificador = false;
                        break;
                    }
                }
            }

            if (verificador){
                System.out.println("Este número é primo: " + numero);
            }
            verificador = true;

        }

        tempoFinal = System.currentTimeMillis();
        tempoTotal = tempoFinal - tempoInicial;

        System.out.println("Tempo inicial: " + tempoInicial);
        System.out.println("Tempo final: " + tempoFinal);
        System.out.println("Tempo total: " + tempoTotal);
    }
}
