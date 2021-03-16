package codingwithscpark.enumtest;

public class EnumDemo {

    public static void main(String[] args) {
        Mobile m = Mobile.LG;
        System.out.println(m);
        System.out.println(m.getVendor());
        System.out.println(Mobile.APPLE);
        System.out.println(Mobile.SAMSUNG);
        System.out.println(Mobile.LG);

        switch (m) {
        case APPLE:
        case SAMSUNG:
        case LG:
        }
    }
}
 