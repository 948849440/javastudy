package com.summer.rpc.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class HelloServer {

    public static void main(String[] args) {
        try {
            ISayHello sayHello = new SayHelloImpl();
            //ISayHi sayHi = new SayHiImpl();
            LocateRegistry.createRegistry(8888);
            Naming.bind("rmi://localhost:8888/sayHello",sayHello);
            //Naming.bind("rmi://localhost:8888/hi",sayHi);
            System.out.println("server start");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
