package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/30.
 * @author bingHeng
 * 停止线程的方法--沉睡法
 *
 * 如果线程在sleep()状态下停止线程，会是什么效果呢？  先interrupt()在sleep()
 */
public class MyThread15 extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 100000; i++){
                System.out.println("i = " + (i+1));
            }
            System.out.println("run begin...");
            Thread.sleep(200000);
            System.out.println("run end...");
        } catch (InterruptedException e) {
            System.out.println("先停止，在遇到了sleep，进入catch");
            e.printStackTrace();
        }
    }
}

class Test15 {
    public static void main(String[] args) {
        MyThread15 myThread15 = new MyThread15();
        myThread15.start();
        myThread15.interrupt();
        System.out.println("end");
    }
}
