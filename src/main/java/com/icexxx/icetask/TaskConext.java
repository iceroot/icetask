package com.icexxx.icetask;

import java.util.ArrayList;
import java.util.List;

public class TaskConext {
    private static IceTaskWrap[] tasks = new IceTaskWrap[86400];
    private static List<IceTask<Object>> delayTask = new ArrayList<IceTask<Object>>();
    private static TaskConext taskConext = new TaskConext();

    private TaskConext() {

    }

    public static TaskConext create() {
        return taskConext;
    }

    public static <T> void add(SimpleIceTask<T> task, int index) {
        IceTaskWrap iceTaskWrap = (IceTaskWrap) (tasks[index]);
        if (iceTaskWrap == null) {
            iceTaskWrap = new IceTaskWrap();
            iceTaskWrap.put(task);
            tasks[index] = iceTaskWrap;
        } else {
            iceTaskWrap.put(task);
        }

    }

    public static void clear() {
        tasks = new IceTaskWrap[86400];
    }

    public static IceTaskWrap[] getTasks() {
        return tasks;
    }

    public static void setTasks(IceTaskWrap[] tasks) {
        TaskConext.tasks = tasks;
    }
}
