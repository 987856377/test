package tool.xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;

public class DocumentConvert {

    {
        System.out.println("构造代码块");
    }

    static {
        System.out.println("静态代码块");
    }

    public DocumentConvert() {
        System.out.println("构造方法");
    }

    public static void main(String[] args) throws Exception {
        DocumentConvert d = new DocumentConvert();

        String xml = "<BSXml>\n" +
                "    <MsgHeader>\n" +
                "        <Sender>ZJJ</Sender>\n" +
                "        <MsgType>ZJJ_FYJ</MsgType>\n" +
                "        <MsgVersion>3.0</MsgVersion>\n" +
                "    </MsgHeader>\n" +
                "    <Body>\n" +
                "        <BALANCE> 35207941 </BALANCE>\n" +
                "    </Body>\n" +
                "</BSXml>\n";
        xml = xml.replace("\n", "").replace(" ", "");
        System.out.println(xml);

//      xml 字符串转为 Document
        Document document2 = DocumentHelper.parseText(xml);
        Element rootElement = document2.getRootElement();
        Element body = rootElement.element("Body");
        Element balance = body.element("BALANCE");
        System.out.println(balance.getTextTrim());

//      读取 xml 文件
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("D:\\IdeaProjects\\test\\src\\main\\java\\xml\\convert\\test.xml"));
        Element root = document.getRootElement();

//        Document 转为 xml字符串
        String docXmlText = document.asXML();
        System.out.println(docXmlText);
        System.out.println("---------------------------");

        String rootXmlText = root.asXML();
        System.out.println(rootXmlText);
        System.out.println("---------------------------");

        Element e = root.element("Body");
        System.out.println(e.asXML());

//        创建xml
        Document document1 = DocumentHelper.createDocument();
        Element root1 = document1.addElement("root");
        Element author1 = root1.addElement("author").addAttribute("name", "James").addAttribute("location", "UK").addText("许振奎");
        Element author2 = root1.addElement("author").addAttribute("name", "Bob").addAttribute("location", "US").addText("Bob McWhirter");

//        输出 xml 字符串
        System.out.println(root1.asXML());
        System.out.println(author1.getTextTrim());

//        保存为 xml 文件
        /** 格式化输出,类型IE浏览一样 */
        OutputFormat format = OutputFormat.createPrettyPrint();
        /** 指定XML编码 */
        format.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(new FileWriter("foo.xml"), format);
        writer.write(document);
        writer.close();

    }
}
