package com.icexxx.icetask;

import cn.hutool.core.util.ReflectUtil;

public class IceReflect {
    public static <T> Object invoke(String className, String methodName, Object... params) {
        T object = (T) ObjectContext.get(className);
        return ReflectUtil.invoke(object, methodName, params);
    }
}
