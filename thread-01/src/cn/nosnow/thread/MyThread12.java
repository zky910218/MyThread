package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/30.
 * @author bingheng
 * 停止线程的方法--异常法
 */
public class MyThread12 extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++){
            if(interrupted()) {
                System.out.println("已经是停止状态了，我要退出去...");
                break;
            }
            System.out.println("i = " + (i+1));
        }
        System.out.println("线程已经停止了，我真的会被执行么？？？");
    }
}

class Test12 {
    public static void main(String[] args) {
        MyThread12 myThread12 = new MyThread12();
        myThread12.start();
        try {
            Thread.sleep(2000);
            myThread12.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch...");
            e.printStackTrace();
        }
        System.out.println("end");
    }
    /**
     * 多运行几遍程序，发现此例子虽然停止了线程，但是如果for循环下面还有语句还是会继续执行的，这说明线程并未真正停止，异常法停止线程详情见MyThread13
     * */

}
