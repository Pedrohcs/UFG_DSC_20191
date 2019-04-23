package com.github.pedrohcs.aula1604.sequencial;

public class Sequencial {

    public static void main(String[] args) {
        int inicio1 = 1_000_000, fim1 = 30_000_000;
        int inicio2 = 90_000_000, fim2 = 120_000_000;
        int cont, primos = 0;
        long tempoTotal, tempoInicial, tempoFinal;

        tempoInicial = System.currentTimeMillis();

        for(cont = inicio1; cont < fim1; cont++){
            if (isPrime(cont)) {
               primos ++;
            }
        }

        for(cont = inicio2; cont < fim2; cont++){
            if (isPrime(cont)){
                primos ++;
            }
        }

        tempoFinal = System.currentTimeMillis();

        tempoTotal = tempoFinal - tempoInicial;
        System.out.println(String.format("Total de números primos: %d", primos));
        System.out.println(String.format("Tempo total gasto: %d", tempoTotal));
    }

    public static boolean isPrime(int n) {
        if (n % 2 == 0) return false;
        for(int i = 3; i * i <= n; i += 2) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
