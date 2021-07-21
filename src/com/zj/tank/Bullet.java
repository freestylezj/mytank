package com.zj.tank;

import java.awt.*;

/**
 * @Auther: zhongj
 * @Date: 2021/7/21 - 07 - 21 - 21:27
 * @Description: 子弹
 * @version: 1.0
 */
public class Bullet {
    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    private int x, y;//坐标
    private int speed;//速度
    private Direction directon;//方向

    public Bullet(int x, int y, int speed, Direction directon) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.directon = directon;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();//获取初始颜色
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(Color.RED);//设置颜色
        g.setColor(c);//还原为初始颜色
        move();
    }

    /**
     * 子弹的移动
     */
    private void move() {
        switch (directon) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            default:
                break;
        }
    }


}
