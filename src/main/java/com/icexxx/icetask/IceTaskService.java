package com.icexxx.icetask;

import java.util.Date;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;

public class IceTaskService {
    private static IceTaskThread thread;

    public static void start() {
        if (thread == null) {
            thread = new IceTaskThread();
        } else {
            IceTaskThread.setRun(false);
            ThreadUtil.sleep(5000);
        }
        IceTaskThread.setRun(true);
        thread.start();
    }

    public static void stop() {
        IceTaskThread.setRun(false);
        ThreadUtil.sleep(5000);
    }

    public static void add(SimpleIceTask<Object> task, int delay) {
        String time = DateUtil.format(new Date(), "HH:mm:ss");
        int timeToSecond = DateUtil.timeToSecond(time);
        int index = timeToSecond + delay;
        TaskConext.add(task, index);
    }

    public static void add(SimpleIceTask<Object> task, String timeStr) {
        int count = StrUtil.count(timeStr, ":");
        if (count != 1 && count != 2) {
            throw new RuntimeException("时间格式不正确:" + timeStr);
        }
        if (count == 1) {
            timeStr += ":00";
        }
        int timeToSecond = DateUtil.timeToSecond(timeStr);
        TaskConext.add(task, timeToSecond);
    }
}
