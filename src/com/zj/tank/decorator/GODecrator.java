package com.zj.tank.decorator;

import com.zj.tank.GameObject;

import java.awt.*;

/**
 * @Auther: zhongj
 * @Date: 2021/8/20 - 08 - 20 - 22:49
 * @Description: 游戏物体装饰器
 * @version: 1.0
 */
public abstract class GODecrator extends GameObject {

    protected GameObject go;

    public GODecrator(GameObject go){
        this.go = go;
    }

    @Override
    public void paint(Graphics g) {
        go.paint(g);
    }


}
