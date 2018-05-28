package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/28.
 * @author bingheng
 * 实例变量与线程安全
 * 自定义线程类中的实例变量针对其他线程可以有共享和不共享之分
 */
public class MyThread03 extends Thread{
    /**
     *
     * 数据不共享的情况
     *
     *
     * */
    private int count = 5;

    public MyThread03(String name) {
        super();
        /**设置线程名字*/
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0){
              count --;
            System.out.println("由" + Thread.currentThread().getName() + "计算， count = " + count);
        }
    }
}

class MyTest {

    public static void main(String[] args) {
           MyThread03 a = new MyThread03("A");
           MyThread03 b = new MyThread03("B");
           MyThread03 c = new MyThread03("C");
           a.start();
           b.start();
           c.start();
    }

    /**
     * 运行结果分析：
     *      一共创建了3个线程，每个线程都有各自的count变量，自己减少自己的count变量值，
     *      这样的情况就是变量不共享，这个例子并不存在多个线程访问同一个实例变量的情况。
     */
}
