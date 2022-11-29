package com.dexing.od1;

import java.util.ArrayList;
import java.util.Arrays;

public class D0418Strout {
    public static void main(String[] args) {
        test();
    }

    public static void test()  {
        int n = 3;
        String input = "abcdefed";
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            int i1 = i % n;
            char c = input.charAt(i);
            if (list.size()  >= n) {
                String s = list.get(i1);
                s = s + c;
                list.set(i1,s);
            } else {
                list.add(String.valueOf(c));
            }
        }

        list.stream().forEach(vo -> System.out.println(vo));

    }
}
