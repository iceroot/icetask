package com.icexxx.icetask.reflect;

public class BookService {
    public void add() {
        System.out.println("add");
    }

    public static void add(int num) {
        System.out.println("num=" + num);
    }

    public static void cancel(int num) {
        System.out.println("cancel=" + num);
    }

    public static void tixing(int num) {
        System.out.println("tixing=" + num);
    }
}
