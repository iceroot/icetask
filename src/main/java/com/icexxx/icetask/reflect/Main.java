package com.icexxx.icetask.reflect;

import com.icexxx.icetask.IceReflect;

public class Main {

    public static void main(String[] args) {
        IceReflect.invoke("com.icexxx.icetask.reflect.BookService", "add", 15);
    }

}
