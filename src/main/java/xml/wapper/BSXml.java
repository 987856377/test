package xml.wapper;

import java.io.Serializable;

public class BSXml implements Serializable {
    private String Sender;
    private String MsgType;
    private String MsgVersion;
    private String Body;

    public String getSender() {
        return Sender;
    }

    public void setSender(String sender) {
        Sender = sender;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getMsgVersion() {
        return MsgVersion;
    }

    public void setMsgVersion(String msgVersion) {
        MsgVersion = msgVersion;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }


    @Override
    public String toString() {
        return "BSXml{" +
                "Sender='" + Sender + '\'' +
                ", MsgType='" + MsgType + '\'' +
                ", MsgVersion='" + MsgVersion + '\'' +
                ", Body='" + Body + '\'' +
                '}';
    }
}
