package com.summer.rpc.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SayHiImpl extends UnicastRemoteObject implements ISayHi{

    protected SayHiImpl() throws RemoteException {
    }

    public String sayHi(String gg) {
        return "Hi Xia:"+gg;
    }
}
