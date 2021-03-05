package com.github.vslyusarev.march8;

public class Decoder {
    public String decode(String data, String key) {

        byte[] dataBytes = data.getBytes();
        byte[] keyBytes = key.getBytes();

        if (dataBytes.length > keyBytes.length) {
            throw new IllegalArgumentException("too short key");
        }

        byte[] result = new byte[data.length()];
        for (int i = 0; i < dataBytes.length; i++) {
            result[i] = (byte) (dataBytes[i] ^ keyBytes[i]);
        }

        return new String(result);
    }
}
