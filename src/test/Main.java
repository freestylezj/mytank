package test;

/**
 * @Auther: zhongj
 * @Date: 2021/7/27 - 07 - 27 - 11:18
 * @Description: test
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Dog dog = new Dog("dog_"+i);
            Thread thread = new Thread(
                    ()->{
                        try {
                            dog.doSometining();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            );
            thread.start();
        }
    }
}
