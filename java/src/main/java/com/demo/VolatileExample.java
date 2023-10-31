package com.demo;

import java.io.Writer;

public class VolatileExample {
    int x = 0;
    boolean v = false;

    public void writer() {
        x = 42;
        v = true;
    }

    public void reader() {
        while (!v) {
            System.out.println("===========");
        }
    }

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();
        new Thread(() -> {
            example.reader();
        }).start();
        new Thread(() -> {
            example.writer();
        }).start();

    }
}