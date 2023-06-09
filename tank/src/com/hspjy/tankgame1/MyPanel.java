package com.hspjy.tankgame1;

import javax.swing.*;
import java.awt.*;
@SuppressWarnings({"all"})
public class MyPanel extends JPanel {
    //定义tankHero
        Hero hero = null;
    public MyPanel(){
        hero = new Hero(100,100);//初始化坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //填充句形，默认黑色
        g.fillRect(0,0,1000,750);
        drawTank(hero.getX(),hero.getY(),g,0,0);

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

          //坦克形状
        switch (type){
            case 0: g.fill3DRect(x,y,10,60,false);
                    g.fill3DRect(x + 30,y,10,60,false);
                    g.fill3DRect(x + 10,y+10,20,40,false);
                    g.fillOval(x+10,y+20,20,20);
                    g.drawLine(x+20,y+30,x+20,y);
              break;
            case 1: g.fill3DRect(x,y,10,60,false);
                    g.fill3DRect(x + 30,y,10,60,false);
                    g.fill3DRect(x + 10,y+10,20,40,false);
                    g.fillOval(x+10,y+20,20,20);
                    g.drawLine(x+20,y+30,x+20,y);
                  break;

        }
    }
}
