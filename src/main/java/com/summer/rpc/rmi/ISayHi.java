package com.summer.rpc.rmi;

import java.rmi.Remote;

public interface ISayHi extends Remote {
    String sayHi(String gg);
}
