package test.DesignPatters.Singleton;

/**
 * @Auther: zhongj
 * @Date: 2021/8/3 - 08 - 03 - 22:48
 * @Description: 饿汉式
 * @version: 1.0
 */
public class Mgr01 {
    private static final Mgr01 INSTANCE = new Mgr01();

    private Mgr01(){

    }

    public static Mgr01 getInstance(){
        return INSTANCE;
    }

    public void m(){
        System.out.println("You Get My Single INSTANCE Success !");
    }
}
