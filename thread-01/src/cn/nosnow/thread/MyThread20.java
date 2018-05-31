package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/31.
 * @author bingheng
 * yield()方法的作用是放弃当前的cpu资源，将它让给其他的任务去占用cpu执行时间，但是放弃的时间不确定，有可能刚刚放弃，又马上获得了CPU时间片。
 */
public class MyThread20 extends Thread {

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for(int i = 0; i < 50000000; i++) {
            /**
             * Thread.yield(); 注释掉后运行时间为 25毫秒，打开注释运行时间为 7876毫秒
             * 调用yield();方法后将cpu资源让给其他资源导致速度变慢
             */
            Thread.yield();
            count = count + (i + 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时：" + (endTime - beginTime) + "  毫秒");
    }
}

class Test20 {
    public static void main(String[] args) {
        MyThread20 myThread20 = new MyThread20();
        myThread20.start();
    }
}
