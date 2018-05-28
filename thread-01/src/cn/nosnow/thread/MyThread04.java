package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/28.
 * @author bingheng
 * 实例变量与线程安全
 * 自定义线程类中的实例变量针对其他线程可以有共享和不共享之分
 */
public class MyThread04 extends Thread {

    /**
     * 共享数据的情况就是多个线程可以访问同一个变量
     */
    private int count = 5;

    @Override
    synchronized public void run() {
        super.run();
        count--;
        /**此处示例不要使用for语句，因为使用同步后其他线程就得不到运行的机会了，一直由一个线程进行运算*/
        System.out.println("由" + Thread.currentThread().getName() + "计算， count = " + count);
    }
}

class MyTest01 {
    public static void main(String[] args) {
        MyThread04 myThread04 = new MyThread04();
        Thread a = new Thread(myThread04, "A");
        Thread b = new Thread(myThread04, "B");
        Thread c = new Thread(myThread04, "C");
        Thread d = new Thread(myThread04, "D");
        Thread e = new Thread(myThread04, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

    /**
     *  运行结果中可能出现两个线程同时对一个count变量进行处理，例如：
     *  线程A和线程B同时对count = 3进行处理，这个时候就出现了非线程安全的问题。
     *  此时可以使用关键字：synchronized
     *
     *  synchronized关键字可以在任意对象和方法上加锁，而加锁的这段代码称为互斥区或者临界区。
     *
     *  当一个线程想要执行同步方法里的代码时，线程首先尝试去拿这把锁，如果能拿到这把锁，那么
     *  这个线程就可以执行synchronized里面的代码。
     *  如果不能拿到这把锁，那么这个线程就会不断的尝试拿这把锁，直到能够拿到为止，而且是有多个线程同时去争抢这把锁。
     *
     */


}
