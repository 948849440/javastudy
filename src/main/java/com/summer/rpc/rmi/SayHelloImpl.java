package com.summer.rpc.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SayHelloImpl extends UnicastRemoteObject implements ISayHello{

    protected SayHelloImpl() throws RemoteException {
    }

    public String sayHello(String name) throws RemoteException {
        return "Hello Xia:"+name;
    }

    @Override
    public String sayTest() throws RemoteException {
        return "test";
    }
}
