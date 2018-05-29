package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/29.
 * @author bingheng
 */
public class MyThread10 extends Thread {

    @Override
    public void run() {
        System.out.println("run threadName = " + MyThread10.currentThread().getName() + ": begin");
        try {
            Thread.sleep(2000);

            System.out.println("run threadName = " + MyThread10.currentThread().getName() + ": end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Test10 {
    public static void main(String[] args) {
        MyThread10 myThread10 = new MyThread10();
        System.out.println("begin = " + System.currentTimeMillis());
        myThread10.start();
//        myThread10.run();
        System.out.println("end = " + System.currentTimeMillis());
    }

    /**
     * 由于main线程与MyThread10线程是异步执行的，
     * 所以首先打印begin 和 end，而MyThread10线程是随后台运行的，在最后两行打印run begin 和 run end
     */
}
