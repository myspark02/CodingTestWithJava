package codingtest.test.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
// @Retention(RetentionPolicy.CLASS)
// @Retention(RetentionPolicy.SOURCE)
// @Inherited
// @Documented
// @Target(ElementType.PARAMETER)
public @interface CustomAnnotation {
    String name() default "scpark";
    int count() default 100;
    String[] tags() default {"Java", "Annotation"};
}
