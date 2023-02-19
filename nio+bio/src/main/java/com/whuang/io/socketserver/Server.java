package com.whuang.io.socketserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        //创建服务端socket服务
        ServerSocket serverSocket = new ServerSocket(8081);
        //监听客户端请求，得到socket管道
        Socket socket = serverSocket.accept();
        //从管道中获取流
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(inputStream));

        char[] msg = new char[1024];
        while (bufferedInputStream.read(msg, 0, 1024) > 0) {
            System.out.println(msg);
        }
        
//        String msg;
//        if ((msg = bufferedInputStream.readLine()) != null) {
//            System.out.println(msg);
//        }


    }
}
