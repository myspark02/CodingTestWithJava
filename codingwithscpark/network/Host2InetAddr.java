package codingwithscpark.network;

import java.net.*;

public class Host2InetAddr {
    public static void main(String[] args) {
        String hostName = "www.naver.com";

        try {
            InetAddress address = InetAddress.getByName(hostName);
            System.out.println("IP 주소: " + address.getHostAddress());

            System.out.println("내 컴퓨터 IP 주소: " + InetAddress.getLocalHost().getHostAddress());
        }catch(UnknownHostException e) {
            System.err.println(e.getMessage());
        }
    }
}
