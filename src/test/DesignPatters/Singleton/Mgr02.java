package test.DesignPatters.Singleton;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: zhongj
 * @Date: 2021/8/3 - 08 - 03 - 22:59
 * @Description: 懒汉式-存在线程安全问题
 * @version: 1.0
 */
public class Mgr02 {
    private static Mgr02 INSTANCE = null;

    private Mgr02(){

    }

    public static Mgr02 getInstance(){
        if(INSTANCE == null){
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr02();
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("You Get My Single INSTANCE Success !");
    }

}
