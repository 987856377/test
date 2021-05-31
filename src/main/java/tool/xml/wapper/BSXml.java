package tool.xml.wapper;

import java.io.Serializable;

public class BSXml implements Serializable {
    private String sender;
    private String msgType;
    private String msgVersion;
    private String body;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgVersion() {
        return msgVersion;
    }

    public void setMsgVersion(String msgVersion) {
        this.msgVersion = msgVersion;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "BSXml{" +
                "sender='" + sender + '\'' +
                ", msgType='" + msgType + '\'' +
                ", msgVersion='" + msgVersion + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
