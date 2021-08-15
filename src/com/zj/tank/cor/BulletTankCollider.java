package com.zj.tank.cor;

import com.zj.tank.Bullet;
import com.zj.tank.Explode;
import com.zj.tank.GameObject;
import com.zj.tank.Tank;

/**
 * @Auther: zhongj
 * @Date: 2021/8/15 - 08 - 15 - 16:04
 * @Description: 子弹坦克碰撞器
 * @version: 1.0
 */
public class BulletTankCollider implements Collider {

    /**
     * 碰撞检测
     *
     * @param o1
     * @param o2
     * @return true::继续下一个碰撞检测（表示两种物体碰撞都不会消失）
     */
    @Override
    public Boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet bullet = (Bullet) o1;
            Tank tank = (Tank) o2;
            if (bullet.group == tank.getGroup()) return true;
            if (bullet.rect.intersects(tank.rect)) {
                bullet.die();
                tank.die();
                int ex = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
                int ey = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
                bullet.gm.addGo(new Explode(ex, ey, bullet.gm));
            }
            return false;
        } else if (o1 instanceof Tank && o2 instanceof Bullet) {
            collide(o2, o1);
            return false;
        } else {
            return true;
        }
    }
}
