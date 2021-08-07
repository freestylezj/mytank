package test.DesignPatters.Strategy;

import java.util.Arrays;

/**
 * @Auther: zhongj
 * @Date: 2021/8/6 - 08 - 06 - 23:44
 * @Description: test.DesignPatters.Strategy
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {
//        System.out.println(new Dog(3).compareTO2());
//        int a[] = {5,3,1,2,4};
        Dog[] a = {new Dog(3), new Dog(5), new Dog(1)};
        System.out.println(Arrays.toString(a));
//        Arrays.sort(a);
        Sorter sorter = new Sorter();
        sorter.sort(a,new DogComparator());
        System.out.println(Arrays.toString(a));
    }

}
