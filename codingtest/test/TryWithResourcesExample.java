package codingtest.test;

import java.util.Arrays;

public class TryWithResourcesExample {
    public static void main(String[] args) {
        try {
            workOnResource();
        } catch(Exception e) {
            Throwable[] suppressed = e.getSuppressed();
            System.out.println(Arrays.toString(suppressed));
            System.out.println(e.getMessage());
        }

    }

    private static void workOnResource() throws Exception {

                // try (AutoClosableExample resource = new AutoClosableExample();
        //         AutoClosableExample resource2 = new AutoClosableExample()){
        //     System.out.println("Processed...");
        // } catch(Exception e) {
        //     System.out.println(e.getMessage());
        // }


        try(
            // AutoClosableResource resource1 = new AutoClosableResource("One", false);
            AutoClosableResource resource1 = new AutoClosableResource("One", true);
            // AutoClosableResource resource2 = new AutoClosableResource("Two", false);
             AutoClosableResource resource2 = new AutoClosableResource("Two", true);
            ) {
                // resource1.doOp(false);
                resource1.doOp(true);
                resource2.doOp(false);
        } catch(Exception e) {
            // System.out.println(e.getMessage());
            Throwable[] suppressed = e.getSuppressed();
            System.out.println(Arrays.toString(suppressed));
        } finally {
            System.out.println("finally");
            throw new Exception("Exception from finally");
        }
    }
}
