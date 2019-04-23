package com.github.pedrohcs.aula1604.duas;

public class ThreadB implements Runnable {
    private int quantNumsPrimos = 0;
    private int numInicial = 90_000_000;
    private int numFinal = 120_000_000;

    @Override
    public void run() {
        int num;
        for (num = this.numInicial; num < this.numFinal; num++){
            if (isPrime(num)){
                this.quantNumsPrimos ++;
            }
        }

        System.out.println(String.format("Quantidade de números primos: %d", this.quantNumsPrimos));
    }

    private boolean isPrime(int n) {
        if (n % 2 == 0) return false;
        for(int i = 3; i * i <= n; i += 2) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
