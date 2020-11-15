package com.myrpcdemo.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class ProcessorHandler implements Runnable {

    private Socket socket;
    private Object service;

    public ProcessorHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {


    //    进入这里，说明当前服务端已经接收到客户端的请求
        try(ObjectInputStream inputStream=new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream=new ObjectOutputStream(socket.getOutputStream())) {



            // TODO
            //客户端读取数据
           RpcRequest rpcRequest=(RpcRequest) inputStream.readObject();//

        //    收到请求
         Object result = invoke(rpcRequest);
         outputStream.writeObject(result);
         outputStream.flush();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    //进行发射调用过程
    private  Object invoke(RpcRequest rpcRequest) throws Exception {

        Object[] args=rpcRequest.getParameters();
        Class clazz=Class.forName(rpcRequest.getClassName());
        Method method=clazz.getMethod(rpcRequest.getMethodName(),rpcRequest.getTypes());
        Object result=method.invoke(service,args);
        return result;

    }



}
