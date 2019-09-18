/**
 * @author xuzhenkui
 * @project test
 * @package PACKAGE_NAME
 * @date 2019/8/14 21:53
 */


import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * （1）把原字符串按字符循环获取asc码，并格式化为3位整数；
 * （2）把数字字符串进行奇偶交换（第1位和第2位交换，第3位和第4位交换，依次类推，如果总长是奇数位，则最后一位不变），重新组合数字字符串
 * 例如：原字符串是“ab2”，第一步获取asc码转换为“097098050”，第二步转换就变成“900789500”
 */
public class EncodeUtil {

    /**
     *  加密
     * @param raw
     * @return
     */
    public static String encode(@NotNull String raw){
//        把原字符串按字符循环获取asc码，并格式化为3位整数；
        StringBuilder s = new StringBuilder();
        for(int i=0 ; i<raw.length(); ++i){
//            stringBuilder.append("0"+(int)raw.charAt(i));
            s.append("0"+(int)raw.charAt(i));

        }
//        把数字字符串进行奇偶交换
        char temp;
        for (int i=0; i<s.length(); ++i){
            if (i%2!=0){
                temp = s.charAt(i-1);
                s.setCharAt(i-1,s.charAt(i)) ;
                s.setCharAt(i,temp);
            }
        }
        return String.valueOf(s);
    }

    /**
     *  解密
     * @param raw
     * @return
     */
    public static String decode(String raw){
        StringBuilder stringBuilder = new StringBuilder(raw);
//        把数字字符串进行奇偶交换
        char temp;
        for (int i=0; i<stringBuilder.length(); ++i){
            if (i%2!=0){
                temp = stringBuilder.charAt(i-1);
                stringBuilder.setCharAt(i-1,raw.charAt(i)) ;
                stringBuilder.setCharAt(i,temp);
            }
        }

//        除去原字符串按字符循环获取 asc 码，并格式化为3位整数 时添加的 0
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < stringBuilder.length()-2; i=i+3) {
            s.append(stringBuilder.charAt(i+1));
            s.append(stringBuilder.charAt(i+2));
        }

//        将获取到的 asc 码还原为字符
        StringBuilder s1 = new StringBuilder();
        String s2;
        for (int i = 0; i < s.length(); i++) {
            if (i%2!=0){
                s2 = String.valueOf(s.charAt(i-1))+String.valueOf(s.charAt(i));
                s1.append((char) (int)Integer.valueOf(s2));
            }
        }
        return String.valueOf(s1);
    }

    public static void main(String[] args){
        System.out.println(encode("ab2"));
        System.out.println(decode("900789500"));

//        500155500035500015400975500605400855500055400945400994
        System.out.println(decode("500155500035500015400975500605400855500055400945400994"));

        Map<String,String> map = new ConcurrentHashMap<>();

    }
}
