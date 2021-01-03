//package xml;
//
//import cn.hutool.json.XML;
//import com.alibaba.fastjson.JSONObject;
//
//public class FastJsonTest {
//    public static void main(String[] args) {
//        String rt = "<?xml version=\"1.0\" ?><S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\"><S:Body><ns2:invokeResponse xmlns:ns2=\"http://ws.access.hai/\"><return>&lt;BSXml&gt;&lt;MsgHeader&gt;&lt;Sender&gt;MRC&lt;/Sender&gt;&lt;Status&gt;true&lt;/Status&gt;&lt;ErrCode&gt;&lt;/ErrCode&gt;&lt;Detail&gt;操作成功&lt;/Detail&gt;&lt;/MsgHeader&gt;&lt;Items&gt;&lt;Item&gt;&lt;Name&gt;雷延学&lt;/Name&gt;&lt;PatientType&gt;1&lt;/PatientType&gt;&lt;PatientNumber&gt;999627109&lt;/PatientNumber&gt;&lt;RequestId&gt;3102134&lt;/RequestId&gt;&lt;ItemCode&gt;135256&lt;/ItemCode&gt;&lt;ItemName&gt;鼻骨CT&lt;/ItemName&gt;&lt;IsAppointment&gt;0&lt;/IsAppointment&gt;&lt;AppointStatus&gt;4&lt;/AppointStatus&gt;&lt;AppointsId&gt;&lt;/AppointsId&gt;&lt;AppointsDateTime&gt;&lt;/AppointsDateTime&gt;&lt;AppointsQueue&gt;&lt;/AppointsQueue&gt;&lt;AppointsQueueName&gt;&lt;/AppointsQueueName&gt;&lt;TimePeriod&gt;&lt;/TimePeriod&gt;&lt;AppointsOrganization&gt;&lt;/AppointsOrganization&gt;&lt;AppointsDept&gt;313&lt;/AppointsDept&gt;&lt;AppointsDeptName&gt;CT科&lt;/AppointsDeptName&gt;&lt;AppointAddress&gt;&lt;/AppointAddress&gt;&lt;AppointAttention&gt;&lt;/AppointAttention&gt;&lt;EmptyStomach&gt;&lt;/EmptyStomach&gt;&lt;HoldUrine&gt;&lt;/HoldUrine&gt;&lt;IsEmergency&gt;&lt;/IsEmergency&gt;&lt;FeeStatus&gt;1&lt;/FeeStatus&gt;&lt;ExamCode&gt;&lt;/ExamCode&gt;&lt;PrintCount&gt;0&lt;/PrintCount&gt;&lt;ReportAddress&gt;&lt;/ReportAddress&gt;&lt;FeeTimeLimit&gt;&lt;/FeeTimeLimit&gt;&lt;/Item&gt;&lt;Item&gt;&lt;Name&gt;雷延学&lt;/Name&gt;&lt;PatientType&gt;1&lt;/PatientType&gt;&lt;PatientNumber&gt;999627109&lt;/PatientNumber&gt;&lt;RequestId&gt;3102134&lt;/RequestId&gt;&lt;ItemCode&gt;164440&lt;/ItemCode&gt;&lt;ItemName&gt;鼻CT平扫&lt;/ItemName&gt;&lt;IsAppointment&gt;0&lt;/IsAppointment&gt;&lt;AppointStatus&gt;3&lt;/AppointStatus&gt;&lt;AppointsId&gt;&lt;/AppointsId&gt;&lt;AppointsDateTime&gt;&lt;/AppointsDateTime&gt;&lt;AppointsQueue&gt;&lt;/AppointsQueue&gt;&lt;AppointsQueueName&gt;&lt;/AppointsQueueName&gt;&lt;TimePeriod&gt;&lt;/TimePeriod&gt;&lt;AppointsOrganization&gt;&lt;/AppointsOrganization&gt;&lt;AppointsDept&gt;313&lt;/AppointsDept&gt;&lt;AppointsDeptName&gt;CT科&lt;/AppointsDeptName&gt;&lt;AppointAddress&gt;&lt;/AppointAddress&gt;&lt;AppointAttention&gt;&lt;/AppointAttention&gt;&lt;EmptyStomach&gt;&lt;/EmptyStomach&gt;&lt;HoldUrine&gt;&lt;/HoldUrine&gt;&lt;IsEmergency&gt;&lt;/IsEmergency&gt;&lt;FeeStatus&gt;1&lt;/FeeStatus&gt;&lt;ExamCode&gt;&lt;/ExamCode&gt;&lt;PrintCount&gt;0&lt;/PrintCount&gt;&lt;ReportAddress&gt;&lt;/ReportAddress&gt;&lt;FeeTimeLimit&gt;&lt;/FeeTimeLimit&gt;&lt;/Item&gt;&lt;/Items&gt;&lt;/BSXml&gt;\n" +
//                "</return></ns2:invokeResponse></S:Body></S:Envelope>";
//
//        JSONObject parseObject = JSONObject.parseObject(XML.toJSONObject(rt).toString());
//        Object xmlObject = parseObject.getJSONObject("S:Envelope").getJSONObject("S:Body").getJSONObject("ns2:invokeResponse").get("return");
//        JSONObject parseObject1 = JSONObject.parseObject(XML.toJSONObject(xmlObject.toString()).toString());
//
//        System.out.println(parseObject1.getJSONObject("BSXml").getJSONObject("MsgHeader"));
//        System.out.println(parseObject1.getJSONObject("BSXml").getJSONObject("Items"));
//
//    }
//}
