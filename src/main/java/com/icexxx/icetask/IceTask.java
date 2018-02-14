package com.icexxx.icetask;

import java.util.List;

public class IceTask<T> {
    private String time;
    private String className;
    private String methodName;
    private Integer delay;
    private List<T> paramsList;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public List<T> getParamsList() {
        return paramsList;
    }

    public void setParamsList(List<T> paramsList) {
        this.paramsList = paramsList;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    @Override
    public String toString() {
        return "IceTask [time=" + time + ", className=" + className + ", methodName=" + methodName + ", delay=" + delay
                + ", paramsList=" + paramsList + "]";
    }

}
