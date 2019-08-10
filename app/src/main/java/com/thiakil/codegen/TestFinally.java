package com.thiakil.codegen;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TestFinally {
    public static void singleFinallyNoCatch(InputStream is) throws IOException {
        System.out.println("Single finally clause, IOException not caught");
        try {
            int b = is.read();
        } finally{
            is.close();
        }
    }

    public static void singleFinallyCaught(InputStream is) {
        System.out.println("Single finally clause, IOException caught by main & finally");
        try {
            int b = is.read();
        } catch (IOException e){
            System.out.println("Failed!");
            e.printStackTrace();
        } finally{
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void dualFinallyNoCatch(InputStream is, OutputStream os) throws IOException {
        System.out.println("2 finally clauses (nested), IOException not caught");
        try {
            int b = is.read();
            try {
                os.write(b);
            } finally {
                os.close();
            }
        } finally{
            is.close();
        }
    }

    public static void dualFinallyCaught(InputStream is, OutputStream os)  {
        System.out.println("2 finally clauses (nested), IOException caught at every level");
        try {
            int b = is.read();
            try {
                os.write(b);
            } catch (IOException e){
                System.out.println("Failed!");
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e){
            System.out.println("Failed!");
            e.printStackTrace();
        } finally{
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void dualFinallyCaught2(InputStream is, OutputStream os)  {
        System.out.println("dualFinallyCaught, but with early in first try");
        try {
            int b = is.read();
            if (b == 123){
                return;
            }
            try {
                os.write(b);
            } catch (IOException e){
                System.out.println("Failed!");
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e){
            System.out.println("Failed!");
            e.printStackTrace();
        } finally{
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
