package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/31.
 * @author bingheng
 * 守护线程setDaemon(true)
 */
public class MyThread23 extends Thread {
    private int i = 0;

    @Override
    public void run () {
        try{
            while (true) {
                i++;
                System.out.println("i = " + (i));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Test23 {
    public static void main(String[] args) {
        try {
            MyThread23 t1 = new MyThread23();
            /**将t1线程设置为守护线程*/
            t1.setDaemon(true);
            t1.start();
            Thread.sleep(5000);
            System.out.println("我离开t1对象也不再打印了，也就是停止了！");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
