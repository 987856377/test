package tool.excel;

import java.util.List;

public class NationAreaDictionary extends BaseDictionary {

    private String type;
    private String supervising;

    List<NationAreaDictionary> dictionaryList;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSupervising() {
        return supervising;
    }

    public void setSupervising(String supervising) {
        this.supervising = supervising;
    }

    public List<NationAreaDictionary> getDictionaryList() {
        return dictionaryList;
    }

    public void setDictionaryList(List<NationAreaDictionary> dictionaryList) {
        this.dictionaryList = dictionaryList;
    }

    @Override
    public String toString() {
        return "InHospitalDictionary{" +
                ", type='" + type + '\'' +
                ", supervising='" + supervising + '\'' +
                ", dictionaryList=" + dictionaryList +
                '}';
    }
}
