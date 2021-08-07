package test.DesignPatters.Singleton;

/**
 * @Author: zhongj
 * @Date: 2021/8/4 - 08 - 04 - 0:23
 * @Description:  不仅可以解决线程同步，还可以防止反序列化。
 * @version: 1.0
 */
public enum Mgr04 {
    INSTANCE1;

    public void m(){
        System.out.println("You Get My Single INSTANCE Success !");
    }

}
