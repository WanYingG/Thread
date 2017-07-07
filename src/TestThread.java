/**
 * Created by Administrator on 2017/7/7.
 */
public class TestThread {
    private Object lock = new Object();
    public static void main(String[] args){
        TestThread testThread = new TestThread();
        testThread.test();
    }
    private void test() {
        new PrintNum().start();
        new PrintChar().start();
    }

    class PrintNum extends Thread{
        public  void run(){
            synchronized (lock) {
                for (int i =1; i <= 26;i++){
                System.out.print(i);
                lock.notify();
                try {
                    lock.wait();
                }catch(InterruptedException e){
                }
            }
           lock.notifyAll();
                }
                }
    }
    class PrintChar extends Thread{
        public void run(){
            synchronized (lock){
                for(int i=0; i<26;i++){
                    System.out.println((char)('a'+i));
                   lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notifyAll();
            }
        }
    }
}
