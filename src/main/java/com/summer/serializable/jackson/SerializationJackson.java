package com.summer.serializable.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.summer.serializable.model.People;

public class SerializationJackson {

    public byte[] serialize(Object object) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsBytes(object);
    }

    public Object unserialize(byte[] objByteArray) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(objByteArray, People.class);
    }
}
