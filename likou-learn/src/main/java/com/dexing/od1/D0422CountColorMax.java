package com.dexing.od1;

import java.util.HashMap;
import java.util.Map;

public class D0422CountColorMax {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String[] s = "0 1 2 1".split(" ");
        int w = 2;
        int[] ints = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            ints[i] = Integer.parseInt(s[i]);
        }
        int start = 0, end = ints.length - 1,res =0;
        while (start <= end) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = start - w + 1; i <= start && start + 1 >= w; i++) {
                int anInt = ints[i];
                Integer orDefault = map.getOrDefault(anInt, 0);
                map.put(anInt,orDefault+1);
            }
            if (map.size()>0) {
                res = Math.max(checkMax(map),res);
            }
            start++;
        }
        System.out.println(res);
    }

    private static int checkMax(HashMap<Integer, Integer> map) {
        int max = 0;
        for (Map.Entry<Integer,Integer> ma : map.entrySet()) {
            max = Math.max(ma.getValue(),max);
        }
        return max;
    }
}
