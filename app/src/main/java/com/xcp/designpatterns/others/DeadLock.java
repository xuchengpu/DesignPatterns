package com.xcp.designpatterns.others;

/**
 * Created by 许成谱 on 2019/3/8 14:05.
 * qq:1550540124
 * 热爱生活每一天！
 * 死锁模式
 */
public class DeadLock {
    public  static void main(String[] args){
        new WorkThread(true,"thread1").start();
        new WorkThread(false,"thread2").start();
    }
}
class WorkThread extends Thread{
    private static Object a=new Object();
    private static Object b=new Object();
    private  boolean flag =false;

    public WorkThread(boolean flag, String threadName) {
        this.flag=flag;
        setName(threadName);
    }

    @Override
    public void run() {
        super.run();
        if(flag) {
            synchronized (a){
                System.out.println(currentThread().getName()+"执行到了a");
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println(currentThread().getName()+"执行到了b");
                }
                System.out.println(currentThread().getName()+"执行完了");
            }
        }else{
            synchronized (b){
                System.out.println(currentThread().getName()+"执行到了b");
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (a){
                    System.out.println(currentThread().getName()+"执行到了a");
                }
                System.out.println(currentThread().getName()+"执行完了");
            }
        }
    }
}
