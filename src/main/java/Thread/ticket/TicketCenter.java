package Thread.ticket;

/**
 * @Description
 * @Project test
 * @Package Thread
 * @Author xuzhenkui
 * @Date 2020/1/17 11:32
 */
public class TicketCenter implements Runnable {
    private int total = 100;
    private String name;

    public TicketCenter(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            synchronized (this){
                if (total>0){
                    // ④每个线程打出3个序列值
                    System.out.println("thread[" + Thread.currentThread().getName() + "] "+ this.name + "--> sn["
                            + total-- + "]");
                }
            }
        }
    }
}
