package com.github.pedrohcs.aula0804.exercicio1;

public class ThreadA implements Runnable {

    private int quantNumsPrimos = 0;
    private int comparador;
    private int numInicial = 1_000_000;
    private int numFinal = 30_000_000;
    private boolean verificador = true;

    @Override
    public void run() {
        int num;
        for (num = this.numInicial; num < this.numFinal; num++){
            if(this.numInicial == 1){
                this.verificador = false;
            } else if (this.numInicial == 2){
                this.verificador = true;
            } else {
                for (this.comparador = 2; this.comparador < num; this.comparador ++){
                    if ((num % this.comparador) == 0){
                        this.verificador = false;
                        break;
                    }
                }
            }

            if (this.verificador){
                System.out.println("Este número é primo: " + num);
                this.quantNumsPrimos ++;
            }
            verificador = true;

        }

        System.out.println(String.format("Quantidade de números primos: %d", this.quantNumsPrimos));
    }
}
