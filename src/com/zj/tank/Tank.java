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
    private int SPEED;//坦克移动速度
    private Direction directon = Direction.DOWN;//坦克移动方向
    private boolean moving = false;//坦克是否移动

    public Tank(int x, int y, int SPEED) {
        this.x = x;
        this.y = y;
        this.SPEED = SPEED;
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

    public int getSPEED() {
        return SPEED;
    }

    public void setSPEED(int SPEED) {
        this.SPEED = SPEED;
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
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }
    }

}
