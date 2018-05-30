package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/30.
 * @author bingheng
 * 使用return方法停止线程
 */
public class MyThread16 extends Thread {

    @Override
    public void run () {
        while (true) {
            if(isInterrupted()) {
                System.out.println("停止了！");
                return;
            }
            System.out.println("timer=" + System.currentTimeMillis());
        }
    }
}

class Test16 {
    public static void main(String[] args) {
        try {
            MyThread16 mt = new MyThread16();
            mt.start();
            Thread.sleep(2000);
            mt.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 总的来说还是建议使用抛异常的方式来实现线程的停止，因为在catch块中还可以将异常向上抛出，使线程停止的事件得以传播。
     */
}
