package guava.collection;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import java.util.List;

public class HashBasedTableTest {
    // 双键 map - 超级实用
    //双键的 map ，我突然感觉我发现了新大陆。比如我有一个业务场景是：根据职位和部门将公司人员区分开来。key 可以用职位 + 部门组成一个字符串，那我们有了双键 map 之后就没这种烦恼。
    public static void main(String[] args) {
        Table<String, String, List<Object>> tables = HashBasedTable.create();
        tables.put("财务部", "总监", Lists.newArrayList());
        tables.put("财务部", "职员",Lists.newArrayList());
        tables.put("法务部", "助理", Lists.newArrayList());
        System.out.println(tables);
    }
}
