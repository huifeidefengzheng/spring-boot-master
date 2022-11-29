package com.dexing.od;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * 现在有多组整数数组，需要将它们合并成一个新的数组。合并规则，从每个数组里按顺序取出固定长度的内容合并到新的数组中，取完的内容会删除掉，如果该行不足固定长度或者已经为空，则直接取出剩余部分的内容放到新的数组中，继续下一行。
 * 输入描述:
 * 第一行是每次读取的固定长度，0<长度<10
 * 第二行是整数数组的数目，0<数目<1000
 * 第3-n行是需要合并的数组，不同的数组用回车换行分隔，数组内部用逗号分隔，最大不超过100个元素。
 * 输出描述:
 * 输出一个新的数组，用逗号分隔。
 * 示例1
 * 输入
 * 3
 * 2
 * 2,5,6,7,9,5,7
 * 1,7,4,3,4
 * 输出
 * 2,5,6,1,7,4,7,9,5,3,4,7
 * 说明
 * 1、获得长度3和数组数目2。
 * 2、先遍历第一行，获得2,5,6；
 * 3、再遍历第二行，获得1,7,4；
 * 4、再循环回到第一行，获得7,9,5；
 * 5、再遍历第二行，获得3,4；
 * 6、再回到第一行，获得7，按顺序拼接成最终结果。
 * 示例2
 * 输入
 * 4
 * 3
 * 1,2,3,4,5,6
 * 1,2,3
 * 1,2,3,4
 * 输出
 * 1,2,3,4,1,2,3,1,2,3,4,5,6
 *
 */
public class D2271ArrConcat {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int con = 3 ,lines = 2;
        String line1 = "2,5,6,7,9,5,7".replace(",","");
        String line2 = "1,7,4,3,4".replace(",","");
        ArrayList<String> list = new ArrayList<>();

        list.add(line1);
        list.add(line2);
        StringBuffer stringBuffer = new StringBuffer();
        while (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                if (s.length() >= con) {
                    String s1 = s.substring(0, con);
                    s  = s.substring(con);
                    stringBuffer.append(s1);
                } else if (s.length() < con && !s.equals("")) {
                    stringBuffer.append(s);
                    s = "";
                }
                if (s.equals("")) {
                    list.remove(i);
                } else {
                    list.set(i,s);
                }
            }
        }
        char[] chars = stringBuffer.toString().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length-1) {
                System.out.print(chars[i]);
            } else {
                System.out.print(chars[i] +",");
            }
        }

    }
}
