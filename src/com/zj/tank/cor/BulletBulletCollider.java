package com.zj.tank.cor;

import com.zj.tank.Bullet;
import com.zj.tank.GameObject;
import com.zj.tank.Tank;

/**
 * @Auther: zhongj
 * @Date: 2021/8/15 - 08 - 15 - 16:04
 * @Description: 子弹与子弹碰撞器
 * @version: 1.0
 */
public class BulletBulletCollider implements Collider {

    /**
     * 碰撞检测
     *
     * @param o1
     * @param o2
     * @return true::继续下一个碰撞检测（表示两种物体碰撞都不会消失）
     */
    @Override
    public Boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Bullet) {
            Bullet bullet1 = (Bullet) o1;
            Bullet bullet2 = (Bullet) o2;
            if (bullet1.rect.intersects(bullet2.rect)) {
                bullet1.die();
                bullet2.die();
            }
            return false;
        }
        return true;
    }
}
