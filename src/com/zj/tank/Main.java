package com.zj.tank;

/**
 * @Auther: zhongj
 * @Date: 2021/7/18 - 07 - 18 - 16:15
 * @Description: 程序入口
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("程序入口...坦克大战即将开始...");
        TankFrame tf = new TankFrame();

        //增加敌方坦克
        for (int i = 0; i < 10; i++) {
            tf.enemyList.add(new Tank(i*80,50,10,tf));
        }

        while(true){
           Thread.sleep(50);
           tf.repaint();//自动调用 paint方法
        }
    }
}
