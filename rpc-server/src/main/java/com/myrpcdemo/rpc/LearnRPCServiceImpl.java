package com.myrpcdemo.rpc;


public class LearnRPCServiceImpl implements ILearnRPCService {


    @Override
    public String learnRPC(String str) {

        System.out.println("服务端接收到："+str);
        return "客户端发送到： "+str;
    }



}
