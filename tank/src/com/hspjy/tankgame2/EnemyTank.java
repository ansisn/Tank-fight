package com.hspjy.tankgame2;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }


    @Override
    public void run() {
        while (isLive){
        switch (getDirect()) {
            case 0:
                for (int i = 0; i < (int)(Math.random()*50); i++) {
                    moveUP();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 1: for (int i = 0; i < (int)(Math.random()*50); i++) {
                moveRight();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }   break;
            case 2: for (int i = 0; i < (int)(Math.random()*50); i++) {
                moveDown();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }   break;
            case 3: for (int i = 0; i < (int)(Math.random()*50); i++) {
                moveLeft();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }   ;break;

         }

            setDirect((int)(Math.random()*4));
        }
    }
}
