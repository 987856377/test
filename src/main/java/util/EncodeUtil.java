package util; /**
 * @author xuzhenkui
 * @project test
 * @package PACKAGE_NAME
 * @date 2019/8/14 21:53
 */


/**
 * （1）把原字符串按字符循环获取asc码，并格式化为3位整数；
 * （2）把数字字符串进行奇偶交换（第1位和第2位交换，第3位和第4位交换，依次类推，如果总长是奇数位，则最后一位不变），重新组合数字字符串
 * 例如：原字符串是“ab2”，第一步获取asc码转换为“097098050”，第二步转换就变成“900789500”
 */
public class EncodeUtil {

    /**
     * 加密
     *
     * @param raw
     * @return
     */
    public static String encode(String raw) {
//        把原字符串按字符循环获取asc码，并格式化为3位整数；
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < raw.length(); i++) {
            s.append("0" + (int) raw.charAt(i));
        }
//        把数字字符串进行奇偶交换
        char temp;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 != 0) {
                temp = s.charAt(i - 1);
                s.setCharAt(i - 1, s.charAt(i));
                s.setCharAt(i, temp);
            }
        }
        return s.toString();
    }

    /**
     * 解密
     *
     * @param raw
     * @return
     */
    public static String decode(String raw) {
        StringBuilder s1 = new StringBuilder(raw);

//        把数字字符串进行奇偶交换
        char temp;
        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 != 0) {
                temp = s1.charAt(i - 1);
                s1.setCharAt(i - 1, s1.charAt(i));
                s1.setCharAt(i, temp);
            }
        }

//        除去原字符串按字符循环获取 asc 码，并格式化为3位整数 时添加的 0
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < s1.length() - 2; i = i + 3) {
            s2.append(s1.charAt(i + 1)).append(s1.charAt(i + 2));
        }

//        将获取到的 asc 码还原为字符
        StringBuilder s3 = new StringBuilder();
        for (int i = 0; i < s2.length(); i++) {
            if (i % 2 != 0) {
                StringBuilder s4 = new StringBuilder();
                s4.append(s2.charAt(i - 1)).append(s2.charAt(i));
                s3.append((char) Integer.parseInt(s4.toString()));
            }
        }
        return s3.toString();
    }

    public static void main(String[] args) {

        System.out.println("encode(\"ab2\") = " + encode("ab2"));
        System.out.println("decode(\"900789500\") = " + decode("900789500"));

        System.out.println();
        System.out.println("encode(decode(\"900789500\")) = " + encode(decode("900789500")));
        System.out.println("decode(encode(\"ab2\")) = " + decode(encode("ab2")));

    }
}
