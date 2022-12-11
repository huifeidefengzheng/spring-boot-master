package com.dexing.od1;

import java.util.*;

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
        test2();
    }

    public static void test2() {
        //处理输入
        Scanner in=new Scanner(System.in);
        StringBuilder res_str = new StringBuilder();

        // 自定义排序方法
        Arrays.stream(in.nextLine().split(","))
                .sorted((s1, s2) -> {
                    char[] s1_array = s1.toCharArray();
                    char[] s2_array = s2.toCharArray();
                    int len1 = s1_array.length;
                    int len2 = s2_array.length;
                    // 长度若相等，比大小
                    if (len1 == len2) {
                        return s2.compareTo(s1);
                    }

                    //长度不相等，逐个字符比较
                    int min = Math.min(len1, len2);
                    for (int i = 0; i < min; i++) {
                        char c1 = s1_array[i];
                        char c2 = s2_array[i];
                        if (c1 != c2) {
                            return c2 - c1;
                        }
                    }

                    if (len1 > len2) {
                        return s1_array[0] - s1_array[min];
                    } else {
                        return s2_array[min] - s2_array[0];
                    }
                }).forEach(res_str::append);

        System.out.println(res_str);
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
