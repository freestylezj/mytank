package test;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: zhongj
 * @Date: 2021/7/27 - 07 - 27 - 11:14
 * @Description: test
 * @version: 1.0
 */
public class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public void doSometining() throws InterruptedException {
        while (true){
            System.out.println(this.name+" is running...");
            TimeUnit.SECONDS.sleep(2);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
