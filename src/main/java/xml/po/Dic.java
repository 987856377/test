package xml.po;

import java.io.Serializable;
import java.util.List;

/**
 * @program: test
 * @package xml.po
 * @description
 * @author: XuZhenkui
 * @create: 2021-02-26 17:37
 **/
public class Dic implements Serializable {
    private String dicDomain;
    private String dicId;
    private String dicAlias;
    private String dicVersion;
    private String modifiedTime;

    private List<Item> items;

    public String getDicDomain() {
        return dicDomain;
    }

    public void setDicDomain(String dicDomain) {
        this.dicDomain = dicDomain;
    }

    public String getDicId() {
        return dicId;
    }

    public void setDicId(String dicId) {
        this.dicId = dicId;
    }

    public String getDicAlias() {
        return dicAlias;
    }

    public void setDicAlias(String dicAlias) {
        this.dicAlias = dicAlias;
    }

    public String getDicVersion() {
        return dicVersion;
    }

    public void setDicVersion(String dicVersion) {
        this.dicVersion = dicVersion;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


    @Override
    public String toString() {
        return "Dic{" +
                "dicDomain='" + dicDomain + '\'' +
                ", dicId='" + dicId + '\'' +
                ", dicAlias='" + dicAlias + '\'' +
                ", dicVersion='" + dicVersion + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                ", items=" + items +
                '}';
    }
}
