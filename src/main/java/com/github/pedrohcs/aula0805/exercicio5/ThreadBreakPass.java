package com.github.pedrohcs.aula0805.exercicio5;

import java.util.ArrayList;

public class ThreadBreakPass implements Runnable{
    private char[] caracter;
    private ArrayList<String> senhas;
    private char[] caracterCompleto;
    private Checker checker;

    public ThreadBreakPass(char[] caracter, ArrayList<String> senhas, char[] caracterCompleto, Checker checker) {
        this.caracter = caracter;
        this.senhas = senhas;
        this.caracterCompleto = caracterCompleto;
        this.checker = checker;
    }


    @Override
    public void run() {
        for (String senha : this.senhas) {
            for (char a : this.caracter) {
                for (char b : this.caracterCompleto) {
                    for (char c : this.caracterCompleto) {
                        for (char d : this.caracterCompleto) {
                            for (char e : this.caracterCompleto) {
                                String tentativa = String.valueOf(a) + String.valueOf(b) + String.valueOf(c) + String.valueOf(d)
                                        + String.valueOf(e);
                                if (BreakPassword.md5(tentativa).equals(senha)) {
                                    System.out.println("Senha encontrada!");
                                    System.out.println("Hash: " + senha);
                                    System.out.println("Senha: " + tentativa);
                                    if (this.checker.setTrue(senhas.indexOf(senha))) {
                                        Thread.currentThread().getThreadGroup().stop();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
