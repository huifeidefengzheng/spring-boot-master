package com.dexing.od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class D3094StrChangeMin {
    public static void main(String[] args) {
        test();
    }

    public static void test1() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        Arrays.sort(chars);//最优解
        String str = input;
        for (int i = 0; i < input.length(); i++) {
            if (chars[i] == input.charAt(i)) {
                continue;
            }else {
                char aChar = chars[i];
                int i1 = input.lastIndexOf(String.valueOf(aChar));
                //i1 和i对调顺序即可
                str = input.substring(0,i) + aChar + input.substring(i+1,i1) + input.charAt(i) + input.substring(i1+1);
                break;
            }
        }
        System.out.println(str);
    }

    public static void test() {
        String input = "bacdefa";
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < input.length()/2; i++) {
            for (int j = i+1; j < input.length(); j++) {
                String s = input.substring(0,i)+input.charAt(j) + input.substring(i+1, j) + input.charAt(i) + input.substring(j+1);
                list.add(s);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}
