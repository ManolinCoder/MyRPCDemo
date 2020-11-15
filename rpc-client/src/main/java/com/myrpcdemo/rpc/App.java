package com.myrpcdemo.rpc;

import jdk.nashorn.internal.ir.annotations.Reference;

/**
 * Hello world!
 */
public class App {


    // @Reference//dubbo使用，手写实现

    ILearnRPCService iLearnRPCService;//动态代理



    public  void learn(){
        iLearnRPCService.learnRPC("基于Dubbo原理分析实现手写RPC");
    }


    public static void main(String[] args) {

        final RpcProxyClient rpcProxyClient = new RpcProxyClient();
        final ILearnRPCService iLearnRPCService = rpcProxyClient.clientProxy(ILearnRPCService.class, "localhost", 8080);


        System.out.println(iLearnRPCService.learnRPC("基于Dubbo原理分析实现手写RPC"));



    }
}
