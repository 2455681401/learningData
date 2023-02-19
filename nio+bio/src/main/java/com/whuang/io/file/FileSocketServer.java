package com.whuang.io.file;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.channels.Channel;
import java.util.UUID;

public class FileSocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(999);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String fileName = dataInputStream.readUTF();
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\yellowTea\\Desktop\\新建文件夹\\"
                + UUID.randomUUID().toString() + fileName);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = dataInputStream.read(bytes, 0, 1024)) > 0) {
            fileOutputStream.write(bytes);
        }
        fileOutputStream.flush();
    }
}
