package com.zj.tank.util;

import java.io.IOException;
import java.util.Properties;

/**
 * @Auther: zhongj
 * @Date: 2021/8/2 - 08 - 02 - 22:49
 * @Description: 读取配置信息——单例模式
 * @version: 1.0
 */
public class PropertyMgr_Singleton {
    private Properties props = new Properties();
    private static PropertyMgr_Singleton obj = null;
    private PropertyMgr_Singleton(){
        try {
            props.load(PropertyMgr_Singleton.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object get(String key){
        if (props == null) return null;
        return props.get(key);
    }

    public static PropertyMgr_Singleton getObj(){
        if(obj == null ){
            return obj = new PropertyMgr_Singleton();
        }
        return obj;
    }

    public static void main(String[] args) {
        System.out.println(PropertyMgr_Singleton.getObj().get("initEnemyTankCount"));
        System.out.println(PropertyMgr_Singleton.getObj()==PropertyMgr_Singleton.getObj());
    }

}
