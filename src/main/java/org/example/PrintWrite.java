package org.example;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintWrite {
    public void printWrite(String data, String parse){
        PrintWriter writer;
        try {
            writer = new PrintWriter(data);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        writer.write(String.valueOf(parse));
        writer.close();
        writer.flush();
    }
}
