package test;

import util.JsonAndXmlUtils;
import xml.po.BsXml;
import xml.po.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestObj {
    public String name;
    public boolean flag = false;

    public static void main(String[] args) {
        System.out.println("1");
        try {
            System.out.println("2");
//            int i = 1 / 0;
            System.out.println("3");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("4");
        }

        System.out.println("5");

        System.out.println(System.currentTimeMillis());
        int a = 0;
        if (a == 1) {
            System.out.println("1");
        } else if (a == 2) {
            System.out.println("2");
        } else if (a == 3) {
            System.out.println("3");
        } else {
            System.out.println("0");
        }

        String xml = "<BSXml>\n" +
                "    <MsgHeader>\n" +
                "        <Sender>MDM</Sender>\n" +
                "        <MsgType>DIC_0001</MsgType>\n" +
                "        <MsgVersion>3.1</MsgVersion>\n" +
                "        <OperationType>Update</OperationType>\n" +
                "    </MsgHeader>\n" +
                "    <Dic>\n" +
                "        <DicDomain>HIP</DicDomain>\n" +
                "        <DicId>ICD-10</DicId>\n" +
                "        <DicAlias>疾病编码字典</DicAlias>\n" +
                "        <DicVersion>3.0</DicVersion>\n" +
                "        <ModifiedTime>20181112T121212</ModifiedTime>\n" +
                "        <Items>\n" +
                "            <Item>\n" +
                "                <Id>123</Id>\n" +
                "                <Key>M10.392</Key>\n" +
                "                <Text>痛风性肾结石</Text>\n" +
                "                <ICD>M10.392</ICD>\n" +
                "                <AppendEncode></AppendEncode>\n" +
                "                <StatisticsCode>M10.392</StatisticsCode>\n" +
                "                <CategoryCode></CategoryCode>\n" +
                "                <SexLimit>0</SexLimit>\n" +
                "                <AllowCure DisplayName=\"内科\">1</AllowCure>\n" +
                "                <AllowStraightenUp>1</AllowStraightenUp>\n" +
                "                <AllowFailure>0</AllowFailure>\n" +
                "                <AllowDeath>0</AllowDeath>\n" +
                "                <EffectiveFlag>1</EffectiveFlag>\n" +
                "                <ModifiedTime>20181112T121212</ModifiedTime>\n" +
                "            </Item>\n" +
                "            <Item>\n" +
                "                <Id>122</Id>\n" +
                "                <Key>M10.3923232</Key>\n" +
                "                <Text>痛风性肾结石asdf</Text>\n" +
                "                <ICD>M10.392</ICD>\n" +
                "                <AppendEncode></AppendEncode>\n" +
                "                <StatisticsCode>M10.392</StatisticsCode>\n" +
                "                <CategoryCode></CategoryCode>\n" +
                "                <SexLimit>0</SexLimit>\n" +
                "                <AllowCure DisplayName=\"内科\">1</AllowCure>\n" +
                "                <AllowStraightenUp>1</AllowStraightenUp>\n" +
                "                <AllowFailure>0</AllowFailure>\n" +
                "                <AllowDeath>0</AllowDeath>\n" +
                "                <EffectiveFlag>1</EffectiveFlag>\n" +
                "                <ModifiedTime>20181112T121212</ModifiedTime>\n" +
                "            </Item>\n" +
                "        </Items>\n" +
                "    </Dic>\n" +
                "</BSXml>\n";
        List<Item> items = JsonAndXmlUtils.xmlToObject(xml, BsXml.class).getDic().getItems();
        for (Item item : items) {
            System.out.println(item);
        }

        String xml2 = "<BSXml>\n" +
                "<MsgHeader>\n" +
                "<Sender>HIS</Sender>\n" +
                "<MsgType>RES_0101</MsgType>\n" +
                "<MsgVersion>3.0</MsgVersion>\n" +
                "</MsgHeader>\n" +
                "<Personnel>\n" +
                "<PersonId>1212</PersonId>\n" +
                "<PersonCode>1212</PersonCode>\n" +
                "<PersonName>姓名</PersonName>\n" +
                "<SpellCode>asdfas</SpellCode>\n" +
                "<Gender DisplayName=\"男性\">1</Gender>\n" +
                "<Birthday>出生日期</Birthday>\n" +
                "<Birthplace>出生地址</Birthplace>\n" +
                "<Address>联系地址</Address>\n" +
                "<CardType>01</CardType>\n" +
                "<CardNum>证件号码</CardNum>\n" +
                "<Hometown>籍贯</Hometown>\n" +
                "<Ethnic>01</Ethnic>\n" +
                "<Mobile>电话</Mobile>\n" +
                "<Email>邮箱</Email>\n" +
                "<PersonType>1</PersonType> \n" +
                "<OrganizCode DisplayName=\"第一人民医院\">02123213-1</OrganizCode>\n" +
                "<OfficeCode DisplayName=\"内科\">01</OfficeCode>\n" +
                "<MajorName DisplayName=\"临床医学\">1031</MajorName>\n" +
                "<Education DisplayName=\"大学本科毕业\">21</Education>\n" +
                "<EducationBackground  DisplayName=\"学士\">4</EducationBackground>\n" +
                "<Joininwork>参加工作时间</Joininwork>\n" +
                "<QualificationNum>资格证书编号</QualificationNum>\n" +
                "<CertificateNum>执业证书编号</CertificateNum>\n" +
                "<OperationScope DisplayName=\"内科专业\">A11</OperationScope>\n" +
                "<Jobpost DisplayName=\"科室主任\">4</Jobpost>\n" +
                "<MajorType DisplayName=\"主任医师\">231</MajorType>\n" +
                "<ProfessionalCategoryCode DisplayName=\"正高\">1</ProfessionalCategoryCode>\n" +
                "<Logoff>注销标志</Logoff>\n" +
                "<Remark>备注</Remark>\n" +
                "</BSXml> \n";
        System.out.println(JsonAndXmlUtils.getXmlListElementValue(xml, "AllowCure"));
    }

    public static String getXmlSingleElementValue(String xml, String element) {
        if (xml == null || "".equals(xml) || element == null || "".equals(element)) {
            return null;
        }
        //元素名<ELEMENT key = value ...>(.*)<ELEMENT/>
        StringBuffer regex = new StringBuffer();
        regex.append("<").append(element + ".*").append(">");
        regex.append("(.*)");
        regex.append("</").append(element).append(">");

        String str = "";
        Matcher matcher = Pattern.compile(regex.toString()).matcher(xml);
        while (matcher.find()) {
            str = matcher.group(1);
        }
        return str;
    }

    public static List<String> getXmlListElementValue(String xml, String element) {
        if (xml == null || "".equals(xml) || element == null || "".equals(element)) {
            return null;
        }
        List<String> list = new ArrayList<String>();
        //元素名<ELEMENT key = value ...>([^</ELEMENT>]*)</ELEMENT>
        StringBuffer regex = new StringBuffer();
        regex.append("<").append(element + ".*").append(">");
        regex.append("([^</" + element + ">]*)");
        regex.append("</").append(element).append(">");
        Matcher matcher = Pattern.compile(regex.toString()).matcher(xml);
        while (matcher.find()) {
            list.add(matcher.group(1));
        }
        return list;
    }
}
