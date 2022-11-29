package com.dexing.od1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 小组中每位都有一张卡片，卡片上是6位内的正整数，将卡片连起来可以组成多种数字，计算组成的最大数字。
 * 输入描述:
 * “,”号分割的多个正整数字符串，不需要考虑非数字异常情况，小组最多25个人
 * 输出描述:
 * 最大的数字字符串
 * 示例1
 * 输入
 * 22,221
 * 输出
 * 22221
 * 示例2
 * 输入
 * 4589,101,41425,9999，9
 * 输出
 * 9999458941425101
 */
public class D0104AssembleMax {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String[] split = "4589,101,41425,9999,9".split(",");
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            int anInt = Integer.parseInt(String.valueOf(s.charAt(0)));
            List<String> strings = map.getOrDefault(anInt, new ArrayList<String>());
            strings.add(s);
            map.put(anInt, strings);
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 9; i > 0; i--) {
            if (map.containsKey(i)) {
                String rt = checkSored(map.get(i));
                buffer.append(rt);
            }
        }
        System.out.println(buffer);
    }

    private static String checkSored(List<String> list) {
        StringBuffer buffer = new StringBuffer();
        while (list.size() > 0) {
            String tem = list.get(0);
            boolean flag = true;
            for (int i = 1; i < list.size(); i++) {
                if(compareMax(tem,list.get(i))) {
                    buffer.append(list.get(i));
                    list.remove(i);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                buffer.append(tem);
                list.remove(0);
            }
        }
        return buffer.toString();
    }

    private static boolean compareMax(String tem, String s) {
        int lentem = Math.min(s.length(),tem.length());
        for (int j = 0; j < lentem; j++) {
            int t1 = Integer.parseInt(String.valueOf(tem.charAt(j)));
            int t2 = Integer.parseInt(String.valueOf(s.charAt(j)));
            if (t1 != t2) {
                return t2-t1 >0;
            }
        }
        return s.length() == lentem;
    }
}
