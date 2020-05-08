package runtime;

/**
 * @Description
 * @Project test
 * @Package runtime
 * @Author xuzhenkui
 * @Date 2020/5/2 0:14
 */
public class Main {

////    ScheduledThreadPoolOperator
//    public static void main(String[] args) {
//        ScheduledThreadPoolOperator scheduledThreadPoolOperator = new ScheduledThreadPoolOperator();
//        scheduledThreadPoolOperator.start();
//
////        添加钩子, 实现优雅停服
//        final ScheduledThreadPoolOperator appReference = scheduledThreadPoolOperator;
//        Runtime.getRuntime().addShutdownHook(new Thread("shutdown-hook"){
//            @Override
//            public void run() {
//                System.out.println("接收到退出信号, 开始释放资源, 完成优雅停服...");
//                appReference.stop();
//            }
//        });
//
//        System.out.println("服务重启完成");
//    }

    public static void main(String[] args) {
        ThreadPoolExecutorFactory.getThreadPoolExecutor().execute(() -> {
            System.out.println("ThreadPoolExecutorFactory {executor} Success");
        });
    }
}
