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
        for (int i = 0; i < 6; i++) {
            tf.enemyList.add(new Tank(i*80,50,2,Group.BAD,tf));
        }

        //播放背景音效
//        new Thread(()->new Audio("audio/war1.wav").loop()).start();

        while(true){
           Thread.sleep(25);
           tf.repaint();//自动调用 paint方法
        }
    }
}
