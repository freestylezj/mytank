package com.zj.tank;

import com.zj.tank.util.ResourceMgr;

import java.awt.*;

/**
 * @Auther: zhongj
 * @Date: 2021/7/21 - 07 - 21 - 21:27
 * @Description: 子弹
 * @version: 1.0
 */
public class Bullet {
    static final int WIDTH = ResourceMgr.bulletD.getWidth();
    static final int HEIGHT = ResourceMgr.bulletD.getHeight();
    private int x, y;//坐标
    private int speed;//速度
    private Direction directon;//方向
    Boolean living = true;//是否存活
    private TankFrame tankFrame;

    public Bullet(int x, int y, int speed, Direction directon,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.directon = directon;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        /* 20210726采用子弹图片替代红色圆形
        Color c = g.getColor();//获取初始颜色
        g.setColor(Color.RED);//设置颜色
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(c);//还原为初始颜色
        */
        switch (directon){
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            default:
                break;
        }

        move();
    }

    /**
     * 子弹的移动
     */
    private void move() {
        if(!living){
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
            living = false;
        }
    }

    /**
     * 子弹消灭敌方坦克
     * @param tank 敌方坦克
     */
    public void collideWith(Tank tank) {
        Rectangle rectBullet = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        Rectangle rectTank = new Rectangle(tank.getX(),tank.getY(),tank.WIDTH,tank.HEIGHT);
        if(rectBullet.intersects(rectTank)){
            this.die();
            tank.die();
        }
    }

    private void die() {
        this.living = false;
    }
}
