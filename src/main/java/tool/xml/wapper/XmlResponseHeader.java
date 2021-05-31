package tool.xml.wapper;

import java.io.Serializable;

/**
 * @program: test
 * @package xml.wapper
 * @description
 * @author: XuZhenkui
 * @create: 2020-12-16 10:58
 **/
public class XmlResponseHeader implements Serializable {
    private String sender;
    private String status;
    private String errCode;
    private String detail;

    public XmlResponseHeader() {
    }

    public XmlResponseHeader(String sender, String status, String errCode, String detail) {
        this.sender = sender;
        this.status = status;
        this.errCode = errCode;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "ResponseHeader{" +
                "sender='" + sender + '\'' +
                ", status='" + status + '\'' +
                ", errCode='" + errCode + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
