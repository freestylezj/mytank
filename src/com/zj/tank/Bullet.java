package com.zj.tank;

import java.awt.*;

/**
 * @Auther: zhongj
 * @Date: 2021/7/21 - 07 - 21 - 21:27
 * @Description: 子弹
 * @version: 1.0
 */
public class Bullet {
    private static final int WIDTH = 8;
    private static final int HEIGHT = 8;
    private int x, y;//坐标
    private int speed;//速度
    private Direction directon;//方向
    Boolean live = true;//是否存活
    private TankFrame tankFrame;

    public Bullet(int x, int y, int speed, Direction directon,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.directon = directon;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();//获取初始颜色
        g.setColor(Color.RED);//设置颜色
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(c);//还原为初始颜色
        move();
    }

    /**
     * 子弹的移动
     */
    private void move() {
        if(!live){
            tankFrame.bulletList.remove(this);
        }
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

        if(x<0||y<0||x>TankFrame.GAME_WIDTH||y>TankFrame.GAME_HEIGHT){
            live = false;
        }
    }


}
