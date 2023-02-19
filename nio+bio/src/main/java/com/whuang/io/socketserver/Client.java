package com.whuang.io.socketserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8081);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("发送消息：");
            printWriter.println(scanner.nextLine());
            printWriter.flush();
        }

//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
//        bufferedWriter.write("i'm yellow!");
//        bufferedWriter.flush();
    }
}
