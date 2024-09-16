package classwork.annotation;

public class AnnotationExampleDemo {
    @ExampleAnnotation(arg = "Poxos", count = 12)
    @Deprecated
    public static void meth() {
        System.out.println("hello");
    }

}
