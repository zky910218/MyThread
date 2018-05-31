package cn.nosnow.thread;

import java.util.Random;

/**
 * Created by Think on 2018/5/31.
 * @author bingHeng
 * 线程优先级--规则性、随机性
 *
 */
public class MyThread22 extends Thread {

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int j = 0; j < 10 ; j++) {
            for (int i = 0; i < 50000; i++) {
                /**随机数生成器*/
                Random random = new Random();
                random.nextInt();
                addResult = addResult + i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("★★★★★ thread 1 use time = " + (endTime - beginTime));
    }
}

class MyThread22B extends Thread {
    @Override
    public void run(){
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int j = 0; j < 10 ; j++) {
            for (int i = 0; i < 50000; i++) {
                /**随机数生成器*/
                Random random = new Random();
                random.nextInt();
                addResult = addResult + i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("☆☆☆☆☆ thread 2 use time = " + (endTime - beginTime));
    }
}

class Test22{
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            MyThread22 t1 = new MyThread22();
            /**设置线程的优先级为10*/
            t1.setPriority(Thread.MAX_PRIORITY);
            t1.start();
            MyThread22B t2 = new MyThread22B();
            t2.setPriority(Thread.MIN_PRIORITY);
            t2.start();
        }
    }

    /**
     * 反复运行程序发现：线程的优先级具有一定的规则性，也就是说CPU总是尽量将执行资源让给优先级比较高的线程。但是，这个结果不能说太肯定，
     * 因为线程还具有随机性，也就是优先级高的线程不一定每一次都是优先执行完成。
     */
}
