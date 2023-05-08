package com.hspjy.tankgame2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

@SuppressWarnings({"all"})
public class MyPanel extends JPanel implements KeyListener,Runnable {
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //定义tankHero
        Hero hero = null;
        //线程安全问题，敌人的坦克用vector

        int emeytanksize = 3;
    public MyPanel(){
        hero = new Hero(100,100);//初始化坦克
        hero.setSpeed(5);
        for (int i = 0; i < emeytanksize; i++) {
           EnemyTank enemyTank = new EnemyTank(100*( i + 1), 0);
           enemyTank.setDirect(2);
           //使敌人移动
            new Thread(enemyTank).start();
           //给敌人加入射击子弹操作
           Shot shot = new Shot(enemyTank.getX()+20,enemyTank.getY()+60,enemyTank.getDirect());
            //加入敌人坦克得Vector成员
            enemyTank.shots.add(shot);
            //启动shot对象】
            new Thread((shot)).start();
            enemyTanks.add(enemyTank);

        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //填充句形，默认黑色

        g.fillRect(0,0,1000,750);

        drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),0);
          //画敌人坦克和子弹
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出tank
            EnemyTank enemyTank = enemyTanks.get(i);
             //判断敌人坦克是否存活
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
                //画出子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);
                    if (shot.isLive == true) {
                        //子弹没越界
                        g.draw3DRect(shot.x, shot.y, 1, 1, false);
                    }
                }
            }else {
                enemyTanks.remove(enemyTank);
            }
        }

         //绘制子弹
        if (hero.shot != null && hero.shot.isLive == true){
          //  g.fill3DRect(hero.shot.x,hero.shot.y,5,5,false);
             g.draw3DRect(hero.shot.x,hero.shot.y,5,5,false);
        }

    }
    //坦克外形
    /*
    *
    * @param x 坦克左上角x坐标
    * @param y 坦克左上角y坐标
    * @param x 画笔
    * @param direct 坦克方向
    * @param type 坦克类型
    * */
    public void drawTank(int x,int y,Graphics g,int direct,int type){

        //坦克外观
        switch (type){
            case 0: g.setColor(Color.CYAN);
                    break;
            case 1: g.setColor(Color.yellow);
            break;
        }

          /*坦克形状
            0 向上
            1 向右
            2 向下
            3 向左


            */
        switch (direct){
            case 0: g.fill3DRect(x,y,10,60,false);
                    g.fill3DRect(x + 30,y,10,60,false);
                    g.fill3DRect(x + 10,y+10,20,40,false);
                    g.fillOval(x+10,y+20,20,20);
                    g.drawLine(x+20,y+30,x+20,y);
              break;
            case 1: g.fill3DRect(x,y,60,10,false);
                    g.fill3DRect(x , y+30,60,10,false);
                    g.fill3DRect(x+10,y+10,40,20,false);
                    g.fillOval(x+20,y+10,20,20);
                    g.drawLine(x+30,y+20,x+60,y+20);
                  break;
            case 2:  g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x + 30,y,10,60,false);
                g.fill3DRect(x + 10,y+10,20,40,false);
                g.fillOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+30,x+20,y+60);
                break;
            case 3: g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x , y+30,60,10,false);
                g.fill3DRect(x+10,y+10,40,20,false);
                g.fillOval(x+20,y+10,20,20);
                g.drawLine(x+30,y+20,x,y+20);
                break;
        }
    }
    /*坦克形状
               0 向上
               1 向右
               2 向下
               3 向左


               */
    //判断我放坦克击中地方坦克
    public void hitTank(Shot s,EnemyTank enemyTank){
        switch (enemyTank.getDirect()){//根据tank方向判断是否击中
            case 0:
            case 2:
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40
                && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60){
                    enemyTank.isLive = false;
                    s.isLive = false;
                    enemyTanks.remove(enemyTank);
                    emeytanksize--;
                }break;
            case 1:
            case 3:
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60
                        && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40){
                    enemyTank.isLive = false;
                    s.isLive = false;
                    enemyTanks.remove(enemyTank);
                    emeytanksize--;
                }break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
          if (e.getKeyCode() == KeyEvent.VK_W){
              hero.setDirect(0);
                hero.moveUP();
          }else if (e.getKeyCode() == KeyEvent.VK_S){
              hero.setDirect(2);
              hero.moveDown();
          }else if (e.getKeyCode() == KeyEvent.VK_D) {
              hero.setDirect(1);
              hero.moveRight();
          }else if (e.getKeyCode() == KeyEvent.VK_A) {
              hero.setDirect(3);
              hero.moveLeft();
          }

          if (e.getKeyCode() == KeyEvent.VK_J){
              hero.shotEnemyTank();  //射击
          }
       repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //判断是否击中了敌人坦克
            if (hero.shot!= null && hero.shot.isLive){
                //遍历敌人所有得tank
                for (int i = 0; i < emeytanksize; i++) {
                   EnemyTank enemyTank = enemyTanks.get(i);
                   hitTank(hero.shot, enemyTank);

                }
            }
            this.repaint();
        }
    }
}
