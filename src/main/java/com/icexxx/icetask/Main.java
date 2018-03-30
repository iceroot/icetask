package com.icexxx.icetask;

public class Main {

    public static void main(String[] args) {
        TaskConext create = TaskConext.create();
        SimpleIceTask<Object> task = new SimpleIceTask<Object>("2017-01-01", "com1", "method1", "NO1234");
        SimpleIceTask<Object> task2 = new SimpleIceTask<Object>("2017-01-01", "com1", "method2", "NO7890");
        create.add(task, 5);
        create.add(task2, 4);
        IceTaskWrap[] ts = create.getTasks();
        print(ts);
    }

    // private static String print(IceTask<Object>[] ts) {
    // for (int i = 0; i < 10; i++) {
    // System.out.println(i+">>>"+ts[i]);
    // }
    // return null;
    // }
    private static String print(IceTaskWrap[] ts) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ">>>" + ts[i]);
        }
        return null;
    }

}
