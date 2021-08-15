package com.zj.tank.cor;

import com.zj.tank.GameObject;

/**
 * @Auther: zhongj
 * @Date: 2021/8/15 - 08 - 15 - 16:01
 * @Description: 碰撞器
 * @version: 1.0
 */
public interface Collider {

    /**
     * 碰撞检测
     *
     * @param o1
     * @param o2
     * @return true::继续下一个碰撞检测（表示两种物体碰撞都不会消失）
     */
    public Boolean collide(GameObject o1, GameObject o2);

}
