package com.github.pedrohcs.prova.exercicio8;

/**
 * Matrícula e nome do aluno: 201602512-Pedro Henrique Coimbra e Silva
 */
public class Deposito {
    private int itens = 0;
    private final int capacidade = 10;

    public synchronized void retirar() throws InterruptedException {
        if (itens > 0) {
            itens--;
            System.out.println("Caixa retirada: Sobram " + itens + " caixas");
            this.notifyAll();
        } else {
            this.wait();
        }
    }

    public synchronized void colocar() throws InterruptedException {
        if (itens < capacidade) {
            itens++;
            System.out.println("Caixa armazenada: passaram a ser " + itens + " caixas");
            this.notifyAll();
        } else {
            this.wait();
        }
    }

    public static void main(String[] args) {
        Deposito dep = new Deposito();
        Produtor p = new Produtor(dep);
        Consumidor c = new Consumidor(dep);

        p.start();
        c.start();

        System.out.println("Execução do main terminada!");
    }
}
