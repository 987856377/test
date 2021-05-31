package test;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.DocumentException;
import tool.util.JsonAndXmlUtils;
import tool.util.XPathUtils;
import tool.xml.convert.User;
import tool.xml.po.BsXml;
import tool.xml.po.Item;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestObj {
    public String name;
    public boolean flag = false;

    public static void main(String[] args) throws DocumentException, IOException, ParserConfigurationException {

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
        System.out.println(xml);
        String valueFromXml = XPathUtils.getValueFromXml(xml, "/BSXml/Dic/Items/Item/Text/text()");
        System.out.println(valueFromXml);
        List<Item> items = JsonAndXmlUtils.xmlToObject(xml, BsXml.class).getDic().getItems();
        for (Item item : items) {
            System.out.println(item);
        }

        System.out.println((JsonAndXmlUtils.xmlNodeFirstLetterToUpper(JsonAndXmlUtils.objectToXml(JsonAndXmlUtils.xmlToObject(xml, BsXml.class)))));

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

        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        Map<String, String> map = new HashMap<>();
        User user = new User();
        user.setUsername("frank");
        map.put("name", user.getUsername());
        map.put("pwd", user.getPassword());

        System.out.println(map.get("name"));
        System.out.println(map.get("pwd"));

        String str = " ";
        System.out.println(StringUtils.isNotBlank(str));

        String xm = "<BSXml>\n" +
                "    <MsgHeader>\n" +
                "        <Sender>ZJJ</Sender>\n" +
                "        <MsgType>ZJJ_FYJ</MsgType>\n" +
                "        <MsgVersion>3.0</MsgVersion>\n" +
                "    </MsgHeader>\n" +
                "    <Body>\n" +
                "        <BALANCE> 35207941 </BALANCE>\n" +
                "    </Body>\n" +
                "</BSXml>\n";
        xm = xm.replace("\n", "").replace(" ", "");
        System.out.println(xm);

        String xxx = "\"{\\\"code\\\":200,\\\"message\\\":\\\"处理成功\\\",\\\"data\\\":[{\\\"patientCode\\\":\\\"6730364\\\",\\\"patientMedicalCardType\\\":\\\"2\\\",\\\"patientMedicalCardNumber\\\":\\\"02043358\\\",\\\"patientName\\\":\\\"李俊浩\\\",\\\"patientSex\\\":\\\"1\\\",\\\"patientAge\\\":\\\"19\\\",\\\"invoiceList\\\":[{\\\"payStatus\\\":\\\"0\\\",\\\"invoiceNumber\\\":\\\"MS1230753683\\\",\\\"costdate\\\":\\\"2021-04-08 09:08:04\\\",\\\"medicalDate\\\":\\\"2021-04-08 09:08:04\\\",\\\"diagnosisRecordId\\\":\\\"36938103\\\",\\\"admNumber\\\":\\\"36938103\\\",\\\"amount\\\":\\\"440.36\\\",\\\"payAmount\\\":\\\"440.36\\\",\\\"invoiceStatus\\\":\\\"未打印发票\\\",\\\"feeDate\\\":\\\"2021-04-08 09:08:04\\\",\\\"barCode\\\":\\\"\\\",\\\"totalFee\\\":\\\"440.36\\\",\\\"tollCollectorName\\\":\\\"手机1\\\",\\\"tollCollector\\\":\\\"APP1\\\",\\\"mzxh\\\":\\\"36938103\\\",\\\"yplx\\\":\\\"\\\",\\\"costList\\\":[{\\\"itemName\\\":\\\"布地奈德福莫特罗吸入粉雾剂（Ⅱ）\\\",\\\"itemCode\\\":\\\"3549\\\",\\\"mergingCode\\\":\\\"2\\\",\\\"mergingName\\\":\\\"西药费\\\",\\\"executionStatus\\\":\\\"0\\\",\\\"execute\\\":\\\"一楼综合药房\\\",\\\"remark\\\":\\\"一楼综合药房\\\"}]},{\\\"payStatus\\\":\\\"0\\\",\\\"invoiceNumber\\\":\\\"MS1230640642\\\",\\\"costdate\\\":\\\"2021-02-04 16:37:26\\\",\\\"medicalDate\\\":\\\"2021-02-04 16:37:26\\\",\\\"diagnosisRecordId\\\":\\\"36179347\\\",\\\"admNumber\\\":\\\"36179347\\\",\\\"amount\\\":\\\"125.64\\\",\\\"payAmount\\\":\\\"125.64\\\",\\\"invoiceStatus\\\":\\\"未打印发票\\\",\\\"feeDate\\\":\\\"2021-02-04 16:37:26\\\",\\\"barCode\\\":\\\"\\\",\\\"totalFee\\\":\\\"125.64\\\",\\\"tollCollectorName\\\":\\\"手机1\\\",\\\"tollCollector\\\":\\\"APP1\\\",\\\"mzxh\\\":\\\"36179347\\\",\\\"yplx\\\":\\\"\\\",\\\"costList\\\":[{\\\"itemName\\\":\\\"苍耳子鼻炎滴丸\\\",\\\"itemCode\\\":\\\"6158\\\",\\\"mergingCode\\\":\\\"3\\\",\\\"mergingName\\\":\\\"中成药\\\",\\\"executionStatus\\\":\\\"1\\\",\\\"execute\\\":\\\"一楼综合药房\\\",\\\"remark\\\":\\\"一楼综合药房\\\"}]},{\\\"payStatus\\\":\\\"0\\\",\\\"invoiceNumber\\\":\\\"YSYJ874117\\\",\\\"costdate\\\":\\\"2021-02-04 16:32:59\\\",\\\"medicalDate\\\":\\\"2021-02-04 16:32:59\\\",\\\"diagnosisRecordId\\\":\\\"36179305\\\",\\\"admNumber\\\":\\\"36179305\\\",\\\"amount\\\":\\\"5\\\",\\\"payAmount\\\":\\\"5\\\",\\\"invoiceStatus\\\":\\\"未打印发票\\\",\\\"feeDate\\\":\\\"2021-02-04 16:32:59\\\",\\\"barCode\\\":\\\"\\\",\\\"totalFee\\\":\\\"5\\\",\\\"tollCollectorName\\\":\\\"段丽华\\\",\\\"tollCollector\\\":\\\"366\\\",\\\"mzxh\\\":\\\"36179305\\\",\\\"yplx\\\":\\\"\\\",\\\"costList\\\":[{\\\"itemName\\\":\\\"前鼻镜检查\\\",\\\"itemCode\\\":\\\"10045\\\",\\\"mergingCode\\\":\\\"14\\\",\\\"mergingName\\\":\\\"检查费\\\",\\\"executionStatus\\\":\\\"2\\\",\\\"execute\\\":\\\"东院鼻科门诊\\\",\\\"remark\\\":\\\"东院鼻科门诊\\\"}]},{\\\"payStatus\\\":\\\"0\\\",\\\"invoiceNumber\\\":\\\"YF3319705\\\",\\\"costdate\\\":\\\"2021-01-11 14:15:56\\\",\\\"medicalDate\\\":\\\"2021-01-11 14:15:56\\\",\\\"diagnosisRecordId\\\":\\\"35862039\\\",\\\"admNumber\\\":\\\"35862039\\\",\\\"amount\\\":\\\"45.09\\\",\\\"payAmount\\\":\\\"45.09\\\",\\\"invoiceStatus\\\":\\\"未打印发票\\\",\\\"feeDate\\\":\\\"2021-01-11 14:15:56\\\",\\\"barCode\\\":\\\"\\\",\\\"totalFee\\\":\\\"45.09\\\",\\\"tollCollectorName\\\":\\\"赵陶钧\\\",\\\"tollCollector\\\":\\\"2205\\\",\\\"mzxh\\\":\\\"35862039\\\",\\\"yplx\\\":\\\"\\\",\\\"costList\\\":[{\\\"itemName\\\":\\\"布地奈德鼻喷雾剂\\\",\\\"itemCode\\\":\\\"2931\\\",\\\"mergingCode\\\":\\\"2\\\",\\\"mergingName\\\":\\\"西药费\\\",\\\"executionStatus\\\":\\\"1\\\",\\\"execute\\\":\\\"一楼综合药房\\\",\\\"remark\\\":\\\"一楼综合药房\\\"}]},{\\\"payStatus\\\":\\\"0\\\",\\\"invoiceNumber\\\":\\\"YSYJ845724\\\",\\\"costdate\\\":\\\"2021-01-11 14:02:09\\\",\\\"medicalDate\\\":\\\"2021-01-11 14:02:09\\\",\\\"diagnosisRecordId\\\":\\\"35861640\\\",\\\"admNumber\\\":\\\"35861640\\\",\\\"amount\\\":\\\"80\\\",\\\"payAmount\\\":\\\"80\\\",\\\"invoiceStatus\\\":\\\"未打印发票\\\",\\\"feeDate\\\":\\\"2021-01-11 14:02:09\\\",\\\"barCode\\\":\\\"\\\",\\\"totalFee\\\":\\\"80\\\",\\\"tollCollectorName\\\":\\\"宋道亮\\\",\\\"tollCollector\\\":\\\"10\\\",\\\"mzxh\\\":\\\"35861640\\\",\\\"yplx\\\":\\\"\\\",\\\"costList\\\":[{\\\"itemName\\\":\\\"鼻内镜检查\\\",\\\"itemCode\\\":\\\"10043\\\",\\\"mergingCode\\\":\\\"14\\\",\\\"mergingName\\\":\\\"检查费\\\",\\\"executionStatus\\\":\\\"2\\\",\\\"execute\\\":\\\"东院鼻科门诊\\\",\\\"remark\\\":\\\"东院鼻科门诊\\\"}]},{\\\"payStatus\\\":\\\"0\\\",\\\"invoiceNumber\\\":\\\"YJ3783327\\\",\\\"costdate\\\":\\\"2021-01-11 11:27:14\\\",\\\"medicalDate\\\":\\\"2021-01-11 11:27:14\\\",\\\"diagnosisRecordId\\\":\\\"35859928\\\",\\\"admNumber\\\":\\\"35859928\\\",\\\"amount\\\":\\\"25\\\",\\\"payAmount\\\":\\\"25\\\",\\\"invoiceStatus\\\":\\\"未打印发票\\\",\\\"feeDate\\\":\\\"2021-01-11 11:27:14\\\",\\\"barCode\\\":\\\"\\\",\\\"totalFee\\\":\\\"25\\\",\\\"tollCollectorName\\\":\\\"郅莉莉\\\",\\\"tollCollector\\\":\\\"9394\\\",\\\"mzxh\\\":\\\"35859928\\\",\\\"yplx\\\":\\\"\\\",\\\"costList\\\":[{\\\"itemName\\\":\\\"一次性麻醉呼吸过滤器MHG-J\\\",\\\"itemCode\\\":\\\"21538\\\",\\\"mergingCode\\\":\\\"47\\\",\\\"mergingName\\\":\\\"医用低值耗材\\\",\\\"executionStatus\\\":\\\"2\\\",\\\"execute\\\":\\\"东院变态反应门诊\\\",\\\"remark\\\":\\\"东院变态反应门诊\\\"}]},{\\\"payStatus\\\":\\\"0\\\",\\\"invoiceNumber\\\":\\\"YJ3783322\\\",\\\"costdate\\\":\\\"2021-01-11 11:26:57\\\",\\\"medicalDate\\\":\\\"2021-01-11 11:26:57\\\",\\\"diagnosisRecordId\\\":\\\"35859918\\\",\\\"admNumber\\\":\\\"35859918\\\",\\\"amount\\\":\\\"260\\\",\\\"payAmount\\\":\\\"260\\\",\\\"invoiceStatus\\\":\\\"未打印发票\\\",\\\"feeDate\\\":\\\"2021-01-11 11:26:57\\\",\\\"barCode\\\":\\\"\\\",\\\"totalFee\\\":\\\"260\\\",\\\"tollCollectorName\\\":\\\"郅莉莉\\\",\\\"tollCollector\\\":\\\"9394\\\",\\\"mzxh\\\":\\\"35859918\\\",\\\"yplx\\\":\\\"\\\",\\\"costList\\\":[{\\\"itemName\\\":\\\"有最大通气量加收(呼吸)\\\",\\\"itemCode\\\":\\\"17752\\\",\\\"mergingCode\\\":\\\"14\\\",\\\"mergingName\\\":\\\"检查费\\\",\\\"executionStatus\\\":\\\"2\\\",\\\"execute\\\":\\\"东院变态反应门诊\\\",\\\"remark\\\":\\\"东院变态反应门诊\\\"},{\\\"itemName\\\":\\\"流速容量曲线(V—V曲线)\\\",\\\"itemCode\\\":\\\"10354\\\",\\\"mergingCode\\\":\\\"14\\\",\\\"mergingName\\\":\\\"检查费\\\",\\\"executionStatus\\\":\\\"2\\\",\\\"execute\\\":\\\"东院变态反应门诊\\\",\\\"remark\\\":\\\"东院变态反应门诊\\\"},{\\\"itemName\\\":\\\"肺通气功能检查\\\",\\\"itemCode\\\":\\\"16145\\\",\\\"mergingCode\\\":\\\"45\\\",\\\"mergingName\\\":\\\"肺功能\\\",\\\"executionStatus\\\":\\\"2\\\",\\\"execute\\\":\\\"东院变态反应门诊\\\",\\\"remark\\\":\\\"东院变态反应门诊\\\"},{\\\"itemName\\\":\\\"支气管舒张试验\\\",\\\"itemCode\\\":\\\"6347\\\",\\\"mergingCode\\\":\\\"45\\\",\\\"mergingName\\\":\\\"肺功能\\\",\\\"executionStatus\\\":\\\"2\\\",\\\"execute\\\":\\\"东院变态反应门诊\\\",\\\"remark\\\":\\\"东院变态反应门诊\\\"}]}]}]}\"";
        String s = xxx.replaceAll("\\\\", "");
        String substring = s.substring(1, s.length() - 1);
        System.out.println(substring);
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
