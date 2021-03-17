package test;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @program: test
 * @package test
 * @description
 * @author: XuZhenkui
 * @create: 2021-03-15 14:36
 **/
public class Entity {

    /**
     * code : 200
     * data : [{"inspectionTypeName":"东院全部化验","inspectionTypeList":[{"isCompose":"1","number":"1","isEmergency":0,"inspectionItemName":"内毒素鲎定量测定.","inspectionItemId":"1465","price":"150","specimenTypeId":"Q","specimenTypeName":"血清","pyCode":"NDSFDLCDZH"}],"inspectionTypeId":"206"}]
     * message : 处理成功
     */

    @JsonProperty("code")
    private Integer code;
    @JsonProperty("data")
    private List<Data> data;
    @JsonProperty("message")
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Data {
        /**
         * inspectionTypeName : 东院全部化验
         * inspectionTypeList : [{"isCompose":"1","number":"1","isEmergency":0,"inspectionItemName":"内毒素鲎定量测定.","inspectionItemId":"1465","price":"150","specimenTypeId":"Q","specimenTypeName":"血清","pyCode":"NDSFDLCDZH"}]
         * inspectionTypeId : 206
         */

        @JsonProperty("inspectionTypeName")
        private String inspectionTypeName;
        @JsonProperty("inspectionTypeList")
        private List<InspectionTypeList> inspectionTypeList;
        @JsonProperty("inspectionTypeId")
        private String inspectionTypeId;

        public String getInspectionTypeName() {
            return inspectionTypeName;
        }

        public void setInspectionTypeName(String inspectionTypeName) {
            this.inspectionTypeName = inspectionTypeName;
        }

        public List<InspectionTypeList> getInspectionTypeList() {
            return inspectionTypeList;
        }

        public void setInspectionTypeList(List<InspectionTypeList> inspectionTypeList) {
            this.inspectionTypeList = inspectionTypeList;
        }

        public String getInspectionTypeId() {
            return inspectionTypeId;
        }

        public void setInspectionTypeId(String inspectionTypeId) {
            this.inspectionTypeId = inspectionTypeId;
        }

        public static class InspectionTypeList {
            /**
             * isCompose : 1
             * number : 1
             * isEmergency : 0
             * inspectionItemName : 内毒素鲎定量测定.
             * inspectionItemId : 1465
             * price : 150
             * specimenTypeId : Q
             * specimenTypeName : 血清
             * pyCode : NDSFDLCDZH
             */

            @JsonProperty("isCompose")
            private String isCompose;
            @JsonProperty("number")
            private String number;
            @JsonProperty("isEmergency")
            private Integer isEmergency;
            @JsonProperty("inspectionItemName")
            private String inspectionItemName;
            @JsonProperty("inspectionItemId")
            private String inspectionItemId;
            @JsonProperty("price")
            private String price;
            @JsonProperty("specimenTypeId")
            private String specimenTypeId;
            @JsonProperty("specimenTypeName")
            private String specimenTypeName;
            @JsonProperty("pyCode")
            private String pyCode;

            public String getIsCompose() {
                return isCompose;
            }

            public void setIsCompose(String isCompose) {
                this.isCompose = isCompose;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public Integer getIsEmergency() {
                return isEmergency;
            }

            public void setIsEmergency(Integer isEmergency) {
                this.isEmergency = isEmergency;
            }

            public String getInspectionItemName() {
                return inspectionItemName;
            }

            public void setInspectionItemName(String inspectionItemName) {
                this.inspectionItemName = inspectionItemName;
            }

            public String getInspectionItemId() {
                return inspectionItemId;
            }

            public void setInspectionItemId(String inspectionItemId) {
                this.inspectionItemId = inspectionItemId;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getSpecimenTypeId() {
                return specimenTypeId;
            }

            public void setSpecimenTypeId(String specimenTypeId) {
                this.specimenTypeId = specimenTypeId;
            }

            public String getSpecimenTypeName() {
                return specimenTypeName;
            }

            public void setSpecimenTypeName(String specimenTypeName) {
                this.specimenTypeName = specimenTypeName;
            }

            public String getPyCode() {
                return pyCode;
            }

            public void setPyCode(String pyCode) {
                this.pyCode = pyCode;
            }
        }
    }
}
