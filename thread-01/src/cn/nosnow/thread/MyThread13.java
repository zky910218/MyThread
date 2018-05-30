package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/30.
 * @author bingheng
 * 停止线程的方法--异常法
 */
public class MyThread13 extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 500000; i++){
                // 如果线程停止则进入
                if(interrupted()) {
                    System.out.println("已经是停止状态了，我要退出...");
                    throw new InterruptedException();
                }
                System.out.println("i = " + (i+ 1));
            }
            System.out.println("我在for循环下面");
        } catch (InterruptedException e) {
            System.out.println("进入MyThread13.java类run方法中的catch了。");
            e.printStackTrace();
        }
    }
}

class Test13 {
    public static void main(String[] args) {
        try {
            MyThread13 myThread13 = new MyThread13();
            myThread13.start();
            Thread.sleep(2000);
            myThread13.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
