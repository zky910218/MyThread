package cn.nosnow.thread;

/**
 * Created by Think on 2018/5/28.
 * @author bingHeng
 *
 * 解决非线程安全的问题
 */
public class MyThread05 {

    private static String userNameRef;
    private static String passwordRef;

    /**解决“非线程安全”的方法也是使用synchronized关键字*/
   synchronized public static void doPost(String userName, String password) {
        try {
            userNameRef = userName;
            passwordRef = password;
            if(userName.equals("a")) {
                Thread.sleep(5000);
            }
            System.out.println("userName: " + userNameRef + " ,password = " + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**A用户进行登录*/
class ALogin extends Thread {
    @Override
    public void run () {
        MyThread05.doPost("a", "AA");
    }

}

/**B用户进行登录*/
class BLogin extends Thread {

    @Override
    public void run () {
        MyThread05.doPost("b", "bb");
    }
}

class MyTest003 {
    public static void main(String[] args) {
        ALogin aLogin = new ALogin();
        BLogin bLogin = new BLogin();
        aLogin.start();
        bLogin.start();
    }
}
