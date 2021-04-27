package util;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.util.*;

/**
 * @program: test
 * @package test
 * @description
 * @author: XuZhenkui
 * @create: 2020-12-26 09:14
 **/
public class BloomFilterTest {
    private static final int insertions = 1000000;

    public static void main(String[] args) {

        BloomFilter<CharSequence> bloomFilter = BloomFilter.create(Funnels.stringFunnel(StandardCharsets.UTF_8), insertions, 0.01);

        int right = 0, wrong = 0;
        List<String> lists = new ArrayList<>();
        Set<String> sets = new HashSet<>();

        for (int i = 0; i < insertions; i++) {
            String s = UUID.randomUUID().toString();
            bloomFilter.put(s);
            sets.add(s);
            lists.add(s);
        }

        for (int i = 0; i < 10000; i++) {
            String data = i % 100 == 0? lists.get(i / 100) : UUID.randomUUID().toString();
            if (bloomFilter.mightContain(data)) {
                if (sets.contains(data)) {
                    right++;
                    continue;
                }
                wrong++;
            }
        }

        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMaximumFractionDigits(2);
        float percent = (float) wrong / 9900;
        float bingo = (float) (9900 - wrong) / 9900;

        System.out.println("在 " + insertions + " 条数据中，判断 100 实际存在的元素，布隆过滤器认为存在的数量为：" + right);
        System.out.println("在 " + insertions + " 条数据中，判断 990 实际不存在的元素，布隆过滤器错误认为存在的数量为：" + wrong);
        System.out.println("命中率为：" + numberFormat.format(bingo) + "，误判率为：" + numberFormat.format(percent));
    }
}
