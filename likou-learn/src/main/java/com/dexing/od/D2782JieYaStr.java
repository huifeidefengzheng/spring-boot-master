package com.dexing.od;

import java.util.*;

/**
 * 有一种简易压缩算法：针对全部由小写英文字母组成的字符串，将其中连续超过两个相同字母的部分压缩为连续个数加该字母，其他部分保持原样不变。例如：字符串“aaabbccccd”经过压缩成为字符串“3abb4cd”。 请您编写解压函数，根据输入的字符串，判断其是否为合法压缩过的字符串，若输入合法则输出解压缩后的字符串，否则输出字符串“!error”来报告错误。
 * 输入描述:
 * 输入一行，为一个ASCII字符串，长度不会超过100字符，用例保证输出的字符串长度也不会超过100字符
 * 输出描述:
 * 若判断输入为合法的经过压缩后的字符串，则输出压缩前的字符串；若输入不合法，则输出字符串“!error”。
 * 示例1
 * 输入
 * 4dff
 * 输出
 * ddddff
 * 说明
 * 4d扩展为dddd，故解压后的字符串为ddddff
 * 示例2
 * 输入
 * 2dff
 * 输出
 * !error
 * 说明
 * 两个d不需要压缩，故输入不合法
 * 示例3
 * 输入
 * 4d@A
 * 输出
 * !error
 * 说明
 * 全部由小写英文字母组成的字符串压缩后不会出现特殊字符@和大写字母A，故输入不合法
 *
 */
public class D2782JieYaStr {
    public static void main(String[] args) {
        test();
    }

    public static void test2() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int times = 1;
            StringBuilder count = new StringBuilder();
            if ((ch>= '0' && ch<= '9') ){//34a
                for (int j = i; j < input.length(); j++) {
                    ch = input.charAt(j);
                    if (ch>= '0' && ch<= '9'){
                        count.append(input.charAt(j));
                        i++;
                        continue;
                    }
                    break;
                }
                times = Integer.parseInt(count.toString());
                if (times<= 2){
                    System.out.println("!error");
                    return;
                }
            }
            ch = input.charAt(i);//下一个元素
            if (ch>= 'a' && ch<= 'z'){
                while (times > 0 ){
                    res.append(ch);
                    times--;
                }
            }else {
                System.out.println("!error");
                return;
            }
        }
        System.out.println(res);
    }

    public static void test() {
        String input ="3abb14cd";
        char[] chars = input.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (Character.isDigit(ch)) {
                if (stack.isEmpty()) {
                    stack.push(ch);
                    continue;
                }
                if (!checkNext(i,stack,chars)) {
                    System.out.println("!error");
                    return;
                }
            } else {
                if (ch < 'a' || ch > 'z'){
                    System.out.println("!error");
                    return;
                } else {
                    stack.push(ch);
                }
            }
        }
        StringBuffer buffer = new StringBuffer();
        while (!stack.isEmpty()) {
            Character pop = stack.pollLast();
            if (Character.isDigit(pop)){
                int count = 0;
                while (Character.isDigit(pop)){
                    count = count * 10 + (pop - '0');
                    pop = stack.pollLast();
                }
                for (int i = 0; i < count; i++) {
                    buffer.append(pop);
                }
            } else {
                buffer.append(pop);
            }
        }
        System.out.println(buffer);

    }

    private static boolean checkNext(int index, Deque<Character> stack, char[] chars) {
        boolean flag = true;
        if (Character.isDigit(stack.peekFirst())) {
            stack.push(chars[index]);
        } else if (Character.isDigit(chars[index]) && chars[index] - '0' >= 3){
            stack.push(chars[index]);
        } else if (Character.isDigit(chars[index]) && index + 1< chars.length && Character.isDigit(chars[index+1])) {
            stack.push(chars[index]);
        } else if (chars[index] - '0' < 3) {
            flag = false;
        }
        return flag;
    }
}
