package test;

import java.util.*;

/***
 * 所有实现均基于JDK，不可使用第三方中间件
 * 1.实现下方的抽奖方法(luckdraw)，提供5000次抽奖机会，奖品有一等奖3个，二等奖 100个，三等奖50个，各个奖品需在5000次抽奖中尽量平均分布，但不可有规律被抽中
 * 2.实现下方的数字查找方法，查找最大数和最小数，并得出它们的乘积（不可使用集合工具类）
 * 3.实现下方的查找方法（findAndReturn）供他人调用，传入参数为不可预知的List，分别查找List中2的倍数，5的倍数出现的次数，调用checkEqual方法判断如果返回true就不计入次数，最后返回结果集，此方法有性能要求。
 */
public class Demo {


    /***
     * 检查是否等于100
     *@param num 比较值
     *@return 相等返回true 否则false
     */
    public static boolean checkEqual(Integer num) {
        return num==100;
    }

    public static void luckDraw() {
        int first = 3, second = 100, third = 50;
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        List<Integer> thirdList = new ArrayList<>();
        for(int i = 0;i < 5000; i++) {
            double tmp1 = (double)first / (double)(5000-i);
            double tmp2 = (double)second / (double)(5000-i);
            double tmp3 = (double)third / (double)(5000-i);
            double r = Math.random();
            if( r < tmp1 ) {
                first--;
                firstList.add(i+1);
            }
            else if( r < tmp1 + tmp2 ) {
                second--;
                secondList.add(i+1);
            }
            else if( r < tmp1 + tmp2 + tmp3 ) {
                third--;
                thirdList.add(i+1);
            }
        }
        System.out.println("一等奖: " + firstList);
        System.out.println("二等奖: " + secondList);
        System.out.println("三等奖: " + thirdList);
    }

    public static void findNumber() {
        String[] array={"1","5","33","7","8","27","5","90","2","6","25"};
        // do something
        int min = Integer.parseInt(array[0]), max = Integer.parseInt(array[0]);
        for (String s : array) {
            int tmp = Integer.parseInt(s);
            if (tmp < min) {
                min = tmp;
            } else if (tmp > max) {
                max = tmp;
            }
        }
        System.out.println("乘积: " + max * min);
    }

    public static Map<Integer,Integer> findAndReturn(List<Integer> list){
        long start = System.currentTimeMillis();

        Map<Integer, Integer> map = new HashMap<>();
        int T2 = 0, T5 = 0;
        for (Integer item : list) {
            if (!checkEqual(item)) {
                if (item % 2 == 0) {
                    ++T2;
                }
                if (item % 5 == 0) {
                    ++T5;
                }
            }
        }

        map.put(2, T2);
        map.put(5, T5);

        System.out.println("2的倍数出现次数: " + map.get(2));
        System.out.println("5的倍数出现次数: " + map.get(5));
        System.out.println("耗时: " + (System.currentTimeMillis() - start) + " ms");
        return map;
    }

    public static void main(String[] args) {

        findNumber();

        luckDraw();

        List<Integer> list = Arrays.asList(10,64,24,5,787,100,5,2);
        Map<Integer, Integer> map = findAndReturn(list);
    }

}

