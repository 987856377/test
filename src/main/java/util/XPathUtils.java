package util;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.StringReader;

/**
 * @program: test
 * @package util
 * @description
 * @author: XuZhenkui
 * @create: 2021-03-02 11:41
 **/
public class XPathUtils {

    private static XPath xPath = null;
    private static DocumentBuilder builder = null;

    static {
        try {
            xPath = XPathFactory.newInstance().newXPath();
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static String getValueFromXml(String xml, String expression) {
        InputSource is = new InputSource(new StringReader(xml));
        Document document = null;
        Object evaluate = null;

        try {
            document = builder.parse(is);
            evaluate = xPath.evaluate(expression, document, XPathConstants.STRING);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return (String) evaluate;
    }

    public static void main(String[] args) {
        try {

            String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<BSXml>\n" +
                    "    <MsgHeader>\n" +
                    "        <Sender>HIS</Sender>\n" +
                    "        <MsgType>PAT_0101</MsgType>\n" +
                    "        <MsgVersion>3.1</MsgVersion>\n" +
                    "        <EffectiveTime/>\n" +
                    "    </MsgHeader>\n" +
                    "    <Patient>\n" +
                    "        <MpiId/>\n" +
                    "        <PatientId/>\n" +
                    "        <AuthorOrganization DisplayName=\"79649060-6\">79649060-6</AuthorOrganization>\n" +
                    "        <SourcePatientId/>\n" +
                    "        <SourcePatientIdType DisplayName=\"OV\">OV</SourcePatientIdType>\n" +
                    "        <HealthRecordId/>\n" +
                    "        <IdCard/>\n" +
                    "        <IdCardCode DisplayName=\"\"/>\n" +
                    "        <HealthCardId/>\n" +
                    "        <HealthCardOrganization DisplayName=\"\"/>\n" +
                    "        <MedicalInsuranceCategoryCode DisplayName=\"\"/>\n" +
                    "        <HealthInsuranceCardId/>\n" +
                    "        <Name/>\n" +
                    "        <Sex DisplayName=\"9\">9</Sex>\n" +
                    "        <BirthDate/>\n" +
                    "        <MaritalStatus DisplayName=\"\"/>\n" +
                    "        <Nationality DisplayName=\"\"/>\n" +
                    "        <EthnicGroup DisplayName=\"\"/>\n" +
                    "        <EducationCode DisplayName=\"\"/>\n" +
                    "        <OccupationCategoryCode DisplayName=\"\"/>\n" +
                    "        <PatientPhone/>\n" +
                    "        <WorkUnit/>\n" +
                    "        <WorkAddrPhone/>\n" +
                    "        <SystemTime/>\n" +
                    "        <Author/>\n" +
                    "        <AuthorCode DisplayName=\"99\">99</AuthorCode>\n" +
                    "        <PrivacySign>0</PrivacySign>\n" +
                    "        <ABOBloodCode DisplayName=\"\"/>\n" +
                    "        <RhBloodCode DisplayName=\"\"/>\n" +
                    "        <RegisterOrganizationCode DisplayName=\"\"/>\n" +
                    "        <Contact>\n" +
                    "            <RelationShipWithPatient DisplayName=\"\"/>\n" +
                    "            <ContactPerson/>\n" +
                    "            <ContactPersonTel/>\n" +
                    "            <ContactIdCard/>\n" +
                    "            <ContactIdCardCode DisplayName=\"\"/>\n" +
                    "        </Contact>\n" +
                    "        <Address>\n" +
                    "            <AddrTypeCode DisplayName=\"01\">01</AddrTypeCode>\n" +
                    "            <AddressDetail>-</AddressDetail>\n" +
                    "            <Province>-</Province>\n" +
                    "            <City>-</City>\n" +
                    "            <County>-</County>\n" +
                    "            <Town>-</Town>\n" +
                    "            <Village>-</Village>\n" +
                    "            <HouseNumber>-</HouseNumber>\n" +
                    "            <PostalCode/>\n" +
                    "        </Address>\n" +
                    "        <ContactWay>\n" +
                    "            <ContactTypeCode DisplayName=\"\"/>\n" +
                    "            <ContactNo/>\n" +
                    "        </ContactWay>\n" +
                    "        <Certificate>\n" +
                    "            <CertificateTypeCode DisplayName=\"\"/>\n" +
                    "            <CertificateNo/>\n" +
                    "        </Certificate>\n" +
                    "        <Card>\n" +
                    "            <CardTypeCode DisplayName=\"\"/>\n" +
                    "            <CardNo/>\n" +
                    "            <CardCode/>\n" +
                    "            <CreateTime/>\n" +
                    "            <CreateUnit/>\n" +
                    "            <CreateUser/>\n" +
                    "            <ValidTime/>\n" +
                    "        </Card>\n" +
                    "    </Patient>\n" +
                    "</BSXml>\n";

            Object evaluate = getValueFromXml(xml, "/BSXml/MsgHeader/Sender/text()");
            System.out.println(evaluate);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
