package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/31.
 * @author bingheng
 * suspend和resume的缺点——独占
 * 在使用suspend和resume的时候，如果使用不当，极易造成公共的同步对象的独占，使得其他线程无法访问公共同步的对象
 */
public class MyThread18 {

    /**创建同步代码块*/
    synchronized public void printString() {
        System.out.println("begin");
        if(Thread.currentThread().getName().equals("a")) {
            System.out.println("线程a被永远暂停（suspend）了！");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }
}

class Test18 {
    public static void main(String[] args) {
        try {
            final MyThread18 myThread18 = new MyThread18();
            Thread t1 = new Thread() {
                @Override
                public void  run() {
                    myThread18.printString();
                }
            };
            t1.setName("a");
            t1.start();
            Thread.sleep(1000);

            Thread t2 = new Thread(){
                @Override
                public void run () {
                    System.out.println("t2启动了，但是进入不了printString方法，只打印了一个begin...");
                    System.out.println("因为printString方法被a线程锁定且永远暂停了suspend");
                    myThread18.printString();
                }
            };
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 程序运行结果独占并锁死了printString方法。
     * */
}
