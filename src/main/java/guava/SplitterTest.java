package guava;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.Map;

public class SplitterTest {
    public static void main(String[] args) {
        String str = "1-2-3-4-5-6";
        List<String> list = Splitter.on("-").splitToList(str);

        System.out.println(list);


        String str1 = "1-2-3-4-  5-  6   ";
        List<String> list1 = Splitter.on("-").omitEmptyStrings().trimResults().splitToList(str1);
        System.out.println(list1);

        String str3 = "key1=54,key2=28";
        Map<String,String> map = Splitter.on(",").withKeyValueSeparator("=").split(str3);
        System.out.println(map);
    }
}
