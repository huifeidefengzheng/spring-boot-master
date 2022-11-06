package com.dexing.od;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 已知火星人使用的运算符号为#;KaTeX parse error: Expected 'EOF', got '#' at position 17: …其与地球人的等价公式如下: x#̲y=2*x+3*y+4 xy=3x+y+2
 * 1、其中x、y是无符号整数
 * 2、地球人公式按C语言规则计算
 * 3、火星人公式中，KaTeX parse error: Expected 'EOF', got '#' at position 7: 的优先级高于#̲，相同的运算符，按从左到右的顺…）组成的计算表达式。例如：123#4$5#67$78。
 * 1、用例保证字符串中，操作数与操作符之间没有任何分隔符。
 * 2、用例保证操作数取值范围为32位无符号整数。
 * 3、保证输入以及计算结果不会出现整型溢出。
 * 4、保证输入的字符串为合法的求值报文，例如：123#4$5#67$78
 * 5、保证不会出现非法的求值报文，例如类似这样字符串：
 * #4$5 //缺少操作数
 * 4$5# //缺少操作数
 * 4#$5 //缺少操作数
 * 4 $5 //有空格
 * 3+4-56/7 //有其它操作符
 * 12345678987654321$54321 //32位整数计算溢出
 * 输出描述:
 * 根据输入的火星人字符串输出计算结果（结尾不带回车换行）
 * 示例1
 * 输入
 * 7#6$5#12
 * 输出
 * 226
 * 说明
 * 示例：
 * 7#6$5#12
 * =7#(18+5+2)#12
 * =7#25#12
 * =(14+75+4)#12
 * =93#12
 * =293+312+4
 * =226
 *
 */
public class D1547MarsLanguage {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String st = "7#6$5#12";
        ArrayDeque<Integer> integers = new ArrayDeque<>();
        String[] split = st.split("#");
        for (int i = 0; i < split.length; i++) {
            String at = split[i];
            if ((at).contains("$")) {
                int doule = getDoule(at);
                integers.push(doule);
            } else if (at.contains("#")) {
                continue;
            } else {
                integers.push(Integer.parseInt(at));
            }
        }
        int res = integers.pollLast();
        while (!integers.isEmpty()) {
            Integer y = integers.pollLast();
            res = getJing(res,y);
        }
        System.out.println(res);
    }

    private static int getJing(int res, Integer y) {
        return 2 * res + 3*y +4;

    }

    private static int getDoule(String st) {
        String[] split = st.split("\\$");
        int one = Integer.parseInt(split[0]);
        for (int i = 1; i < split.length; i++) {
            one = getDoule(one,Integer.parseInt(split[i]));
        }
        return one;

    }

    private static int getDoule(int one, int parseInt) {
        return 3 * one + parseInt + 2;
    }
}
