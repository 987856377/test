package concurrent;

/**
 * @Description
 * @Project test
 * @Package keyword
 * @Author xuzhenkui
 * @Date 2020/5/11 17:12
 */
public class SingletonFactory {
    private static volatile SingletonFactory instance = null;

    private SingletonFactory(){
        System.out.println("SingletonFactory Constructor Init");
    }

//    DCL(double check lock 双端检索机制)
    public static SingletonFactory getInstance(){
        if (instance == null){
            synchronized (SingletonFactory.class){
                if (instance == null){
                    instance = new SingletonFactory();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            new Thread(() -> {
                SingletonFactory.getInstance();
            },"Thread-Running").start();
        }
    }
}
