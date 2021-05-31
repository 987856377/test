package java8.thread.ticket;

/**
 * @Description
 * @Project test
 * @Package Thread
 * @Author xuzhenkui
 * @Date 2020/1/17 10:32
 */
public class TestNum {
    private static ThreadLocal<Integer> seqNum = ThreadLocal.withInitial(() -> 0);

    public Integer getNextNum() {
        seqNum.set(seqNum.get()+1);
        return seqNum.get();
    }

}
