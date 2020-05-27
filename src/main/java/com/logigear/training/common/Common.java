package com.logigear.training.common;

public class Common {
    public static String getEmail(String nameAddress, String domain) {
        int randomNo = (int) (Math.random() * 100000);
        return nameAddress + randomNo + "@" + domain;
    }
}
