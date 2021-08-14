package com.zj.tank;

import com.zj.tank.enumeration.Direction;
import com.zj.tank.enumeration.Group;
import com.zj.tank.util.PropertyMgr;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * @Auther: zhongj
 * @Date: 2021/8/14 - 08 - 14 - 12:31
 * @Description: com.zj.tank
 * @version: 1.0
 */
public class GameModel {
    private Tank myTank = new Tank(200, 200, 10, Group.GOOOD, this);
    public ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
    ArrayList<Tank> enemyList = new ArrayList<Tank>();
    ArrayList<Explode> explodes = new ArrayList<Explode>();

    public GameModel() {
        int initEnemyTankCount = Integer.parseInt((String) PropertyMgr.get("initEnemyTankCount"));
        //增加敌方坦克
        for (int i = 0; i < initEnemyTankCount; i++) {
            enemyList.add(new Tank(i * 80, 50, 2, Group.BAD, this));
        }
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量：" + bulletList.size(), 10, 60);
        g.drawString("坦克数量：" + enemyList.size(), 10, 80);
        g.drawString("爆炸数量：" + explodes.size(), 10, 100);
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
        //画出子弹
        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).paint(g);
        }
        /* //会发生 java.util.ConcurrentModificationException
        for(Iterator<Tank> it = enemyList.iterator();it.hasNext();){
            Tank enemyTank = it.next();
            enemyTank.paint(g);
        }*/
        //画出敌方坦克
        for (int i = 0; i < enemyList.size(); i++) {
            enemyList.get(i).paint(g);
        }
        //子弹碰撞坦克
        for (int i = 0; i < bulletList.size(); i++) {
            for (int j = 0; j < enemyList.size(); j++) {
                bulletList.get(i).collideWith(enemyList.get(j));
            }
        }
        //画出爆炸
        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
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
