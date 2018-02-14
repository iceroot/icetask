package com.icexxx.icetask;

public class SimpleIceTask<T> {
    private String time;
    private String className;
    private String methodName;
    private T param;

    public SimpleIceTask() {

    }

    public SimpleIceTask(String time, String className, String methodName, T param) {
        this.time = time;
        this.className = className;
        this.methodName = methodName;
        this.param = param;
    }

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

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "SimpleIceTask [time=" + time + ", className=" + className + ", methodName=" + methodName + ", param="
                + param + "]";
    }
}
