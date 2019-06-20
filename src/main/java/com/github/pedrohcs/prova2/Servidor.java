package com.github.pedrohcs.prova2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;

public class Servidor {
    private static ServerSocket server;
    private static int port = 2222;

    private static int quantityThreads;
    private static String begin;
    private static String end;
    private static int numsBegin[] = new int[4];
    private static int numsEnd[] = new int[4];
    private static long quantityIps;

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        server = new ServerSocket(port);

        while(true) {
            System.out.println("Esperando mensagem do Client...");
            Socket socket = server.accept();
            ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());
            Map<String, String> request = (Map<String, String>) objectInput.readObject();

            quantityThreads = Integer.parseInt(request.get("quantitythreads"));
            begin = request.get("begin");
            end = request.get("end");

            Thread[] threads = new Thread[quantityThreads];
            SearchIp[] threadsIp = new SearchIp[quantityThreads];
            ArrayList<String> validIps = new ArrayList<>();

            convertIps(begin, end);
            quantityIps();
            int division = (int) (quantityIps / quantityThreads);
            int initialIp, lastIp;

            for (int cont1 = 0; cont1 < quantityThreads; cont1++) {
                if (cont1 == (quantityThreads - 1)) {
                    initialIp = cont1 * division;
                    lastIp = (int) ((cont1 * division) + division - 1 + (quantityIps % quantityThreads));
                    SearchIp searchIpThread = new SearchIp(initialIp, lastIp, numsBegin);
                    threadsIp[cont1] = searchIpThread;
                    threads[cont1] = new Thread(searchIpThread);
                    threads[cont1].start();
                }
                initialIp = cont1 * division;
                lastIp = (cont1 * division) + division;
                SearchIp searchIpThread = new SearchIp(initialIp, lastIp, numsBegin);
                threadsIp[cont1] = searchIpThread;
                threads[cont1] = new Thread(searchIpThread);
                threads[cont1].start();
            }

            for (Thread t : threads) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (SearchIp t : threadsIp) {
                ArrayList<String> ips = t.getValidIps();
                for (String ip : ips) {
                    validIps.add(ip);
                }
            }

            ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
            objectOutput.writeObject(validIps);

            objectInput.close();
            objectOutput.close();
            socket.close();

            break;
        }
    }

    private static void convertIps(String inicio, String fim){
        String [] inicioSplit = inicio.split("\\.");
        String [] fimSplit = fim.split("\\.");
        int cont = 0;
        while (cont < 4){
            numsBegin[cont] = Integer.parseInt(inicioSplit[cont]);
            numsEnd[cont] = Integer.parseInt(fimSplit[cont]);
            cont++;
        }
    }

    private static void quantityIps(){
        long quantityIpBegin = numsBegin[0] * (long) Math.pow(256, 3) +
                            numsBegin[1] * (long) Math.pow(256, 2) +
                            numsBegin[2] * 256 +
                            numsBegin[3];

        long quantityIpEnd = numsEnd[0] * (long) Math.pow(256, 3) +
                    numsEnd[1] * (long) Math.pow(256, 2) +
                    numsEnd[2] * 256 +
                    numsEnd[3];

        quantityIps = quantityIpEnd - quantityIpBegin + 1;
    }


}
