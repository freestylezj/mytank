package com.zj.tank;

import java.awt.*;

/**
 * @Auther: zhongj
 * @Date: 2021/8/15 - 08 - 15 - 11:21
 * @Description: com.zj.tank
 * @version: 1.0
 */
public abstract  class GameObject {
    public int x,y;

    public abstract void  paint(Graphics g);

    public abstract Integer getWidth();
    public abstract Integer getHeight();

}
