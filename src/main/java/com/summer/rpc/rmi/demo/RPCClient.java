package com.summer.rpc.rmi.demo;

import com.summer.rpc.rmi.ISayHello;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.rmi.RemoteException;

public class RPCClient {

    public static void main(String args[]) throws RemoteException {
        ISayHello iSayHello = getClient(ISayHello.class, "127.0.0.1", 50001);
        System.out.println(iSayHello.sayHello("123"));
    }

    @SuppressWarnings("unchecked")
    public static <T> T getClient(Class<T> clazz, String ip, int port){
        return  (T) Proxy.newProxyInstance(RPCClient.class.getClassLoader(), new Class<?>[]{clazz}, new InvocationHandler() {

            @Override
            public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
                Socket socket = new Socket(ip, port);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeUTF(arg1.getName());
                out.writeObject(arg1.getParameterTypes());
                out.writeObject(arg2);
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                return in.readObject();
            }
        });
    }
}

