package test.DesignPatters.Strategy;

/**
 * @Auther: zhongj
 * @Date: 2021/8/7 - 08 - 07 - 15:03
 * @Description: test.DesignPatters.Strategy
 * @version: 1.0
 */
public class Dog implements Compareable<Dog>{
    int food;

    public Dog(int food){
        this.food = food;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }


    @Override
    public int compareTO(Dog o) {
        if(this.food>o.food){
           return 1;
        }else if (this.food == o.food){
            return 0;
        }
        return -1;
    }
}
