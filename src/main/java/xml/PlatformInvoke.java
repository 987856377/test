package xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import reflect.Person;
import util.JsonAndXmlUtils;
import util.XmlUtil;
import xml.wapper.BSXml;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: test
 * @package xml
 * @description
 * @author: XuZhenkui
 * @create: 2020-12-16 09:47
 **/
public class PlatformInvoke {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, JsonProcessingException {
        User user = new User();
        user.setUsername("dskj");
        user.setPassword("121212");
        user.setFlag(true);
        Person person1 = new Person();
        person1.setName("N1");
        person1.setAge(1);
        person1.setAlive(true);

        Person person2 = new Person();
        person2.setName("N2");
        person2.setAge(1);
        person2.setAlive(true);

        user.setList(Arrays.asList("a","b","c"));

        user.setPerson(person1);
        user.setPersonList(Arrays.asList(person1,person2));

        String user1 = JsonAndXmlUtils.objectToJson(user);
        String user2 = JsonAndXmlUtils.objectToXml(user);
        System.out.println("userJson = " + user1);
        System.out.println("userXml = " + user2);

        String userString = JsonAndXmlUtils.objectToJson(user);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<BSXml>");
        Map<String,String> map = new HashMap<>();
        map.put("Sender","HOL");
        map.put("MsgType","HOL_0101");
        map.put("MsgVersion","3.2");
        String s = XmlUtil.mapToXml(map);
        stringBuilder.append(s);
        stringBuilder.append("<Body><![CDATA[").append(userString).append("]]></Body>").append("</BSXml>");

        System.out.println("userString = " + userString);
        System.out.println("stringBuilder = " + stringBuilder);
        System.out.println();


        BSXml bsXml = new BSXml();
        bsXml.setSender("HOL");
        bsXml.setMsgType("HOL_0101");
        bsXml.setMsgVersion("3.2");
        bsXml.setBody(JsonAndXmlUtils.objectToJson(user));
        String objectToJson = JsonAndXmlUtils.objectToJson(bsXml);
        String objectToXml = JsonAndXmlUtils.objectToXml(bsXml);
        System.out.println("objectToJson = " + objectToJson);
        System.out.println("objectToXml = " + objectToXml);
        System.out.println();


        BSXml bsXml1 = JsonAndXmlUtils.jsonToObject(objectToJson, BSXml.class);
        System.out.println("jsonToObject = " + bsXml1);
        BSXml bsXml2 = JsonAndXmlUtils.xmlToObject(objectToXml, BSXml.class);
        System.out.println("xmlToObject = " + bsXml2);
        System.out.println();

        System.out.println("bsXml1.getBody() = " + bsXml1.getBody());
        System.out.println("bsXml2.getBody() = " + bsXml2.getBody());


        System.out.println("JsonAndXmlUtils.objectToJson(\"hello\") = " + JsonAndXmlUtils.objectToXml("hello"));
//        JSONObject.parseObject(bsXml1)

//        XmlRequest xmlRequest = new XmlRequestBuilder().setSender("HOL").setMsgType("HOL_0101").setMsgVersion("3.0").setData(user).build();
//
//        System.out.println("xmlRequest = " + xmlRequest);
//
//        String s1 = JSONObject.toJSONString(xmlRequest);
//        System.out.println("s1 = " + s1);
//
//        String s2 = XmlUtil.jsonToXml(JSONObject.parseObject(JSONObject.toJSONString(xmlRequest)));
//        System.out.println("s2 = " + s2);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String s = objectMapper.writeValueAsString(xmlRequest);
//        System.out.println(s);
//
//        XmlMapper xmlMapper = new XmlMapper();
//        String s3 = xmlMapper.writeValueAsString(xmlRequest);
//        System.out.println("s3 = " + s3);
//
//        XmlRequest xmlRequest1 = xmlMapper.readValue(s3, XmlRequest.class);
//        System.out.println("xmlRequest1 = " + xmlRequest1);
//        User user1  = (User) xmlRequest1.getData();
//        System.out.println("user1 = " + user1);
    }
}
