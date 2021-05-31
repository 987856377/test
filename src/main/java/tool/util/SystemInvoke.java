package tool.util;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @Description
 * @Project test
 * @Package test
 * @Author xuzhenkui
 * @Date 2021-05-2409:22
 */
public class SystemInvoke {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String cmd = "ping www.baidu.com";
//        System.out.println(invoke(cmd));
//        File zip = ZipUtil.zip("D:\\files\\工具", "D:\\files\\compress.zip", true);
        System.out.println(URLEncoder.encode("D:\\files\\工具\\arthas.txt","UTF-8"));

        File file = new File("D:\\files\\工具\\arthas.txt.zip");
        System.out.println(file.getName());
        System.out.println(file.getName().substring(0, file.getName().indexOf(".")));
    }

    public static String invoke(String command) {
        Runtime run = Runtime.getRuntime();
        try {
            Process p = run.exec(command);

            StringBuilder builder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(p.getInputStream())));
            String lineStr;
            while ((lineStr = bufferedReader.readLine()) != null) {
                //获得命令执行后在控制台的输出信息
                System.out.println(lineStr);// 打印输出信息
                builder.append(new String(lineStr.getBytes(StandardCharsets.UTF_8))).append("\n");
            }
            bufferedReader.close();

            //p.exitValue()==0表示正常结束，1：非正常结束
            if (p.waitFor() != 0 && p.exitValue() == 1) {
                System.err.println("命令执行失败!");
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
