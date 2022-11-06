package com.dexing.od;

import java.util.Scanner;
import java.util.Stack;

/**
 * 【消消乐游戏】游戏规则：输入一个只包含英文字母的字符串，字符串中的两个字母如果相邻且相同，就可以消除。
 * <p>
 * 在字符串上反复执行消除的动作，直到无法继续消除为止，此时游戏结束。
 * <p>
 * 输出最终得到的字符串长度。
 */
public class D0202XiaoXiaoLe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Stack<String> strings = new Stack<>();
        strings.push("" + str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            String pop = strings.peek();
            String temp = "" + str.charAt(i);
            if (pop.equals(temp)) {
                strings.pop();
            } else {
                strings.push(temp);
            }
        }
        System.out.println(strings.size());

    }
}
