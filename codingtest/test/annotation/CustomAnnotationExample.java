package codingtest.test.annotation;

@CustomAnnotation(name = "John", count=123, tags={"Java", "Examples"})
public class CustomAnnotationExample {

    @CustomAnnotation
    String str = "";


    @CustomAnnotation(tags={"test", "method"})
    public void test(@CustomAnnotation String v) {
        System.out.println("test called");
    }
}
