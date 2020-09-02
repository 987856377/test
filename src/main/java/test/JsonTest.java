package test;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringEscapeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    }
}
