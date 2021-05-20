package javassist;

import javassist.bytecode.ConstPool;
import javassist.bytecode.FieldInfo;

import java.lang.reflect.Method;

public class CreatePerson {


    /**
     * 创建一个Person 对象
     *
     * @throws Exception
     */
    public void createPseson() throws Exception {
        ClassPool pool = ClassPool.getDefault();

        // 1. 创建一个空类
        CtClass cc = pool.makeClass("javassist.Person");

        // 2. 新增一个字段 private String name;
        // 字段名为name
        CtField name = new CtField(pool.get("java.lang.String"), "name", cc);
        // 访问级别是 private
        name.setModifiers(Modifier.PRIVATE);
        // 初始值是 "xiaoming"
        cc.addField(name, CtField.Initializer.constant("xiaoming"));
        // 3. 生成 getter、setter 方法
        cc.addMethod(CtNewMethod.setter("setName", name));
        cc.addMethod(CtNewMethod.getter("getName", name));

        // 字段名为age
        CtField age = new CtField(pool.get("java.lang.String"), "age", cc);
        // 访问级别是 private
        age.setModifiers(Modifier.PRIVATE);
        // 初始值是 "0"
        cc.addField(age, CtField.Initializer.constant("0"));
        // 3. 生成 getter、setter 方法
        cc.addMethod(CtNewMethod.setter("setAge", age));
        cc.addMethod(CtNewMethod.getter("getAge", age));


        // 4. 添加无参的构造函数
        CtConstructor cons = new CtConstructor(new CtClass[]{}, cc);
        cons.setBody("{name = \"xiaohong\"; age = \"23\";}");
        cc.addConstructor(cons);

        // 5. 添加有参的构造函数
        cons = new CtConstructor(new CtClass[]{pool.get("java.lang.String"), pool.get("java.lang.String")}, cc);
        // $0=this / $1,$2,$3... 代表方法参数
        cons.setBody("{$0.name = $1; $0.age = $2;}");
        cc.addConstructor(cons);

        // 6. 创建一个名为printName方法，无参数，无返回值，输出name值
        CtMethod ctMethod = new CtMethod(CtClass.voidType, "printName", new CtClass[]{}, cc);
        ctMethod.setModifiers(Modifier.PUBLIC);
        ctMethod.setBody("{System.out.println(name);}");
        cc.addMethod(ctMethod);


        // 7. 创建的类对象编译为.class文件
        cc.writeFile("target/classes");

        Object person = cc.toClass().newInstance();
        Method setName = person.getClass().getMethod("setName", String.class);
        setName.invoke(person, "frank");

        Method getName = person.getClass().getMethod("getName");
        Object invoke = getName.invoke(person);
        System.out.println(invoke);

        Method printName = person.getClass().getMethod("printName");
        printName.invoke(person);

    }

    public static void main(String[] args) {
        try {
            new CreatePerson().createPseson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
