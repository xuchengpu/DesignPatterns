package com.xcp.designpatterns.others;

/**
 * Created by 许成谱 on 2019/3/9 18:11.
 * qq:1550540124
 * 热爱生活每一天！
 * 多个生产消费者模式
 */
public class ProduceConsume {
    public static void main(String[] args) {
        Warehouse h = new Warehouse();
        new Worker("Work1", h).start();
        new Worker("Work2", h).start();
        new Saler("Saler1", h).start();
        new Saler("Saler2", h).start();
    }
}

class Warehouse {
    private static int count = 5;

    public synchronized void add() {
        while (count >= 10) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println("生产后count=="+count);
        this.notifyAll();
    }

    public synchronized void sale() {
        while (count <= 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println("消费后count=="+count);
        this.notifyAll();
    }
}

class Saler extends Thread {
    private Warehouse h;

    public Saler(String name, Warehouse h) {
        setName(name);
        this.h = h;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            h.sale();
        }
    }
}

class Worker extends Thread {
    private Warehouse h;

    public Worker(String name, Warehouse h) {
        setName(name);
        this.h = h;
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            h.add();
        }
    }
}

