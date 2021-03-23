package excel;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import util.JsonAndXmlUtils;

import java.util.List;

public class ExcelDictImport {
    public static void main(String[] args) {
        // 1.	婚姻字典
        ExcelReader reader1 = ExcelUtil.getReader("D:\\test.xlsx", 0);
        reader1.setIgnoreEmptyRow(true);
        List<BaseDictionary> marriedBaseDictionary = reader1.readAll(BaseDictionary.class);
        reader1.close();
        System.out.println(JsonAndXmlUtils.objectToJson(marriedBaseDictionary));

        // 2.	病人性质字典
        ExcelReader reader2 = ExcelUtil.getReader("D:\\test.xlsx", 1);
        reader2.setIgnoreEmptyRow(true);
        List<BaseDictionary> patientNatureBaseDictionary = reader2.readAll(BaseDictionary.class);
        reader2.close();
        System.out.println(JsonAndXmlUtils.objectToJson(patientNatureBaseDictionary));

        // 3.	入院方式字典
        ExcelReader reader3 = ExcelUtil.getReader("D:\\test.xlsx", 2);
        reader3.setIgnoreEmptyRow(true);
        List<BaseDictionary> inHospitalTypeBaseDictionary = reader3.readAll(BaseDictionary.class);
        reader3.close();
        System.out.println(JsonAndXmlUtils.objectToJson(inHospitalTypeBaseDictionary));

        // 4.	联系人关系
        ExcelReader reader4 = ExcelUtil.getReader("D:\\test.xlsx", 3);
        reader4.setIgnoreEmptyRow(true);
        List<BaseDictionary> relationBaseDictionary = reader4.readAll(BaseDictionary.class);
        reader4.close();
        System.out.println(JsonAndXmlUtils.objectToJson(relationBaseDictionary));

        // 5.	医疗付款方式
        ExcelReader reader5 = ExcelUtil.getReader("D:\\test.xlsx", 4);
        reader5.setIgnoreEmptyRow(true);
        List<BaseDictionary> payTypeBaseDictionary = reader5.readAll(BaseDictionary.class);
        reader5.close();
        System.out.println(JsonAndXmlUtils.objectToJson(payTypeBaseDictionary));

        // 6.	职业代码
        ExcelReader reader6 = ExcelUtil.getReader("D:\\test.xlsx", 5);
        reader6.setIgnoreEmptyRow(true);
        List<BaseDictionary> jobBaseDictionary = reader6.readAll(BaseDictionary.class);
        reader6.close();
        System.out.println(JsonAndXmlUtils.objectToJson(jobBaseDictionary));

        // 7.	民族代码
        ExcelReader reader7 = ExcelUtil.getReader("D:\\test.xlsx", 6);
        reader7.setIgnoreEmptyRow(true);
        List<BaseDictionary> nationalBaseDictionary = reader7.readAll(BaseDictionary.class);
        reader7.close();
        System.out.println(JsonAndXmlUtils.objectToJson(nationalBaseDictionary));
    }
}
