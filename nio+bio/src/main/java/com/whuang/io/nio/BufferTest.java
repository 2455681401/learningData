package com.whuang.io.nio;
import org.junit.Test;
import sun.nio.ch.SelectionKeyImpl;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.LongBuffer;
import java.nio.channels.*;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.Set;

public class BufferTest {

    @Test
    public void test01() throws  Exception {
        LongBuffer allocate = LongBuffer.allocate(100);
        allocate.flip();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10);

        FileInputStream fileInputStream = new FileInputStream("");
        FileChannel channel = fileInputStream.getChannel();


        ServerSocket serverSocket = new ServerSocket(111);
        serverSocket.getChannel();



    }

    @Test
    public void adfa () throws Exception {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        byteBuffer.put("缓冲区写入通道是从position当前位置开始，所以在缓冲区内插入数据后需要在将缓冲区的position指针重新归位到0位置！".getBytes());
        byteBuffer.flip();
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\yellowTea\\Desktop\\新建文件夹\\huangwei.txt");
        FileChannel channel = fileOutputStream.getChannel();
        channel.write(byteBuffer);
    }

    @Test
    public void channelFileInPut () throws Exception {
        FileInputStream is = new FileInputStream("C:\\Users\\yellowTea\\Desktop\\新建文件夹\\huangwei.txt");
        FileChannel channel = is.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        buffer.flip();

        String s = new String(buffer.array(), 0, buffer.remaining());
        System.out.println(s);
        System.out.println("dasfaf");
    }

    /**
     * 使用nio文件通道实现文件的复制
     * @throws Exception
     */
    @Test
    public void channelCopyFile() throws  Exception {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\yellowTea\\Desktop\\新建文件夹\\huangwei.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\yellowTea\\Desktop\\新建文件夹\\huangwei-copy.txt");
        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();
        ByteBuffer bf = ByteBuffer.allocate(1024);
        while (inChannel.read(bf) > 0) {
            bf.flip();
            outChannel.write(bf);
            bf.clear();
        }
        inChannel.close();
        outChannel.close();
    }

    @Test
    public void channelCopyFile2() throws  Exception {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\yellowTea\\Desktop\\新建文件夹\\huangwei.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\yellowTea\\Desktop\\新建文件夹\\huangwei-copy.txt");
        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();
        ByteBuffer[] bf = {ByteBuffer.allocate(1024), ByteBuffer.allocate(1024)};
        //使用多个缓冲区分散、聚集读写传输数据，并且每次读取1k数据
        while (inChannel.read(bf) > 0) {
            for(ByteBuffer b : bf)
                b.flip();
            outChannel.write(bf);
            for(ByteBuffer b : bf)
                b.clear();
        }
        inChannel.close();
        outChannel.close();
    }

    @Test
    public void selectorChannel() throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        SocketChannel accept = channel.accept();
        SocketChannel bind = accept.bind(new InetSocketAddress(1));

        Selector selector = Selector.open();
        channel.register(selector, SelectionKey.OP_ACCEPT & SelectionKey.OP_READ);
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = selectionKeys.iterator();
        SelectionKey next = iterator.next();
        SocketChannel channel1 = (SocketChannel) next.channel();

        

        int select = selector.select();

        ServerSocket serverSocket = new ServerSocket(12);
        serverSocket.accept();


    }
}
