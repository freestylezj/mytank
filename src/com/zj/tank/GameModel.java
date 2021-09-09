package com.zj.tank;

import com.zj.tank.cor.BulletTankCollider;
import com.zj.tank.cor.Collider;
import com.zj.tank.cor.ColliderChain;
import com.zj.tank.cor.TankTankCollider;
import com.zj.tank.enumeration.Direction;
import com.zj.tank.enumeration.Group;
import com.zj.tank.util.PropertyMgr;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zhongj
 * @Date: 2021/8/14 - 08 - 14 - 12:31
 * @Description: model
 * @version: 1.0
 */
public class GameModel {
    private static final GameModel INSTANCE = new GameModel();

    static {
        INSTANCE.init();
    }

    Tank myTank;
    public List<GameObject> objects = new ArrayList<>();
    ColliderChain colliderChain = new ColliderChain();

    public static GameModel getInstance() {
        return INSTANCE;
    }

    private GameModel() {

    }

    private void init() {
        myTank = new Tank(200, 200, 10, Group.GOOOD);
        int initEnemyTankCount = Integer.parseInt((String) PropertyMgr.get("initEnemyTankCount"));
        //增加敌方坦克
        for (int i = 0; i < initEnemyTankCount; i++) {
            new Tank(i * 80, 50, 2, Group.BAD);
        }

        //初始化墙
        new Wall(150, 150, 200, 50);
        new Wall(550, 150, 200, 50);
        new Wall(300, 300, 50, 200);
        new Wall(550, 300, 50, 200);
    }

    public void addGo(GameObject go) {
        this.objects.add(go);
    }

    public void removeGo(GameObject go) {
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
        //碰撞检测
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                colliderChain.collide(o1, o2);
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
                case KeyEvent.VK_S:
                    save();
                    break;
                case KeyEvent.VK_L:
                    load();
                    break;
                default:
                    break;
            }
            setMainTankMoveDirection();
        }

        /**
         * 存盘(memento与序列化)
         */
        public void save() {
            File f = new File("E:/idea_workspace/my/mytank/tand.data");
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(new FileOutputStream(f));
                oos.writeObject(myTank);//先写的得先读
                oos.writeObject(objects);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(oos != null){
                    try {
                        oos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        /**
         * 加载存盘时内容
         */
        public void load() {
            File f = new File("E:/idea_workspace/my/mytank/tand.data");
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(f));
                myTank = (Tank) ois.readObject();//先写的得先读（顺序不能换）
                objects = (List<GameObject>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }finally {
                if(ois != null){
                    try {
                        ois.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
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
