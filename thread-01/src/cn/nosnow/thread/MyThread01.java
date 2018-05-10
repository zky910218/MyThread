package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/10.
 * @author bingHeng
 * @date 2018.05.10
 *
 *  线程入门初窥01-线程执行顺序与代码顺序
 */
public class MyThread01 extends Thread {

    @Override
    public void run(){
        super.run();
        System.out.println("MyThread");
    }
}

/**
 * 根据运行结果可以知道，MyThread01类中的run方法执行的时间比较晚，
 * 这也说明在使用多线程技术时，代码的运行结果与代码执行顺序或者调用顺序无关。
 *
 * ps:如果多次调用start();方法则会抛出异常Exception in thread "main" java.lang.IllegalThreadStateException
 */
class Run {
    public static void main(String[] args) {
        MyThread01 myThread01 = new MyThread01();
//        for(int i = 0; i < 100; i++){
            myThread01.start();
//        }
        System.out.println("运行结束！");
    }
}
