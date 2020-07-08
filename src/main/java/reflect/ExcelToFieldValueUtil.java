package reflect;


import java.lang.reflect.Field;

public class ExcelToFieldValueUtil {

    public static void handleExcelTableCharacter(Object clazz) throws IllegalAccessException {
        Field[] fields = clazz.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getType() == String.class && field.get(clazz) != null && !field.getType().isPrimitive()){
                field.set(clazz, field.get(clazz).toString().replaceAll("\\s*|\t|\r|\n",""));
            } else if (field.getType().getClassLoader() != null){
                handleExcelTableCharacter(field.get(clazz));
            }
        }
    }
}
