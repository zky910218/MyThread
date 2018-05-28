package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/10.
 * @author bingHeng
 * @date 2018.05.10
 */
public class MyThread02 extends Thread {

    @Override
    public void run(){
        try {
            for(int i = 0; i< 10; i++) {
                int time = (int)(Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("run = " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}

/**
 * 在代码中，为了展现出线程的随机性，所以使用随机数的形式，来使线程得到挂起的效果，从而表现出cpu执行哪个线程具有不确定性。
 *
 */
class Test{
    public static void main(String[] args) {
        try {
            MyThread02 myThread02 = new MyThread02();
            myThread02.setName("myThread2");
            /**
             * start();方法通知线程规划器，此线程已经准备就绪，等待调用线程对象的run()方法。
             * 这个过程其实就是让系统安排一个时间来调用Thread类中的run方法，也就是使线程得到运行，启动线程具有异步执行的效果。
             *
             * thread.run();就不是异步执行，而是同步，那么此线程对象并不交给  线程规划器  来进行处理，而是由main主线程来调用run();方法
             * 也就是必需等run()方法中的代码执行完成后才可以执行后面的代码。
             *
             * 执行start方法的顺序不代表线程启动的顺序。
             */
            myThread02.start();
//            myThread02.run();
            for (int i = 0; i < 10; i++){
                int time = (int)(Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("main = " + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
