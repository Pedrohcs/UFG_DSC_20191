package com.github.pedrohcs.prova.exercicio8;

public class Consumidor extends Thread{

    private Deposito deposito;

    public Consumidor(Deposito deposito){
        this.deposito = deposito;
    }

    @Override
    public void run(){
        try {
            while(true) {
                this.deposito.retirar();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

