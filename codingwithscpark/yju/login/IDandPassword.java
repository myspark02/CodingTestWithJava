package codingwithscpark.yju.login;

import java.util.HashMap;

public class IDandPassword {
    HashMap<String, String> loginInfo = new HashMap<>();

    IDandPassword() {
        loginInfo.put("scpark", "1111");
        loginInfo.put("gdhong", "2222");
        loginInfo.put("chsung", "3333");

    }

    protected HashMap<String, String> getLoginInfo() {
        return loginInfo;
    }
}
