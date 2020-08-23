package xml;

import cn.hutool.core.util.XmlUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.json.XML;
import com.alibaba.fastjson.JSONArray;
import io.Stream;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException, JAXBException {

        String s = Stream.readFile("E:\\IdeaProjects\\test\\src\\main\\java\\xml\\User.xml");
        JSONObject jsonObject = XML.toJSONObject(s);
        System.out.println(jsonObject);

        String s1 = Stream.readFile("E:\\IdeaProjects\\test\\src\\main\\java\\xml\\UserList.xml");
        JSONObject jsonObject1 = JSONUtil.parseFromXml(s1);
        System.out.println(jsonObject1);

        String s2 = Stream.readFile("E:\\IdeaProjects\\test\\src\\main\\java\\xml\\Product.xml");
        JSONObject jsonObject2 = XML.toJSONObject(s2);
        System.out.println(jsonObject2.get("products"));
        System.out.println(JSONUtil.parseArray(new JSONObject(jsonObject2.get("products")).get("product")).toList(Product.class).get(0).getContent());

    }
}
