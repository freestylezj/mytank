package com.zj.tank;

import com.zj.tank.enumeration.Direction;
import com.zj.tank.enumeration.Group;
import com.zj.tank.util.PropertyMgr;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * @Auther: zhongj
 * @Date: 2021/7/18 - 07 - 18 - 16:27
 * @Description: 游戏画面
 * @version: 1.0
 */
public class TankFrame extends Frame {
    static final int GAME_WIDTH = Integer.parseInt((String)PropertyMgr.get("GAME_WIDTH")), GAME_HEIGHT = Integer.parseInt((String)PropertyMgr.get("GAME_HEIGHT"));
    private Tank myTank = new Tank(200, 200, 10, Group.GOOOD,this);
    public ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
    ArrayList<Tank> enemyList = new ArrayList<Tank>();
    ArrayList<Explode> explodes = new ArrayList<Explode>();

    public TankFrame() {
        setSize(GAME_WIDTH, GAME_HEIGHT);
        setVisible(true);
        setTitle(" TANK - WAR ");
        setResizable(false);

        addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
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

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
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
