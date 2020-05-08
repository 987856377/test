package Enum;

public enum  ColorEnum {
    RED(1), GREEN(2), BLUE(3);
    private Integer value;
    ColorEnum(Integer value){
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}

