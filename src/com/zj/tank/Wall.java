package com.zj.tank;

import java.awt.*;

/**
 * @Auther: zhongj
 * @Date: 2021/8/17 - 08 - 17 - 23:08
 * @Description: 墙
 * @version: 1.0
 */
public class Wall  extends GameObject{
    public int w,h;
    public Rectangle rect = new Rectangle();

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        rect = new Rectangle(x,y,w,h);
        GameModel.getInstance().addGo(this);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x,y,w,h);
        g.setColor(c);
    }

    @Override
    public Integer getWidth() {
        return w;
    }

    @Override
    public Integer getHeight() {
        return h;
    }

}
