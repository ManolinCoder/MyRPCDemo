package com.myrpcdemo.rpc;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcProxyServer {


    public void publisher(Object service, int port) {

        ServerSocket serverSocket = null;

        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);


        try {
            //监听8080端口
            serverSocket = new ServerSocket(8080);

            //while循环持续接受请求
            while (true) {
                //     收到一个客户端请求，如果客户端没有发送过来，则处于阻塞状态
                Socket socket = serverSocket.accept();

                //BIO(同步阻塞) ->基于线程池的优化  -NIO(Netty)
                //    获得一个输入流，来自客户端的输出 导致阻塞
                //     socket.getInputStream();
                executorService.execute(new ProcessorHandler(socket,service));

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
