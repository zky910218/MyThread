package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/31.
 * @author bingHeng
 * 线程优先级--继承性
 */
public class MyThread21 extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread21 run priority = " + this.getPriority());
        MyThread21B t2 = new MyThread21B();
        t2.start();
    }
}

class MyThread21B extends Thread{

    @Override
    public void run() {
        System.out.println("MyThread21B run priority = " + this.getPriority());
    }
}

class Test21 {
    public static void main(String[] args) {
        System.out.println("main thread begin priority = " + Thread.currentThread().getPriority());
        /**设置线程的优先级为5*/
        Thread.currentThread().setPriority(Thread.NORM_PRIORITY + 1);
        System.out.println("main thread end priority = " + Thread.currentThread().getPriority());
        MyThread21 t1 = new MyThread21();
        t1.start();
    }

    /***
     * Thread.currentThread().setPriority(Thread.NORM_PRIORITY + 1); 注释掉后 线程执行默认优先级 5
     * 去掉注释后，发现MyThread21B确实继承了MyThread21的线程优先级6
     *
     */
}
