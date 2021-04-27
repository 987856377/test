package io.freemarker;

import freemarker.template.*;
import proxy.User;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreemarkerEngine {
    public static void main(String[] args) {
        try {
            //创建一个合适的Configration对象
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
            configuration.setClassForTemplateLoading(FreemarkerEngine.class, "/templates/");
            configuration.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_31));
            configuration.setDefaultEncoding("UTF-8");
            //获取或创建一个模版。
            Template template = configuration.getTemplate("static.ftl");

            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("description", "我正在学习使用Freemarker生成静态文件！");

            User user = new User();
            user.setName("xzk");
            user.setPassword("123456");
            paramMap.put("user", user);

            List<String> nameList = new ArrayList<>();
            nameList.add("陈靖仇");
            nameList.add("玉儿");
            nameList.add("宇文拓");
            paramMap.put("nameList", nameList);

            Map<String, Object> weaponMap = new HashMap<>();
            weaponMap.put("first", "轩辕剑");
            weaponMap.put("second", "崆峒印");
            weaponMap.put("third", "女娲石");
            weaponMap.put("fourth", "神农鼎");
            weaponMap.put("fifth", "伏羲琴");
            weaponMap.put("sixth", "昆仑镜");
            weaponMap.put("seventh", null);
            paramMap.put("weaponMap", weaponMap);

            ArrayList<String> fruits = new ArrayList<>();
            fruits.add("apple");
            fruits.add("banana");
            paramMap.put("fruits", fruits);

            Writer writer = new OutputStreamWriter(new FileOutputStream("success.html"), StandardCharsets.UTF_8);
            template.process(paramMap, writer);
            writer.close();
            System.out.println("恭喜，生成成功~~");
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}
