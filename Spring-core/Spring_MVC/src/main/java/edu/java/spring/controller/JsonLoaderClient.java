package edu.java.spring.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class JsonLoaderClient {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8081/clazz/json");
        URLConnection connection = url.openConnection();
        connection.addRequestProperty("Accept","Application/json");
        InputStream stream = connection.getInputStream();

        int read = 0;
        byte[] bytes = new byte[4*1024];
        while ((read == stream.read(bytes))){
            System.out.println(new String(bytes,0,read));
        }
    }
}
