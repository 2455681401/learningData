package com.whuang.io.sockettwo;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8001);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String msg = scanner.nextLine();
            printWriter.println(msg);
            printWriter.flush();
        }
    }
}
