package com.dexing.od;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 为了提升数据传输的效率，会对传输的报文进行压缩处理。输入一个压缩后的报文，请返回它解压后的原始报文。
 * 压缩规则：n[str]，表示方括号内部的 str 正好重复 n 次。注意 n 为正整数（0 < n <= 100），str只包含小写英文字母，不考虑异常情况。
 * " “输入描述:
 * 输入压缩后的报文：
 * 1）不考虑无效的输入，报文没有额外的空格，方括号总是符合格式要求的；
 * 2）原始报文不包含数字，所有的数字只表示重复的次数 n ，例如不会出现像 5b 或 3[8] 的输入；
 * 输出描述:
 * 解压后的原始报文
 * 注：
 * 1）原始报文长度不会超过1000，不考虑异常的情况
 * 示例1
 * 输入
 * 3[k]2[mn]
 * 输出
 * kkkmnmn
 * 说明
 * k 重复3次，mn 重复2次，最终得到 kkkmnmn
 * 示例2
 * 输入
 * 3[m2[c]]
 * 输出
 * mccmccmcc
 * 说明
 * m2[c] 解压缩后为 mcc，重复三次为 mccmccmcc”
 */
public class D0618DecompressionFile {
    public static void main(String[] args) {
        System.out.println(55%2);
    }

    public static void test() {
        String str = "love234csdn3423java";
        String regEx = "[0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        while (m.find()) {
            System.out.println(m.group());
        }
     }

    public static boolean isDigit(String strNum) {
        return strNum.matches("[0-9]{1,}");
    }

    public static void test01() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        String res = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ']') {
                String tem = "";
                while (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    if (pop >= 'a' && pop <= 'z') {
                        tem = pop + tem;
                    } else if (Character.isDigit(pop)) {
                        int num = 0;
                        if (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                            num = (stack.pop() - '0') * 10 + pop - '0' + num;
                        } else {
                            num = pop - '0' + num;
                        }
                        String temS = tem;
                        for (int j = 0; j < num; j++) {
                            tem += temS;
                        }
                    }

                }
                res += tem;
            }
            stack.push(chars[i]);
        }
        System.out.println(res);
    }

    public static void test2() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] ch = input.toCharArray();
        Stack<String> stack = new Stack<>();
        StringBuffer sb1 = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            int t = i;
            while (ch[i] <= '9' && ch[i] >= '0') {
                i++;
            }
            if (t != i) {
                stack.push(input.substring(t, i));
            }
            if (ch[i] != ']' && !String.valueOf(ch[i]).equals("")) {
                stack.push(String.valueOf(ch[i]));
            } else {
                String sb = "";
                while (!stack.isEmpty()) {
                    String str = stack.pop();
                    if (!isDigit(str) && !str.equals("[") ) {
                        sb = str + sb;
                    } else if (isDigit(str)){
                        String temp = "";
                        String st = sb;
                        int a = Integer.parseInt(str);
                        for (int j = 0; j < a; j++) {
                            temp = st + temp;
                        }
                        sb = temp;
                    }
                }
                sb1.append(sb);
            }
        }
        System.out.println(sb1);
    }

}
