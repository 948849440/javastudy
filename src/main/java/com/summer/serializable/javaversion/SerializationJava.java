package com.summer.serializable.javaversion;

import java.io.*;

public class SerializationJava {

    public byte[] serialize(Object object) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(baos);
        os.writeObject(object);
        return baos.toByteArray();
    }

    public Object unserialize(byte[] objByteArray) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(objByteArray);
        ObjectInputStream obis = new ObjectInputStream(bais);
        return obis.readObject();
    }
}
