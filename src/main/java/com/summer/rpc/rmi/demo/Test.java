package com.summer.rpc.rmi.demo;

import java.rmi.RemoteException;

public class Test {

    public static void main(String[] args) throws RemoteException {
        ISayHello iSayHello = new SayHelloImpl();
        RPCServer server = new RPCServer();
        server.register(iSayHello, 50001);
    }
}
