package annotation;

import java.lang.annotation.*;

/**
 * @Description
 * @Project test
 * @Package annotation
 * @Author xuzhenkui
 * @Date 2019/9/6 10:06
 */
@Documented
@Inherited
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Value {
    String value() default "";
}
