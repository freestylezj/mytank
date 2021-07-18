package com.zj.tank;

/**
 * @Auther: zhongj
 * @Date: 2021/7/18 - 07 - 18 - 16:15
 * @Description: com.zj.tank
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("程序入口...坦克大战即将开始...");
        TankFrame tf = new TankFrame();

        while(true){
           Thread.sleep(50);
           tf.repaint();//自动调用 paint方法
        }
    }
}
