package xml;

import cn.hutool.json.JSONUtil;
import cn.hutool.json.XML;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonFactory;
import reflect.Person;
import util.JsonUtils;
import util.XmlUtil;
import xml.wapper.XmlRequest;
import xml.wapper.XmlRequestBuilder;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

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

        user.setPerson(person1);
        user.setPersonList(Arrays.asList(person1,person2));

        XmlRequest xmlRequest = new XmlRequestBuilder().setSender("HOL").setMsgType("HOL_0101").setMsgVersion("3.0").setData(user).build();

        System.out.println("xmlRequest = " + xmlRequest);

        String s1 = JSONObject.toJSONString(xmlRequest);
        System.out.println("s1 = " + s1);

        String s2 = XmlUtil.jsonToXml(JSONObject.parseObject(JSONObject.toJSONString(xmlRequest)));
        System.out.println("s2 = " + s2);

    }
}
