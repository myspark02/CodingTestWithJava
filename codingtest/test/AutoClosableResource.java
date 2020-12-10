package codingtest.test;

public class AutoClosableResource implements AutoCloseable {
    private String name = null;
    private boolean throwExceptionOnClose = false;

    public AutoClosableResource(String name, boolean throwExceptionOnClose) {
        this.name = name;
        this.throwExceptionOnClose = throwExceptionOnClose;
    }

    public void doOp(boolean throwException) throws Exception {
        System.out.println("Resource " + this.name + " doing operation");
        if (throwException) {
            throw new Exception("Error when calling doOp() on resource " + this.name);
        }
    }
    @Override
    public void close() throws Exception {
        System.out.println("Resource " + this.name + " close() called");

        if (this.throwExceptionOnClose) {
            throw new Exception("Error when trying to close resource " + this.name);
        }

    }
    
}
