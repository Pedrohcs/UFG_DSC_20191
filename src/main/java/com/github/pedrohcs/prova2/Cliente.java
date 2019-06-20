package com.github.pedrohcs.prova2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {

        Map<String, String> request = new HashMap<String, String>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de Threads: ");
        request.put("quantitythreads", scanner.next());

        System.out.print("Digite o IP inicial: ");
        request.put("begin", scanner.next());

        System.out.print("Digite o IP final: ");
        request.put("end", scanner.next());

        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream objectOutput = null;
        ObjectInputStream objectInput = null;
        socket = new Socket(host.getHostName(), 2222);

        objectOutput = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("\nComunicando com o servidor");
        objectOutput.writeObject(request);

        objectInput = new ObjectInputStream(socket.getInputStream());
        ArrayList<String> message = (ArrayList<String>) objectInput.readObject();
        System.out.println("Lista de Ip validos:");
        System.out.println(message);

        objectInput.close();
        objectOutput.close();
        Thread.sleep(100);
    }
}
