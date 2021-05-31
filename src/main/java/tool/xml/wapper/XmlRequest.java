package tool.xml.wapper;

import java.io.Serializable;

/**
 * @program: test
 * @package xml.wapper
 * @description
 * @author: XuZhenkui
 * @create: 2020-12-16 10:49
 **/
public class XmlRequest<T> implements Serializable {
    private XmlRequestHeader msgHeader;
    private T data;

    public XmlRequest() {
    }

    public XmlRequest(XmlRequestHeader msgHeader, T data) {
        this.msgHeader = msgHeader;
        this.data = data;
    }

    public XmlRequestHeader getMsgHeader() {
        return msgHeader;
    }

    public void setMsgHeader(XmlRequestHeader msgHeader) {
        this.msgHeader = msgHeader;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Request{" +
                "msgHeader=" + msgHeader +
                ", data=" + data +
                '}';
    }
}
