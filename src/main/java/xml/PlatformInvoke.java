package xml;

import com.alibaba.fastjson.JSONObject;
import reflect.Person;
import util.JsonAndXmlUtils;
import util.XmlUtil;
import xml.wapper.BSXml;
import xml.wapper.XmlRequest;
import xml.wapper.XmlRequestBuilder;

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

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
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

        BSXml bsXml3 = JsonAndXmlUtils.xmlToObject(stringBuilder.toString(), BSXml.class);
        System.out.println("bsXml3 = " + bsXml3);
        System.out.println();


        BSXml bsXml = new BSXml();
        bsXml.setSender(XmlConstants.SENDER);
        bsXml.setMsgType(XmlConstants.MSG_TYPE);
        bsXml.setMsgVersion(XmlConstants.MSG_VERSION);
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

        XmlRequest xmlRequest = new XmlRequestBuilder().setSender("HOL").setMsgType("HOL_0101").setMsgVersion("3.0").setData(user).build();

        System.out.println("xmlRequest = " + xmlRequest);

        String s1 = JSONObject.toJSONString(xmlRequest);
        System.out.println("s1 = " + s1);
        String msgHeader = JsonAndXmlUtils.jsonToMap(s1).get("msgHeader").toString();
        System.out.println("msgHeader = " + msgHeader);
        System.out.println("jsonToMap = " + JsonAndXmlUtils.jsonToMap(s1));
        System.out.println("mapToXml = " + JsonAndXmlUtils.mapToXml(JsonAndXmlUtils.jsonToMap(s1)));

        String s2 = XmlUtil.jsonToXml(JSONObject.parseObject(s1));
        System.out.println("s2 = " + s2);

        System.out.println("JsonAndXmlUtils.xmlForHai(null) = " + JsonAndXmlUtils.xmlForHai(null));

    }
}
