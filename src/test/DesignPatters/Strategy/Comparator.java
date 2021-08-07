package test.DesignPatters.Strategy;

/**
 * @Auther: zhongj
 * @Date: 2021/8/7 - 08 - 07 - 15:23
 * @Description: test.DesignPatters.Strategy
 * @version: 1.0
 */
public interface Comparator<T> {
    public int compareTo(T o1,T o2);

    default void m1(){
        System.out.println("jdk1.8 and later supported");
    }
}
