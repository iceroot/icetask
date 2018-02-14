package com.icexxx.icetask;

import java.util.HashMap;
import java.util.Map;

import cn.hutool.core.util.ReflectUtil;

public class ObjectContext {
    private static Map<String, Object> map;

    public static Object get(String className) {
        if (map == null) {
            map = new HashMap<String, Object>();
        }
        Object object = map.get(className);
        if (object == null) {
            object = ReflectUtil.newInstance(className);
            map.put(className, object);
        }
        return object;
    }
}
