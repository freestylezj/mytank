package com.zj.tank;

import com.zj.tank.cor.BulletTankCollider;
import com.zj.tank.cor.Collider;
import com.zj.tank.enumeration.Direction;
import com.zj.tank.enumeration.Group;
import com.zj.tank.util.PropertyMgr;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zhongj
 * @Date: 2021/8/14 - 08 - 14 - 12:31
 * @Description: model
 * @version: 1.0
 */
public class GameModel {
    public List<GameObject> objects = new ArrayList<>();
    private Tank myTank = new Tank(200, 200, 10, Group.GOOOD, this);
    Collider btCollider = new BulletTankCollider();

    public GameModel() {
        int initEnemyTankCount = Integer.parseInt((String) PropertyMgr.get("initEnemyTankCount"));
        //增加敌方坦克
        for (int i = 0; i < initEnemyTankCount; i++) {
            objects.add(new Tank(i * 80, 50, 2, Group.BAD, this));
        }
    }

    public void addGo(GameObject go){
        this.objects.add(go);
    }

    public void removeGo(GameObject go){
        this.objects.remove(go);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹数量：" + bulletList.size(), 10, 60);
//        g.drawString("坦克数量：" + enemyList.size(), 10, 80);
//        g.drawString("爆炸数量：" + explodes.size(), 10, 100);
        g.setColor(c);
        myTank.paint(g);
        /*会发生 java.util.ConcurrentModificationException
        for (Bullet bullet:bulletList) {
            bullet.paint(g);
        }
        */
        /* 会发生 java.util.ConcurrentModificationException
        for(Iterator<Bullet> it = bulletList.iterator(); it.hasNext();){
            Bullet bullet = it.next();
            if(!bullet.live){
                it.remove();
            }else{
                bullet.paint(g);
            }
        }
        */
        //画出游戏物体
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }
        //子弹碰撞坦克
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i+1; j < objects.size(); j++) {
                btCollider.collide(objects.get(i),objects.get(j));
            }
        }

    }

    class MyKeyListener extends KeyAdapter {
        boolean bup = false, bdown = false, bleft = false, bright = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP:
                    bup = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bdown = true;
                    break;
                case KeyEvent.VK_LEFT:
                    bleft = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bright = true;
                    break;
                default:
                    break;
            }
            setMainTankMoveDirection();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP:
                    bup = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bdown = false;
                    break;
                case KeyEvent.VK_LEFT:
                    bleft = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bright = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankMoveDirection();
        }

        private void setMainTankMoveDirection() {
            if (!bup && !bdown && !bleft && !bright) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);
                if (bup) myTank.setDirecton(Direction.UP);
                if (bdown) myTank.setDirecton(Direction.DOWN);
                if (bleft) myTank.setDirecton(Direction.LEFT);
                if (bright) myTank.setDirecton(Direction.RIGHT);
            }
        }
    }

}
