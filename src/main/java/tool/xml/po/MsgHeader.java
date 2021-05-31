package tool.xml.po;

import java.io.Serializable;

/**
 * @program: test
 * @package PACKAGE_NAME
 * @description
 * @author: XuZhenkui
 * @create: 2021-02-26 17:35
 **/
public class MsgHeader implements Serializable {
    private String sender;
    private String msgType;
    private String msgVersion;
    private String operationType;

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

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }


    @Override
    public String toString() {
        return "MsgHeader{" +
                "sender='" + sender + '\'' +
                ", msgType='" + msgType + '\'' +
                ", msgVersion='" + msgVersion + '\'' +
                ", operationType='" + operationType + '\'' +
                '}';
    }
}
