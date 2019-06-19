package com.github.pedrohcs.aula0204.exercicio7;

public class Teste implements Runnable{

    private int[] numeros;
    private int soma;

    public Teste(int[] numeros){
        this.numeros = numeros;
    }

    public int getSoma(){
        return this.soma;
    }

    @Override
    public void run() {
        this.soma = 0;
        for (int num : this.numeros){
            this.soma += num;
        }
        System.out.println("Somatorio dos números: " + this.soma);
    }
}
