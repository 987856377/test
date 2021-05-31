package tool.excel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Description
 * @Project test
 * @Package tools.excel
 * @Author xuzhenkui
 * @Date 2020/6/11 14:25
 */
public class Nurse implements Serializable {
    String order;

    String department;

    String name;

    String jobNo;

    String code;

    String sex;

    String type;

    String period;

    String begin;

    String address;

    String tel;

    String level;

    String stage;

    String face;

    String work;

    String calling;

    String careLevel;

    String stateType;

    BigDecimal price;

    LocalDateTime birthday;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getCalling() {
        return calling;
    }

    public void setCalling(String calling) {
        this.calling = calling;
    }

    public String getCareLevel() {
        return careLevel;
    }

    public void setCareLevel(String careLevel) {
        this.careLevel = careLevel;
    }

    public String getStateType() {
        return stateType;
    }

    public void setStateType(String stateType) {
        this.stateType = stateType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "order='" + order + '\'' +
                ", department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", jobNo='" + jobNo + '\'' +
                ", code='" + code + '\'' +
                ", sex='" + sex + '\'' +
                ", type='" + type + '\'' +
                ", period='" + period + '\'' +
                ", begin='" + begin + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", level='" + level + '\'' +
                ", stage='" + stage + '\'' +
                ", face='" + face + '\'' +
                ", work='" + work + '\'' +
                ", calling='" + calling + '\'' +
                ", careLevel='" + careLevel + '\'' +
                ", stateType='" + stateType + '\'' +
                ", price=" + price +
                ", birthday=" + birthday +
                '}';
    }
}
