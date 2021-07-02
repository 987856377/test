package test;

import java8.io.Stream;
import tool.util.EncodingDetect;

import java.io.*;

/**
 * @Description
 * @Project test
 * @Package test
 * @Author xuzhenkui
 * @Date 2021/6/3 11:19
 */
public class FileEncodeTest {
    public static void main(String[] args) throws IOException {
        System.out.println(EncodingDetect.getJavaEncode("D:\\download\\1.xml"));
        System.out.println(EncodingDetect.getJavaEncode("D:\\download\\qq.xml"));
        System.out.println(EncodingDetect.getJavaEncode("D:\\download\\ClAFOGC_0iCAcKlaAABoa9aYL1k436.xml"));
        System.out.println(EncodingDetect.readFile("D:\\download\\ClAFOGC_0iCAcKlaAABoa9aYL1k436.xml", "ISO8859_1"));
        System.out.println(Stream.readFile("D:\\download\\ClAFOGC_0iCAcKlaAABoa9aYL1k436.xml"));

        convert("D:\\download\\ClAFOGC_0iCAcKlaAABoa9aYL1k436.xml", "D:\\download\\ClAFOGC_0iCAcKlaAABoa9aYL1k436-1.xml", "UTF-8");
    }


    public static void convert(String sourceFile, String destFile, String destCode) throws IOException {
        StringBuffer sb = new StringBuffer();
        //得到当前文件的编码
        String ch = EncodingDetect.getJavaEncode(sourceFile);
        InputStreamReader isr;
        OutputStreamWriter osw;
        //根据当前文件编码进行解码
        if (ch.equals("UTF8")) {
            isr = new InputStreamReader(new FileInputStream(sourceFile), "UTF-8");
        } else if (ch.equals("Unicode")) {
            isr = new InputStreamReader(new FileInputStream(sourceFile), "Unicode");
        } else if (ch.equals("GB2312")) {
            isr = new InputStreamReader(new FileInputStream(sourceFile), "GB2312");
        } else if (ch.equals("GBK")) {
            isr = new InputStreamReader(new FileInputStream(sourceFile), "GBK");
        } else {
            isr = new InputStreamReader(new FileInputStream(sourceFile), "GB2312");
        }
        //将字符串存入StringBuffer中
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        br.close();
        isr.close();

        //以哪种方式写入文件
        if ("UTF-8".equals(destCode)) {
            osw = new OutputStreamWriter(new FileOutputStream(destFile), "UTF-8");
        } else if ("Unicode".equals(destCode)) {
            osw = new OutputStreamWriter(new FileOutputStream(destFile), "Unicode");
        } else if ("GB2312".equals(destCode)) {
            osw = new OutputStreamWriter(new FileOutputStream(destFile), "GB2312");
        } else if ("GBK".equals(destCode)) {
            osw = new OutputStreamWriter(new FileOutputStream(destFile), "GBK");
        } else {
            osw = new OutputStreamWriter(new FileOutputStream(destFile), "UTF-8");
        }

        BufferedWriter bw = new BufferedWriter(osw);
        bw.write(sb.toString());
        bw.close();
        osw.close();
    }

}
