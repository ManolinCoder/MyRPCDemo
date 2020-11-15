package com.myrpcdemo.rpc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ILearnRPCService iLearnRPCService=new LearnRPCServiceImpl();
        RpcProxyServer proxyServer=new RpcProxyServer();
        proxyServer.publisher(iLearnRPCService,8080);


    }
}
