package codingtest.test;

public class AutoClosableExample implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("AutoClosableExample closed...");

    }
    
}
