package com.summer.serializable;

import com.summer.serializable.jackson.SerializationJackson;
import com.summer.serializable.javaversion.SerializationJava;
import com.summer.serializable.model.People;

public class TimeCount {

    private static int testTimes = 1000;
    public static void main(String[] args) throws Exception {
        testJava();
        testJackson();
    }

    public static void testJava() throws Exception{
        SerializationJava serializationJava = new SerializationJava();
        long start = System.currentTimeMillis();
        byte[] objArray = null;
        for (int i = 0; i < testTimes; i++) {
            People people = new People();
            people.init();
            objArray = serializationJava.serialize(people);
        }
        long end1 = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            People people = new People();
            people.init();
            objArray = serializationJava.serialize(people);
            People people2 = (People)serializationJava.unserialize(objArray);
        }
        long end2 = System.currentTimeMillis();
        System.out.print("java serialize:"+(end1 - start)+"\n");
        System.out.print("java All:"+(end2 - end1)+"\n");
        System.out.print("java size:"+objArray.length+"\n");
    }

    public static void testJackson() throws Exception{
        SerializationJackson serializationJackson = new SerializationJackson();
        byte[] objArray = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            People people = new People();
            people.init();
            objArray = serializationJackson.serialize(people);
        }
        long end1 = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            People people = new People();
            people.init();
            objArray = serializationJackson.serialize(people);
            People people2 = (People)serializationJackson.unserialize(objArray);
        }
        long end2 = System.currentTimeMillis();
        System.out.print("jackson serialize:"+(end1 - start)+"\n");
        System.out.print("jackson All:"+(end2 - end1)+"\n");
        System.out.print("jackson size:"+objArray.length+"\n");
    }
}
