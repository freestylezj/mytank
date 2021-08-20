package com.zj.tank.decorator;

import com.zj.tank.GameObject;

import java.awt.*;

/**
 * @Auther: zhongj
 * @Date: 2021/8/20 - 08 - 20 - 22:55
 * @Description: 尾巴装饰器
 * @version: 1.0
 */
public class TailDecorator extends GODecrator {

    public TailDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x=go.x;
        this.y =go.y;
        go.paint(g);
        //在物体外围装饰一个黄色方框
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawLine(go.x,go.y,go.x+getWidth(),go.y+getHeight());
        g.setColor(c);
    }

    @Override
    public Integer getWidth() {
        return go.getHeight();
    }

    @Override
    public Integer getHeight() {
        return go.getWidth();
    }
}
