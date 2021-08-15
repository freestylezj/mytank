package com.zj.tank.cor;

import com.zj.tank.Bullet;
import com.zj.tank.Explode;
import com.zj.tank.GameObject;
import com.zj.tank.Tank;

/**
 * @Auther: zhongj
 * @Date: 2021/8/15 - 08 - 15 - 16:04
 * @Description: 子弹与子弹碰撞器
 * @version: 1.0
 */
public class TankTankCollider implements Collider {

    /**
     * 碰撞检测
     *
     * @param o1
     * @param o2
     * @return true::继续下一个碰撞检测（表示两种物体碰撞都不会消失）
     */
    @Override
    public Boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank tank1 = (Tank) o1;
            Tank tank2 = (Tank) o2;
            if (tank1.rect.intersects(tank2.rect)) {
                tank1.changeDirection(tank1);
                tank2.changeDirection(tank2);
            }
        }
        return true;
    }
}
