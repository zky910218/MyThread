package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/29.
 * @author bingheng
 * currentThread()方法可以返回代码片段正在被哪个线程调用的信息。
 */
public class MyThread07 extends Thread {

    public MyThread07() {
        System.out.println("构造方法的打印： " + Thread.currentThread().getName());
    }
    @Override
    public void run() {
        System.out.println("run方法的打印： " + Thread.currentThread().getName());
    }
}

class Test07 {
    public static void main(String[] args) {
        MyThread07 myThread07 = new MyThread07();
//        myThread07.start();
        myThread07.run();
    }

    /**
     * myThread07.start();
     *  从运行结果表示MyThread07.java类的构造函数是被main方法调用的，而run方法是被名称为Thread-0的线程调用的，run方法是自动调用的方法。
     *
     * myThread07.run();
     *  均被主线程调用
     *
     */
}
