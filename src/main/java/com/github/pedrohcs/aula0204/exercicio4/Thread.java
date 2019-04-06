package com.github.pedrohcs.aula0204.exercicio4;

public class Thread implements Runnable{
    private int numeroIdentificacao;

    public Thread(int num){
        this.numeroIdentificacao = num;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10; i++){
            System.out.println("Mensagem " + i + " da thread " + this.numeroIdentificacao);
        }
    }
}
