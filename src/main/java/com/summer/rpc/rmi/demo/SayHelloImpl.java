package com.summer.rpc.rmi.demo;


public class SayHelloImpl implements ISayHello{

    @Override
    public String sayHello(String name){
        return "Hello Xia:"+name;
    }

    @Override
    public String sayTest(){
        return "test";
    }
}
