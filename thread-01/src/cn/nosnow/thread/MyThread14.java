package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/30.
 * @author bingHeng
 * 停止线程的方法--沉睡法
 *
 * 如果线程在sleep()状态下停止线程，会是什么效果呢？  先sleep在interrupt()
 */
public class MyThread14 extends Thread {

    @Override
    public void run(){
        super.run();
        try {
            System.out.println("run begin ...");
            Thread.sleep(200000);
            System.out.println("run end ...");
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止，进入catch！" + isInterrupted());
            e.printStackTrace();
        }
    }
}

class Test14 {
    public static void main(String[] args) {
        try {
            MyThread14 myThread14 = new MyThread14();
            myThread14.start();
            Thread.sleep(200);
            myThread14.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch...");
            e.printStackTrace();
        }
        System.out.println("end");
    }
    /**
     * 从程序运行结果来看，如果在sleep状态下停止某一个线程，会进入catch语句，并且清除停止状态值，使之变为false
     */
}
