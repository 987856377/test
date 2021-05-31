package tool.xml.wapper;

import java.io.Serializable;

/**
 * @program: test
 * @package xml.wapper
 * @description
 * @author: XuZhenkui
 * @create: 2020-12-16 10:49
 **/
public class XmlResponse<T> implements Serializable {
    private XmlResponseHeader msgHeader;
    private T data;

    public XmlResponse() {
    }

    public XmlResponse(XmlResponseHeader msgHeader, T data) {
        this.msgHeader = msgHeader;
        this.data = data;
    }

    public XmlResponseHeader getMsgHeader() {
        return msgHeader;
    }

    public void setMsgHeader(XmlResponseHeader msgHeader) {
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
