package com.hspjy.tankgame1;

import javax.swing.*;

public class TankGame01 extends JFrame {
    //定义MyPanel
    public static void main(String[] args) {
    TankGame01 tankGame01 = new TankGame01();
    }
    MyPanel mp = null;
    public TankGame01(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
