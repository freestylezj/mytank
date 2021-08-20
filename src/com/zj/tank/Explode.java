package com.zj.tank;

import com.zj.tank.util.ResourceMgr;

import java.awt.*;

/**
 * @Auther: zhongj
 * @Date: 2021/7/21 - 07 - 21 - 21:27
 * @Description: 爆炸
 * @version: 1.0
 */
public class Explode extends GameObject{
    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();
    Boolean living = true;//是否存活
    private int step = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;

        GameModel.getInstance().addGo(this);

        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++],x,y,WIDTH,HEIGHT,null);
        if(step>=ResourceMgr.explodes.length){
            GameModel.getInstance().removeGo(this);
        }
    }

    @Override
    public Integer getWidth() {
        return WIDTH;
    }

    @Override
    public Integer getHeight() {
        return HEIGHT;
    }

}
