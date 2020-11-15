package com.myrpcdemo.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//重写InvocationHandler代理方法
public class RemoteInvocationHandler implements InvocationHandler {

    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //完成网络逻辑通信
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParameters(args);
        rpcRequest.setTypes(method.getParameterTypes());


        RpcNetTransport rpcNetTransport=new RpcNetTransport(host,port);
        return rpcNetTransport.sendRequest(rpcRequest);







    }


}
