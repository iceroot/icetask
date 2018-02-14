package com.icexxx.icetask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IceTaskWrap {
    private Map<String, IceTask> taskMap;

    public Map<String, IceTask> getTaskMap() {
        return taskMap;
    }

    public void setTaskMap(Map<String, IceTask> taskMap) {
        this.taskMap = taskMap;
    }

    // public void put(String key,IceTask iceTask){
    // if(taskMap==null){
    // taskMap=new HashMap<String,IceTask>();
    // }
    // taskMap.put(key, iceTask);
    // }
    public <T> void put(SimpleIceTask<T> iceTask) {
        String className = iceTask.getClassName();
        String methodName = iceTask.getMethodName();
        String key = className + ">" + methodName;
        if (taskMap == null) {
            taskMap = new HashMap<String, IceTask>();
            String time = iceTask.getTime();
            T param = (T) iceTask.getParam();
            List<T> paramsList = new ArrayList<T>();
            paramsList.add(param);

            IceTask<T> value = new IceTask<T>();
            value.setClassName(className);
            value.setMethodName(methodName);
            value.setTime(time);
            value.setParamsList(paramsList);
            taskMap.put(key, value);
        } else {
            IceTask<T> iceTaskOld = taskMap.get(key);
            T param = (T) iceTask.getParam();
            if (iceTaskOld == null) {
                iceTaskOld = new IceTask<T>();
                iceTaskOld.setClassName(className);
                iceTaskOld.setMethodName(methodName);

                List<T> paramsList = new ArrayList<T>();
                paramsList.add(param);
                iceTaskOld.setParamsList(paramsList);
                taskMap.put(key, iceTaskOld);
            } else {
                List<T> paramsList = iceTaskOld.getParamsList();
                // paramsList存在
                paramsList.add(param);
            }
        }
    }

    @Override
    public String toString() {
        return "IceTaskWrap [taskMap=" + taskMap + "]";
    }
}
