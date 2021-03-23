package excel;


import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import util.JsonAndXmlUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description
 * @Project test
 * @Package excel
 * @Author xuzhenkui
 * @Date 2020/6/9 11:58
 */
public class ExcelImport {
    public static void main(String[] args) {
//        ExcelReader reader = ExcelUtil.getReader("F:\\护士档案导入信息表5.15.xlsx",0);
//        reader.setIgnoreEmptyRow(true);
//        reader.setHeaderAlias(getAliasMap());
//        List<Nurse> nurses = reader.readAll(Nurse.class);
//        reader.close();
//        nurses.forEach(System.out::println);

        ExcelReader reader = ExcelUtil.getReader("D:\\省市县代码(1)(1).xlsx", 0);
        reader.setIgnoreEmptyRow(true);
//        reader.setHeaderAlias(getAliasMap());
        List<NationAreaDictionary> nationAreaDictionaryList = reader.readAll(NationAreaDictionary.class);
        reader.close();
//        inHospitalDictionaryList.forEach(System.out::println);


        long l = System.currentTimeMillis();


        List<NationAreaDictionary> provinceList = nationAreaDictionaryList.stream().filter(item -> "1".equals(item.getType())).collect(Collectors.toList());
        List<NationAreaDictionary> cityList = nationAreaDictionaryList.stream().filter(item -> "2".equals(item.getType())).collect(Collectors.toList());
        List<NationAreaDictionary> countyList = nationAreaDictionaryList.stream().filter(item -> "3".equals(item.getType())).collect(Collectors.toList());

        cityList.forEach(item -> {
            item.setDictionaryList(countyList.stream().filter(county -> item.getKey().equals(county.getSupervising())).collect(Collectors.toList()));
        });

        provinceList.forEach(item -> {
            item.setDictionaryList(cityList.stream().filter(city -> item.getKey().equals(city.getSupervising())).collect(Collectors.toList()));
        });
        provinceList.forEach(item -> {
            if (item.getDictionaryList().size() == 0) {
                item.setDictionaryList(countyList.stream().filter(city -> city.getSupervising().startsWith(item.getKey())).collect(Collectors.toList()));
            }
        });


        // --------------------------------------------------------------------------------------------------

//        inHospitalDictionaryList.stream().filter(province -> "1".equals(province.getType()))
//                .forEach(province -> {
//                    province.setDictionaryList(inHospitalDictionaryList.stream().filter(item -> "2".equals(item.getType()) && province.getKey().equals(item.getSupervising())).collect(Collectors.toList()));
//                    province.getDictionaryList().forEach(city -> {
//                        city.setDictionaryList(inHospitalDictionaryList.stream().filter(item -> city.getKey().equals(item.getSupervising()) && "3".equals(item.getType())).collect(Collectors.toList()));
//                    });
//        });

        long l2 = System.currentTimeMillis();
        System.out.println("cost: " + (l2 - l));

        System.out.println(JsonAndXmlUtils.objectToJson(provinceList));
//        System.out.println(JsonAndXmlUtils.objectToJson(inHospitalDictionaryList));

    }


    public static Map<String, String> getAliasMap() {
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
