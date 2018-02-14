package com.icexxx.icetask.reflect;

import cn.hutool.core.thread.ThreadUtil;

public class Main2 {

    public static void main(String[] args) {
        String[] strs = { "aaa", "bbb", "ccc", "ddd", "eee" };
        for (int i = 0; i < strs.length; i++) {
            ThreadUtil.sleep(1000);
            System.out.println(strs[i]);
            if (i == strs.length - 1) {
                i = -1;
            }
        }

    }

}
