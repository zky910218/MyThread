package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/31.
 * @author bingHeng
 *
 * suspend和resume方法的使用
 */
public class MyThread17 extends Thread {

    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run () {

        while (true) {
            i++;
        }
    }
}

class Test17 {
    public static void main(String[] args) {
        try {
            MyThread17 myThread17 = new MyThread17();
            myThread17.start();
            Thread.sleep(5000);
            // A段
            myThread17.suspend(); // 暂停线程运行
            System.out.println("A = " + System.currentTimeMillis() + ", i = " + myThread17.getI());
            Thread.sleep(5000);
            System.out.println("A = " + System.currentTimeMillis() + ", i = " + myThread17.getI());

            // B段
            myThread17.resume(); // 恢复线程继续运行
            Thread.sleep(5000);

            // C段
            myThread17.suspend(); // 暂停线程运行
            System.out.println("B = " + System.currentTimeMillis() + ", i = " + myThread17.getI());
            Thread.sleep(5000);
            System.out.println("B = " + System.currentTimeMillis() + ", i = " + myThread17.getI());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从控制台的打印时间来看，线程的确被暂停了，而且还可以恢复成运行状态
     *
     * suspend和resume的缺点——独占
     *  在使用suspend和resume的时候，如果使用不当，极易造成公共的同步对象的独占，使得其他线程无法访问公共同步的对象
     */
}
