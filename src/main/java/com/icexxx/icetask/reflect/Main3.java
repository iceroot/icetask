package com.icexxx.icetask.reflect;

import java.util.Date;

import org.omg.PortableServer.THREAD_POLICY_ID;

import com.icexxx.icetask.IceTaskService;
import com.icexxx.icetask.SimpleIceTask;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;

public class Main3 {

    public static void main(String[] args) {
        SimpleIceTask<Object> task = new SimpleIceTask<Object>("2017-01-01", "com.icexxx.icetask.reflect.BookService",
                "add", 15);
        SimpleIceTask<Object> task2 = new SimpleIceTask<Object>("2017-01-01", "com.icexxx.icetask.reflect.BookService",
                "cancel", 17);
        SimpleIceTask<Object> task3 = new SimpleIceTask<Object>("2017-01-01", "com.icexxx.icetask.reflect.BookService",
                "tixing", 19);
        System.out.println("now=" + DateUtil.formatDateTime(new Date()));
        IceTaskService.add(task, 5);
        IceTaskService.add(task2, 5);
        IceTaskService.add(task3, 5);
        IceTaskService.start();
        new Thread() {
            public void run() {
                for (int i = 0; i < 600; i++) {
                    ThreadUtil.sleep(1000);
                }
                IceTaskService.stop();
            }
        }.start();
    }

}
