package com.dexing.od1;

public class D0421NotIncloud101 {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int start = 10;
        int end = 20;
        int count = 0;
        for (int i = start; i <= end; i++) {
            String s = Integer.toBinaryString(i);
            if (!s.contains("101")){
                count++;
            }
        }
        System.out.println(count);
    }
}
