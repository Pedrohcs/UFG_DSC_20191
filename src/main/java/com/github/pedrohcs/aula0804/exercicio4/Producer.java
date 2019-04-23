package com.github.pedrohcs.aula0804.exercicio4;

public class Producer extends Thread {

    private Mailbox mailbox;
    private String nome;

    public Producer (Mailbox mailbox, String nome){
        this.mailbox = mailbox;
        this.nome = nome;
    }

    @Override
    public void run(){
        try {
            while(true) {
                this.mailbox.storeMessage("Mensagem de " + this.nome);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
