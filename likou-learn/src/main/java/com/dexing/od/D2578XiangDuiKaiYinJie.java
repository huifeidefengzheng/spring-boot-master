package com.dexing.od;

import java.util.ArrayList;

/**
 * 相对开音节构成的结构为辅音+元音（aeiou）+辅音(r除外)+e，常见的单词有bike、cake等。
 * 给定一个字符串，以空格为分隔符，反转每个单词中的字母，若单词中包含如数字等其他非字母时不进行反转。
 * 反转后计算其中含有相对开音节结构的子串个数（连续的子串中部分字符可以重复）。
 * 输入描述:
 * 字符串，以空格分割的多个单词，字符串长度<10000，字母只考虑小写
 * 输出描述:
 * 含有相对开音节结构的子串个数，注：个数<10000
 * 示例1
 * 输入
 * ekam a ekac
 * 输出
 * 2
 * 说明
 * 反转后为 make a cake 其中make、cake为相对开音节子串，返回2
 * 示例2
 * 输入
 * !ekam a ekekac
 * 输出
 * 2
 * 说明
 * 反转后为!ekam a cakeke 因!ekam含非英文字符所以未反转，其中 cake、keke为相对开音节子串，返回2
 *
 */
public class D2578XiangDuiKaiYinJie {
    public static void main(String[] args) {
        System.out.println("cakeke".substring(0,4));
        test();
    }



    public static void test() {
        String input = "ekam a ekac";
        String[] split = input.split("\\s+");
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String revStr = revString(split[i]);
            list.add(revStr);
        }
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.length() < 4) {
                continue;
            }
            int indx = 0;
            while (indx < s.length()){
                if (indx +4<= s.length()) {
                    String substring = s.substring(indx, indx + 4);
                    if (isKai(substring)){
                        res++;
                    }
                }
                indx++;
            }
        }
        System.out.println(res);

    }

    private static boolean isKai(String substring) {
        String yuan = "aeiou";
        boolean b1 = !yuan.contains(substring.charAt(0)+"");
        boolean b2 = yuan.contains(substring.charAt(1)+"");
        boolean b3 = !(yuan+"r").contains(substring.charAt(2)+"");
        boolean b4 = "e".equals(substring.charAt(3)+"");
        return b1 && b2 && b3 && b4;

    }

    private static String revString(String s) {
        StringBuffer buffer = new StringBuffer();
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i)>'z' || s.charAt(i) < 'a'){
                return s;
            }
            buffer.append(s.charAt(i));
        }
        return buffer.toString();
    }
}
