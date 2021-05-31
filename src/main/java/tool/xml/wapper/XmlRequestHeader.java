package tool.xml.wapper;

import java.io.Serializable;

/**
 * @program: test
 * @package xml.wapper
 * @description
 * @author: XuZhenkui
 * @create: 2020-12-16 10:50
 **/
public class XmlRequestHeader implements Serializable {
    private String sender;
    private String msgType;
    private String msgVersion;

    public XmlRequestHeader() {
    }

    public XmlRequestHeader(String sender, String msgType, String msgVersion) {
        this.sender = sender;
        this.msgType = msgType;
        this.msgVersion = msgVersion;
    }

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

    @Override
    public String toString() {
        return "RequestHeader{" +
                "sender='" + sender + '\'' +
                ", msgType='" + msgType + '\'' +
                ", msgVersion='" + msgVersion + '\'' +
                '}';
    }
}
