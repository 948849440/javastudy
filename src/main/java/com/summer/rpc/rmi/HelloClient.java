package com.summer.rpc.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class HelloClient {

    public static void main(String[] args) {
        try {
            ISayHello hello = (ISayHello) Naming.lookup("rmi://localhost:8888/sayHello");
            System.out.print(hello.sayHello("hello xia"));
            System.out.print(hello.sayTest());

            //ISayHi sayHi = (ISayHi) Naming.lookup("rmi://localhost:8888/sayHi");
            //System.out.print(sayHi.sayHi("hi xia"));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
