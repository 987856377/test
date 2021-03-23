package test;

import cn.hutool.json.JSON;
import cn.hutool.json.XML;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringEscapeUtils;

import java.util.*;

/**
 * @program: test
 * @description: json测试
 * @author: Xu Zhenkui
 * @create: 2020-08-05 11:15
 */

public class JsonTest {
    public static void main(String[] args) {
        String str = "{\n" +
                "    \"code\": 200,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"inspectionTypeName\": \"东院全部化验\",\n" +
                "            \"inspectionTypeList\": [\n" +
                "                {\n" +
                "                    \"isCompose\": \"1\",\n" +
                "                    \"number\": \"1\",\n" +
                "                    \"isEmergency\": 0,\n" +
                "                    \"inspectionItemName\": \"内毒素鲎定量测定.\",\n" +
                "                    \"inspectionItemId\": \"1465\",\n" +
                "                    \"price\": \"150\",\n" +
                "                    \"specimenTypeId\": \"Q\",\n" +
                "                    \"specimenTypeName\": \"血清\",\n" +
                "                    \"pyCode\": \"NDSFDLCDZH\"\n" +
                "                }],\n" +
                "            \"inspectionTypeId\": \"206\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"message\": \"处理成功\"\n" +
                "}";
        JSONObject res = JSONObject.parseObject(StringEscapeUtils.unescapeJavaScript(str));
        System.out.println(res.toJSONString());


        String json = "{\"test\":\"<p><span>手术指征：</span><span>诊断明确，症状明显，保守治疗效果差，结石长期刺激有致恶变可能。</span></p>\"}";

        JSONObject object = JSONObject.parseObject(StringEscapeUtils.unescapeJavaScript(json.toString()));

        System.out.println("json = " + json);

        System.out.println(object.toJSONString());


        JSONObject param = new JSONObject();
        param.put("xzbz","s");
        System.out.println(param.getString("xzbz"));
        if (param.getString("xzbz") == null){
            param.put("xzbz","C");
        }
        System.out.println(param.getString("xzbz"));

        System.out.println("xzbz = " + (param.getString("xzbz") == null));

        System.out.println(param.get("x"));

        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        System.out.println(uuid + " " + uuid.length());

        String sss = "123456";
        System.out.println(sss.substring(0,3));
    }
}
