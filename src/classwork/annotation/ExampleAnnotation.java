package classwork.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ExampleAnnotation {

    String arg() default "Anun";
    int count() default 9;
}
