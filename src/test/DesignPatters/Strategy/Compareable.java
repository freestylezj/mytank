package test.DesignPatters.Strategy;

/**
 * @Auther: zhongj
 * @Date: 2021/8/7 - 08 - 07 - 15:07
 * @Description: test.DesignPatters.Strategy
 * @version: 1.0
 */
public interface Compareable<T> {
    public int compareTO(T t);

    default public int compareTO2(){
        System.out.println("default method");
        return 1;
    }

    default public int compareTO3(){
        System.out.println("default method");
        return 1;
    }
}
