package test.DesignPatters.Singleton;

/**
 * @Auther: zhongj
 * @Date: 2021/8/3 - 08 - 03 - 22:49
 * @Description: test.DesignPatters.Singleton
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        /*System.out.println(Mgr01.getInstance());
        System.out.println(Mgr01.getInstance());
        System.out.println(Mgr01.getInstance() == Mgr01.getInstance());
        Mgr01.getInstance().m();

        System.out.println("Mgr01.getInstance()-------------------------------");
        for (int i = 0; i < 100; i++) {
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(Mgr01.getInstance());
                        }
                    }
            ).start();
        }

        System.out.println("Mgr02.getInstance()-------------------------------");
        for (int i = 0; i < 100; i++) {
            new Thread(
                    ()->{
                        System.out.println(Mgr02.getInstance());
                    }
            ).start();
        }*/

        System.out.println("Mgr03.getInstance()-------------------------------");
        for (int i = 0; i < 100; i++) {
            new Thread(
                    () -> {
                        System.out.println(Mgr03.getInstance());
                    }
            ).start();
        }

        System.out.println("Mgr04.getInstance()-------------------------------");
        for (int i = 0; i < 100; i++) {
            new Thread(
                    () -> {
                        System.out.println(Mgr04.INSTANCE1 == Mgr04.INSTANCE1);
                        Mgr04.INSTANCE1.m();
                    }
            ).start();
        }
    }
}
