package xml.po;

import java.io.Serializable;

/**
 * @program: test
 * @package xml.po
 * @description
 * @author: XuZhenkui
 * @create: 2021-02-26 17:39
 **/
public class Item implements Serializable {
    private String id;
    private String key;
    private String text;
    private String ICD;
    private String appendEncode;
    private String statisticsCode;
    private String categoryCode;
    private String sexLimit;
    private String allowCure;
    private String allowStraightenUp;
    private String allowFailure;
    private String allowDeath;
    private String effectiveFlag;
    private String modifiedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getICD() {
        return ICD;
    }

    public void setICD(String ICD) {
        this.ICD = ICD;
    }

    public String getAppendEncode() {
        return appendEncode;
    }

    public void setAppendEncode(String appendEncode) {
        this.appendEncode = appendEncode;
    }

    public String getStatisticsCode() {
        return statisticsCode;
    }

    public void setStatisticsCode(String statisticsCode) {
        this.statisticsCode = statisticsCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getSexLimit() {
        return sexLimit;
    }

    public void setSexLimit(String sexLimit) {
        this.sexLimit = sexLimit;
    }

    public String getAllowCure() {
        return allowCure;
    }

    public void setAllowCure(String allowCure) {
        this.allowCure = allowCure;
    }

    public String getAllowStraightenUp() {
        return allowStraightenUp;
    }

    public void setAllowStraightenUp(String allowStraightenUp) {
        this.allowStraightenUp = allowStraightenUp;
    }

    public String getAllowFailure() {
        return allowFailure;
    }

    public void setAllowFailure(String allowFailure) {
        this.allowFailure = allowFailure;
    }

    public String getAllowDeath() {
        return allowDeath;
    }

    public void setAllowDeath(String allowDeath) {
        this.allowDeath = allowDeath;
    }

    public String getEffectiveFlag() {
        return effectiveFlag;
    }

    public void setEffectiveFlag(String effectiveFlag) {
        this.effectiveFlag = effectiveFlag;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", key='" + key + '\'' +
                ", text='" + text + '\'' +
                ", ICD='" + ICD + '\'' +
                ", appendEncode='" + appendEncode + '\'' +
                ", statisticsCode='" + statisticsCode + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", sexLimit='" + sexLimit + '\'' +
                ", allowCure='" + allowCure + '\'' +
                ", allowStraightenUp='" + allowStraightenUp + '\'' +
                ", allowFailure='" + allowFailure + '\'' +
                ", allowDeath='" + allowDeath + '\'' +
                ", effectiveFlag='" + effectiveFlag + '\'' +
                ", modifiedTime='" + modifiedTime + '\'' +
                '}';
    }
}
