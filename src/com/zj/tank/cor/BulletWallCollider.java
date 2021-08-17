package com.zj.tank.cor;

import com.zj.tank.*;

/**
 * @Auther: zhongj
 * @Date: 2021/8/15 - 08 - 15 - 16:04
 * @Description: 子弹与墙碰撞器
 * @version: 1.0
 */
public class BulletWallCollider implements Collider {

    /**
     * 碰撞检测
     *
     * @param o1
     * @param o2
     * @return true::继续下一个碰撞检测（表示两种物体碰撞都不会消失）
     */
    @Override
    public Boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet bullet = (Bullet) o1;
            Wall wall = (Wall) o2;
            if (bullet.rect.intersects(wall.rect)) {
                bullet.die();
            }
        } else if (o1 instanceof Wall && o2 instanceof Bullet) {
            collide(o2, o1);
        }
        return true;
    }
}
