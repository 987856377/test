package Thread;

/**
 * @Description
 * @Project test
 * @Package Thread
 * @Author xuzhenkui
 * @Date 2020/1/17 10:29
 */
//public class Client extends Thread {
public class Client implements Runnable{
    private TestNum sn;

    public Client(TestNum sn) {
        this.sn = sn;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            // ④每个线程打出3个序列值
            System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["
                    + sn.getNextNum() + "]");
        }
    }
}
