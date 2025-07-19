package com.svar_proekt.weldproject.client;

import java.io.FileReader;
import java.util.Comparator;

public abstract class Test {

    public static void main(String[] args) {
        System.out.println(show(101));


    }

    public static boolean show(int x) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
        stringBuilder.reverse();
        int sum = Integer.valueOf(stringBuilder.toString());
        if (x == sum) {
            return true;
        } else return false;
    }
}
