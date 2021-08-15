package com.zj.tank.cor;

import com.zj.tank.GameObject;

/**
 * @Auther: zhongj
 * @Date: 2021/8/15 - 08 - 15 - 16:01
 * @Description: 碰撞器
 * @version: 1.0
 */
public interface Collider {

    public Boolean collide(GameObject o1, GameObject o2);

}
