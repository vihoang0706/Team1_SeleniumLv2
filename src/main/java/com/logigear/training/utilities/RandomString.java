package com.logigear.training.utilities;

public class RandomString {
    public static String randomData(String namePage) {
        int randomNo = (int) (Math.random() * 100000);
        return namePage + randomNo;
    }
}
