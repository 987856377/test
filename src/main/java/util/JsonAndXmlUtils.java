package util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * @program: test
 * @package util
 * @description
 * @author: XuZhenkui
 * @create: 2020-12-16 15:41
 **/
public class JsonAndXmlUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();
        private static XmlMapper xmlMapper = new XmlMapper();

    static {
        // 对于空的对象转json的时候不抛出错误
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // 允许属性名称没有引号
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // 允许单引号
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 设置输入时忽略在json字符串中存在但在java对象实际没有的属性
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 设置输出时包含属性的风格
        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);

        // 对于空的对象转json的时候不抛出错误
        xmlMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // 允许属性名称没有引号
        xmlMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // 允许单引号
        xmlMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 设置输入时忽略在json字符串中存在但在java对象实际没有的属性
        xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 设置输出时包含属性的风格
        xmlMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        // 解析大小写不敏感
        xmlMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        // 正常忽略多余字段
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    /**
     * 序列化，将对象转化为json字符串
     *
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
        if (data == null) {
            return null;
        }
        String json;
        try {
            json = objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            return null;
        }
        return json;
    }

    /**
     * 序列化，将对象转化为xml字符串
     *
     * @param data
     * @return
     */
    public static String objectToXml(Object data) {
        if (data == null) {
            return null;
        }
        String xml;
        try {
            xml = xmlMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            return null;
        }
        return xml;
    }


    /**
     * 反序列化，将json字符串转化为对象
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T jsonToObject(String json, Class<T> clazz) {
        T t;
        try {
            t = objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            return null;
        }
        return t;
    }

    /**
     * 反序列化，将xml字符串转化为对象
     * @param xml
     * @param clazz
     * @param <T>
     * @return T
     */
    public static <T> T xmlToObject(String xml, Class<T> clazz) {
        T t;
        try {
            t = xmlMapper.readValue(xml, clazz);
        } catch (Exception e) {
            return null;
        }
        return t;
    }

}
