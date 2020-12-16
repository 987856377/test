package xml.wapper;

import java.io.Serializable;

/**
 * @program: test
 * @package xml.wapper
 * @description
 * @author: XuZhenkui
 * @create: 2020-12-16 10:08
 **/
public class XmlResponseBuilder<T> implements Serializable {

    private String sender;
    private String status;
    private String errCode;
    private String detail;
    private T data;

    public XmlResponseBuilder setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public XmlResponseBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public XmlResponseBuilder setErrCode(String errCode) {
        this.errCode = errCode;
        return this;
    }

    public XmlResponseBuilder setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public XmlResponseBuilder setData(T data) {
        this.data = data;
        return this;
    }

    public String getSender() {
        return sender;
    }

    public String getStatus() {
        return status;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getDetail() {
        return detail;
    }

    public T getData() {
        return data;
    }

    public XmlResponse build(){
        return build(this);
    }

    public static XmlResponse build(XmlResponseBuilder wrapper){
        return new XmlResponse(new XmlResponseHeader(wrapper.getSender(), wrapper.getStatus(), wrapper.getErrCode(),wrapper.getDetail()), wrapper.getData());
    }
}
