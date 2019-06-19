package com.github.pedrohcs.aula0805.exercicio5;

import java.util.ArrayList;

public class Checker {
    private ArrayList<Boolean> verdadeiro = new ArrayList<>();

    public synchronized ArrayList<Boolean> getChecker() {
        return checker;
    }

    public Checker(ArrayList<Boolean> boleano) {
        this.checker = boleano;
    }

    public synchronized void setBoleano(ArrayList<Boolean> boleano) {
        this.checker = boleano;
    }

    private ArrayList<Boolean> checker = new ArrayList<>();

    public Checker() {
        this.checker.add(false);
        this.checker.add(false);
        this.checker.add(false);
        this.verdadeiro.add(true);
        this.verdadeiro.add(true);
        this.verdadeiro.add(true);
    }

    public synchronized boolean setTrue(int index) {

        this.checker.remove(index);
        this.checker.add(index, true);
        if(this.checker.equals(this.verdadeiro)) {
            return true;
        }
        return false;
    }

}
