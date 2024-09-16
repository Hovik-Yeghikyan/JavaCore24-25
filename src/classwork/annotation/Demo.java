package classwork.annotation;

import java.lang.reflect.Method;

public class Demo {

    public static void main(String[] args) {

        AnnotationExampleDemo annotationExampleDemo = new AnnotationExampleDemo();
        try {
            Method m = annotationExampleDemo.getClass().getMethod("meth");
            ExampleAnnotation declaredAnnotation = m.getDeclaredAnnotation(ExampleAnnotation.class);
            if (declaredAnnotation != null) {
                System.out.println(declaredAnnotation.arg());
                System.out.println(declaredAnnotation.count());
            }
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        }


    }
}
