package com.zj.tank.strategy;

import com.zj.tank.Tank;

/**
 * @Auther: zhongj
 * @Date: 2021/8/7 - 08 - 07 - 20:34
 * @Description: 坦克开火策略
 * @version: 1.0
 */
public interface TankFireStrategy {
    public void fire(Tank tank);
}
