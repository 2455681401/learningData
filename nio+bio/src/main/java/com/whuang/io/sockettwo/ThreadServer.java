package com.whuang.io.sockettwo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadServer {
    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ServerSocket serverSocket = new ServerSocket(8001);
        while (true) {
            Socket socket = serverSocket.accept();
            executorService.execute(() -> {
                try {
                    InputStream inputStream = socket.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String msg;
                    while ((msg = bufferedReader.readLine()) != null) {
                        System.out.println(msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
