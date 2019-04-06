package com.github.pedrohcs.aula0204.exercicio8;

import java.util.Calendar;
import java.util.Date;

public class GeradorDeHora implements Runnable {

    private boolean condicional = true;

    @Override
    public void run() {
        int contador = 0;
        while (condicional) {
            Date data = Calendar.getInstance().getTime();
            System.out.println(String.format("Momento Hora certa\n%s:%s:%s",
                    data.getHours(), data.getMinutes(), data.getSeconds()));
            contador ++;
            if (contador == 5){
                System.exit(0);
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
