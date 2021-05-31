package tool.xml.wapper;

import java.io.Serializable;

/**
 * @program: test
 * @package xml.wapper
 * @description
 * @author: XuZhenkui
 * @create: 2020-12-16 10:07
 **/
public class XmlRequestBuilder<T> implements Serializable {

    private String sender;
    private String msgType;
    private String msgVersion;
    private T data;

    public XmlRequestBuilder setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public XmlRequestBuilder setMsgType(String msgType) {
        this.msgType = msgType;
        return this;
    }

    public XmlRequestBuilder setMsgVersion(String msgVersion) {
        this.msgVersion = msgVersion;
        return this;
    }

    public XmlRequestBuilder setData(T data) {
        this.data = data;
        return this;
    }

    public String getSender() {
        return sender;
    }

    public String getMsgType() {
        return msgType;
    }

    public String getMsgVersion() {
        return msgVersion;
    }

    public T getData() {
        return data;
    }

    public XmlRequest build(){
        return build(this);
    }

    public static XmlRequest build(XmlRequestBuilder wrapper){
        return new XmlRequest(new XmlRequestHeader(wrapper.sender, wrapper.msgType, wrapper.msgVersion), wrapper.getData());
    }
}
