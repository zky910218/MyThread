package cn.nosnow.thread;



/**
 * Created by Think on 2018/5/30.
 * @author bingheng
 * 停不了的线程
 *  interrupt()方法的使用效果并不像for+break语句那样，马上就停止循环，调用interrupt()方法仅仅是在当前线程中打了一个停止的标识，并不是真正的停止线程。
 */
public class MyThread11 extends Thread {
    @Override
    public void run() {
        super.run();
        for(int i = 0; i < 500000; i++) {
            System.out.println("i = " + (i+1));
        }
    }
}

class Test11 {
    public static void main(String[] args) {
        MyThread11 myThread11 = new MyThread11();
        myThread11.start();
        try {
            Thread.sleep(2000);
            /**从控制台的打印效果来看此方法并没有停止线程*/
            myThread11.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}
