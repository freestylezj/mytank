package com.zj.tank;

import com.zj.tank.util.ResourceMgr;

import java.awt.*;
import java.util.Random;

/**
 * @Auther: zhongj
 * @Date: 2021/7/18 - 07 - 18 - 21:53
 * @Description: 坦克
 * @version: 1.0
 */
public class Tank {
    static final int WIDTH = ResourceMgr.goodTankD.getWidth();
    static final int HEIGHT = ResourceMgr.goodTankD.getHeight();
    private int x, y;
    private int speed;//坦克移动速度
    private Direction directon = Direction.DOWN;//坦克移动方向
    private boolean moving = true;//坦克是否移动
    private boolean living = true;
    private Random random = new Random();
    private Group group = Group.BAD;
    private TankFrame tankframe;
    Rectangle rect = new Rectangle();

    public Tank(int x, int y, int speed, Group group, TankFrame tankframe) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.group = group;
        this.tankframe = tankframe;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Direction getDirecton() {
        return directon;
    }

    public void setDirecton(Direction directon) {
        this.directon = directon;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * 坦克使用画笔绘画
     *
     * @param g
     */
    public void paint(Graphics g) {
        if (!living) {
            tankframe.enemyList.remove(this);
        }
        /* 20210726采用坦克图片替代黄色矩形
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 50, 50);
        g.setColor(c);
        */
        switch (directon) {
            case UP:
                g.drawImage(this.group == Group.GOOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
            case LEFT:
                g.drawImage(this.group == Group.GOOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            default:
                break;
        }

        move();
    }

    /**
     * 坦克的移动
     */
    private void move() {
        if (!moving) return;
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

        //开火
        if (this.group == Group.BAD && random.nextInt(100) > 95) {
            this.fire();
        }

        //主战坦克音效
        if (this.group == Group.GOOOD)
            new Thread(() -> new Audio("audio/tank_move.wav").play()).start();

        //敌人坦克随机改变方向
        if (this.group == Group.BAD && random.nextInt(100) > 95)
            randomDir();

        //边界检测
        boundsCheck();
        rect.x = this.x;
        rect.y = this.y;
    }

    /**
     * 边界检测
     */
    private void boundsCheck() {
        if(x<0) x=2;
        if(x>TankFrame.GAME_WIDTH - Tank.WIDTH -2) x=TankFrame.GAME_WIDTH - Tank.WIDTH -2;
        if(y<28) y=28;
        if(y>TankFrame.GAME_HEIGHT - Tank.HEIGHT -2) y=TankFrame.GAME_HEIGHT - Tank.HEIGHT -2;
    }

    /**
     * 随机改变方向
     */
    private void randomDir() {
        this.directon = Direction.values()[random.nextInt(4)];
    }

    /**
     * 坦克开火
     */
    public void fire() {
        int bx = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tankframe.bulletList.add(new Bullet(bx, by, 6, this.directon, this.group, this.tankframe));
        if (this.group == Group.GOOOD) {
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
        }
    }

    public void die() {
        this.living = false;
    }
}
