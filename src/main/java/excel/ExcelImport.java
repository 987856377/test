package excel;


import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Project test
 * @Package excel
 * @Author xuzhenkui
 * @Date 2020/6/9 11:58
 */
public class ExcelImport {
    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader("F:\\护士档案导入信息表5.15.xlsx",0);
        reader.setIgnoreEmptyRow(true);
        reader.setHeaderAlias(getAliasMap());
        List<Nurse> nurses = reader.readAll(Nurse.class);
        reader.close();
        nurses.forEach(System.out::println);
    }

    public static Map<String, String> getAliasMap(){
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("序号", "order");
        headerMap.put("病区", "department");
        headerMap.put("姓名", "name");
        headerMap.put("工号", "jobNo");
        headerMap.put("YGDM", "code");
        headerMap.put("性别", "sex");
        headerMap.put("护士类型", "type");
        headerMap.put("工作时间", "period");
        headerMap.put("到院时间", "begin");
        headerMap.put("具体住址", "address");
        headerMap.put("电话号码", "tel");
        headerMap.put("学历", "level");
        headerMap.put("学位", "stage");
        headerMap.put("政治面貌", "face");
        headerMap.put("行政职务", "work");
        headerMap.put("专业职称", "calling");
        headerMap.put("护理能级", "careLevel");
        headerMap.put("岗位类型", "stateType");
        headerMap.put("工资", "price");
        headerMap.put("生日", "birthday");
        return headerMap;
    }
}
