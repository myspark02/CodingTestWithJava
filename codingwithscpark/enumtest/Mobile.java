package codingwithscpark.enumtest;

public enum Mobile {
    APPLE("apple"), SAMSUNG("samsung"), LG("lg");

    private final String vendor;

    private Mobile(String vendor) {
        this.vendor = vendor;
    }

    public String getVendor() {
        return vendor;
    }
}
 