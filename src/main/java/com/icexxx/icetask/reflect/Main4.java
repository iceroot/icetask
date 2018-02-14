package com.icexxx.icetask.reflect;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;

public class Main4 {

    public static void main(String[] args) {
        // int timeToSecond = DateUtil.timeToSecond("1:1:06");
        // System.out.println(timeToSecond);
        System.out.println(StrUtil.count("12:25:36", ":"));
        System.out.println(StrUtil.count("12m25m36", ":"));
        System.out.println(StrUtil.count("12:2", ":"));
        ThreadUtil.sleep(-1);
        System.out.println(StrUtil.count("12:25:36", ":"));
    }

}
