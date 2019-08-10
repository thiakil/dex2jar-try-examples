package com.thiakil.codegen;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestTryWithResources {
    void testCaught(){
        try (InputStream is = new FileInputStream("foo")) {
            int testRead = is.read();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    void testThrown() throws IOException {
        try (InputStream is = new FileInputStream("foo")) {
            int testRead = is.read();
        }
    }

    void testThrownTwoStreams() throws IOException {
        try (InputStream is = new FileInputStream("foo"); OutputStream os = new FileOutputStream("fos")) {
            int testRead = is.read();
        }
    }
}
