package com.hspjy.tankgame2;

import javax.swing.*;

public class TankGame02 extends JFrame {
    //定义MyPanel
    public static void main(String[] args) {
        TankGame02 tankGame02 = new TankGame02();
    }
            MyPanel mp = null;
    public TankGame02(){
        mp = new MyPanel();
        Thread thread = new Thread(mp);
           thread.start();
        this.add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
