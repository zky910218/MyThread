package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/31.
 * @author bingheng
 * 除了suspend方法极为容易造成线程独占和锁死，下面的情况也需要注意
 */
public class MyThread19 extends Thread {
    private long i = 0;

    @Override
    public void run () {
        while (true) {
            i++;
            /**
             * 添加System.out.println(i);  控制台打印数字，但是不会打印  main end      程序无法停止
             * 如果注释掉这句话，则控制台打印 main end，程序无法停止
             *
             * 出现这种情况的原因是当程序运行到println方法的内部停止时，同步锁未被释放，导致当前对象的println()方法一直呈现暂停状态，
             * 并且锁未被释放，而main方法中的代码System.out.println("main end!")迟迟不能执行。
             *
             * ps： 虽然suspend()方法是过期作废的方法，但是还是有必要研究它过期作废的原因。
             */
            System.out.println(i);
        }
    }
}

class Test19 {
    public static void main(String[] args) {
        try {
            MyThread19 myThread19 = new MyThread19();
            myThread19.start();
            Thread.sleep(1000);
            myThread19.suspend();
            System.out.println("main end!");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}