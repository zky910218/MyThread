package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/28.
 * @author bingheng
 *
 * i--与System.out.println()
 */
public class MyThread06 extends Thread {

    private int i = 5;

    @Override
    public void run() {

        /**ps: 代码i--由前面项目中单独一行运行改成在当前项目中在println方法中直接进行打印*/
        System.out.println("i= " + (i--) + ", threadName = " + Thread.currentThread().getName());
    }
}

class Tset06 {
    public static void main(String[] args) {
        MyThread06 myThread06 = new MyThread06();
        Thread t1 = new Thread(myThread06, "A");
        Thread t2 = new Thread(myThread06, "B");
        Thread t3 = new Thread(myThread06, "C");
        Thread t4 = new Thread(myThread06, "D");
        Thread t5 = new Thread(myThread06, "E");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    /**
     * println()方法在内部是同步的，但i--的操作却是在进入println()之前发生的，所以有发生非线程安全问题的概率。
     * 所以，为了防止发生非线程安全问题，还是应该使用同步方法。
     */
}
