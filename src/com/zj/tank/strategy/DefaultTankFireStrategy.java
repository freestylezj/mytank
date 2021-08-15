package com.zj.tank.strategy;

import com.zj.tank.Audio;
import com.zj.tank.Bullet;
import com.zj.tank.Tank;
import com.zj.tank.enumeration.Group;

/**
 * @Auther: zhongj
 * @Date: 2021/8/7 - 08 - 07 - 20:35
 * @Description: 坦克默认开火策略
 * @version: 1.0
 */
public class DefaultTankFireStrategy implements TankFireStrategy{
    @Override
    public void fire(Tank tank) {
        int bx = tank.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = tank.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tank.gm.addGo(new Bullet(bx, by, 6, tank.directon, tank.group, tank.gm));
        if (tank.group == Group.GOOOD) {
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
        }
    }
}
