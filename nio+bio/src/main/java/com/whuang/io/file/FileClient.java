package com.whuang.io.file;

import java.io.*;
import java.net.Socket;

public class FileClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 999);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        File file = new File("C:\\Users\\Public\\Desktop\\企业微信.lnk");
        FileInputStream fileInputStream = new FileInputStream(file);
        dataOutputStream.writeUTF(file.getName());


        byte[] bytes = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bytes, 0, 1024)) > 0) {
            dataOutputStream.write(bytes, 0 ,len);
        }

        dataOutputStream.flush();
        socket.shutdownOutput();

    }
}
