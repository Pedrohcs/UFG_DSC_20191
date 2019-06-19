package com.github.pedrohcs.prova.exercicio8;

public class Produtor extends Thread {

    private Deposito deposito;

    public Produtor (Deposito deposito){
        this.deposito = deposito;
    }

    @Override
    public void run(){
        try {
            while(true) {
                this.deposito.colocar();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
