package com.zj.tank.util;

import java.io.IOException;
import java.util.Properties;

/**
 * @Auther: zhongj
 * @Date: 2021/8/2 - 08 - 02 - 22:49
 * @Description: 读取配置信息
 * @version: 1.0
 */
public class PropertyMgr {
    static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key){
        if (props == null) return null;
        return props.get(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initEnemyTankCount"));
    }
}
