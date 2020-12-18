package util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class XmlUtil {
    public static String mapToXml(Map<String, String> map, String root) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(root).append(">");
        sb.append(mapToXml(map));
        sb.append("</").append(root).append(">");
        return sb.toString();
    }

    public static String mapToXml(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null && !("").equals(value)) {
                sb.append("<").append(key).append("><![CDATA[").append(value).append("]]></").append(key).append(">");
            }
        }
        return sb.toString();
    }

    public static String jsonToXml(JSONObject jsonObject, String root) {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(root).append(">");
        sb.append(jsonToXml(jsonObject));
        sb.append("</").append(root).append(">");
        return sb.toString();
    }

    public static String jsonToXml(JSONObject jsonObject) {
        StringBuilder sb = new StringBuilder();
        jsonObject.keySet().forEach(key -> {
            String node = key;
            node = node.substring(0, 1).toUpperCase() + node.substring(1);
            sb.append("<").append(node).append(">");
            Object value = jsonObject.get(key);
            if (value instanceof JSONArray) {
                sb.append(jsonToXml((JSONArray) value, key));
            } else if (value instanceof JSONObject) {
                sb.append(jsonToXml((JSONObject) value));
            } else {
                sb.append("<![CDATA[").append(value).append("]]>");
            }
            sb.append("</").append(node).append(">");
        });
        return sb.toString();
    }

    public static String jsonToXml(JSONArray jsonArray, String itemName) {
        StringBuilder sb = new StringBuilder();
        jsonArray.forEach(item -> {
            sb.append("<").append(itemName).append(">");
            try {
                JSONObject obj = (JSONObject) item;
                sb.append(jsonToXml(obj));
            } catch (ClassCastException e) {
                sb.append(item);
            }
            sb.append("</").append(itemName).append(">");
        });
        return sb.toString();
    }

}
