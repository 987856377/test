package tool.xml.po;

import java.io.Serializable;

/**
 * @program: test
 * @package PACKAGE_NAME
 * @description
 * @author: XuZhenkui
 * @create: 2021-02-26 17:35
 **/
public class BsXml implements Serializable {
    private MsgHeader msgHeader;
    private Dic dic;

    public MsgHeader getMsgHeader() {
        return msgHeader;
    }

    public void setMsgHeader(MsgHeader msgHeader) {
        this.msgHeader = msgHeader;
    }

    public Dic getDic() {
        return dic;
    }

    public void setDic(Dic dic) {
        this.dic = dic;
    }


    @Override
    public String toString() {
        return "BsXml{" +
                "msgHeader=" + msgHeader +
                ", dic=" + dic +
                '}';
    }
}
