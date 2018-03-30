package com.icexxx.icetask;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;

public class IceTaskThread extends Thread {
    private static boolean isRun;

    public static boolean isRun() {
        return isRun;
    }

    public static void setRun(boolean isRun) {
        IceTaskThread.isRun = isRun;
    }

    @Override
    public void run() {
        IceTaskWrap[] tasks = TaskConext.getTasks();
        String time = DateUtil.format(new Date(), "HH:mm:ss");
        int timeToSecond = DateUtil.timeToSecond(time);
        long corrent = 0;
        long start = 0;
        long end = 0;
        for (int i = timeToSecond; i < tasks.length; i++) {
            if (!isRun) {
                break;
            }
            corrent = end - start;
            if (corrent < 0) {
                corrent = 0;
            }
            if (corrent > 1000) {
                corrent = 1000;
            }
            ThreadUtil.sleep(1000 - corrent);
            start = System.currentTimeMillis();
            IceTaskWrap wrap = tasks[i];
            if (wrap != null) {
                final Map<String, IceTask> taskMap = wrap.getTaskMap();
                new Thread() {
                    public void run() {
                        Set<Entry<String, IceTask>> entrySet = taskMap.entrySet();
                        List<Entry<String, IceTask>> list = new ArrayList<Entry<String, IceTask>>(entrySet);
                        for (int j = 0; j < list.size(); j++) {
                            Entry<String, IceTask> entry = list.get(j);
                            IceTask iceTask = entry.getValue();
                            String className = iceTask.getClassName();
                            String methodName = iceTask.getMethodName();
                            List paramsList = iceTask.getParamsList();
                            Object[] params = new Object[paramsList.size()];
                            for (int k = 0; k < paramsList.size(); k++) {
                                params[k] = paramsList.get(k);
                            }
                            IceReflect.invoke(className, methodName, params);
                        }
                    }
                }.start();
            }
            if (i == tasks.length - 1) {
                TaskConext.clear();
                i = -1;
            }
            end = System.currentTimeMillis();
        }
    }
}
