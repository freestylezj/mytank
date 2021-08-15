package com.zj.tank.cor;

import com.zj.tank.GameObject;
import com.zj.tank.util.PropertyMgr;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: zhongj
 * @Date: 2021/8/15 - 08 - 15 - 17:05
 * @Description: 责任链
 * @version: 1.0
 */
public class ColliderChain implements  Collider{
    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain(){
        String colliders_str = (String) PropertyMgr.get("colliders");
        String[] collidersName = colliders_str.split(",");
        for (String className : collidersName) {
            try {
                colliders.add((Collider) ColliderChain.class.getClassLoader().loadClass(className).getDeclaredConstructor().newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
//        colliders.add(new BulletTankCollider());
//        colliders.add(new TankTankCollider());
    }

    public void add(Collider collider){
        colliders.add(collider);
    }

    public Boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if(!colliders.get(i).collide(o1,o2)){
                return false;
            };
        }
        return true;
    }
}
