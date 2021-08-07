package test.DesignPatters.Strategy;

/**
 * @Auther: zhongj
 * @Date: 2021/8/7 - 08 - 07 - 15:25
 * @Description: test.DesignPatters.Strategy
 * @version: 1.0
 */
public class DogComparator implements Comparator<Dog>{

    @Override
    public int compareTo(Dog o1, Dog o2) {
        if(o1.food>o2.food) return 1;
        else if(o1.food<o2.food) return -1;
        return 0;
    }
}
