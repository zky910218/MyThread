package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/29.
 * isAlive();   Thread.currentThread()和this的区别
 *
 * 在使用isAlive()方法时，如果将线程对象以构造函数的方式传递给Thread对象进行start()启动时，运行结果与MyThread08中是有差异的
 * 原因就是Thread.currentThread()和this的差异
 */
public class MyThread09 extends Thread {

    public MyThread09() {
        System.out.println("begin ===== ");
        System.out.println("Thread.currentThread.getName() = " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
        System.out.println("this.getName() = " + this.getName());
        System.out.println("this.isAlive() = " + this.isAlive());
        System.out.println("   =====end ");
    }

    @Override
    public void run () {
        System.out.println("begin =====run ");
        System.out.println("Thread.currentThread.getName() = " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
        System.out.println("this.getName() = " + this.getName());
        System.out.println("this.isAlive() = " + this.isAlive());
        System.out.println("run========end ");
    }
}

class Test09 {
    public static void main(String[] args) {
        MyThread09 myThread09 = new MyThread09();
        Thread t1 = new Thread(myThread09, "A");
        System.out.println("main begin t1 isAlive = " + t1.isAlive());
        t1.start();
        System.out.println("main end t1 isAlive = " + t1.isAlive());
    }
}
