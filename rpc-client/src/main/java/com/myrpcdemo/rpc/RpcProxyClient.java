package com.myrpcdemo.rpc;


import java.lang.reflect.Proxy;

//动态代理 代理接口ILearnService

public class RpcProxyClient {


    public <T> T clientProxy(final Class<T> interfaceCls, final String host, int port) {
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class<?>[]{interfaceCls}, new RemoteInvocationHandler(host, port));
    }

}
