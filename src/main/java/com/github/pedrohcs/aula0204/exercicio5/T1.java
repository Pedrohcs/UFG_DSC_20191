package com.github.pedrohcs.aula0204.exercicio5;

public class T1 implements Runnable{
    private int numeroIdentificação;
    private boolean loop = true;

    public T1(int num){
        this.numeroIdentificação = num;
    }

    @Override
    public void run(){
        while(loop) {
            System.out.println(String.format("Thread %d executando", this.numeroIdentificação));
        }
    }
}

