package com.hspjy.draw;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame{//画框
    public static void main(String[] args) {
      new DrawCircle();
    }
    private MyPanel_ mp = null;
    public DrawCircle(){
        //初始化面板
        mp = new MyPanel_();
        //将面板加入窗口
        this.add(mp);
        //设置窗口大小
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口退出
        this.setVisible(true);//可视化

    }
}
class MyPanel_ extends JPanel{//画板
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        System.out.println("paint存在监听机制");
        //画圆
        //  g.drawOval(10,10,100,100);
          g.setColor(Color.BLUE);
          g.setFont(new Font("宋体",Font.BOLD,50));
          g.drawString("我是你爸爸",100,100);
       // g.fillOval(10,10,100,100);

    }
}
