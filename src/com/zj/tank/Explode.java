package com.zj.tank;

import com.zj.tank.util.ResourceMgr;

import java.awt.*;

/**
 * @Auther: zhongj
 * @Date: 2021/7/21 - 07 - 21 - 21:27
 * @Description: 爆炸
 * @version: 1.0
 */
public class Explode {
    static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    static final int HEIGHT = ResourceMgr.explodes[0].getHeight();
    private int x, y;//坐标
    Boolean living = true;//是否存活
    private int step = 0;
    private TankFrame tankFrame;

    public Explode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++],x,y,WIDTH,HEIGHT,null);
        if(step>=ResourceMgr.explodes.length){
            tankFrame.explodes.remove(this);
        }

    }

}
