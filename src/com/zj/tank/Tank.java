package com.zj.tank;

import java.awt.*;

/**
 * @Auther: zhongj
 * @Date: 2021/7/18 - 07 - 18 - 21:53
 * @Description: com.zj.tank
 * @version: 1.0
 */
public class Tank {
    private int x, y;
    private int speed;//坦克移动速度
    private Direction directon = Direction.DOWN;//坦克移动方向
    private boolean moving = false;//坦克是否移动

    public Tank(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
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

    /**
     * 坦克使用画笔绘画
     *
     * @param g
     */
    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
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
    }

}
