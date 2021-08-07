package test.DesignPatters.Singleton;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: zhongj
 * @Date: 2021/8/3 - 08 - 03 - 22:59
 * @Description: 懒汉式-存在线程安全问题-加锁(双重检查)
 * @version: 1.0
 */
public class Mgr03 {
    private static Mgr03 INSTANCE = null;

    private Mgr03(){

    }

    public static Mgr03 getInstance(){
        if(INSTANCE == null){
            synchronized(Mgr03.class){
                if(INSTANCE == null){
                    try {
                        TimeUnit.MILLISECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr03();
                }
            }
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("You Get My Single INSTANCE Success !");
    }

}
