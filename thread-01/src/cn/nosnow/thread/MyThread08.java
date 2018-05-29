package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/29.
 * @author bingHeng
 * 方法isAlive();的作用是测试线程是否处于活动状态，什么是活动状态？活动状态就是线程已经启动且尚未终止。线程处在正在运行或准备开始运行
 * 的状态，就认为线程是存活的。
 */
public class MyThread08 extends Thread {

    @Override
    public void run () {
        System.out.println("run = " + this.isAlive());
    }
}

class Test08 {
    public static void main(String[] args) throws InterruptedException {
        MyThread08 myThread08 = new MyThread08();
        System.out.println("begin == " + myThread08.isAlive());
        myThread08.start();

        /**
         * 此行在控制台的打印结果为true，但是此值不准确，打印true是因为myThread08线程还没有执行完毕，所以输出true
         * 此时如果让线程睡一会，则会打印出正确的结果.
         */
        Thread.sleep(1000);
        System.out.println("end == " + myThread08.isAlive());
    }
}
