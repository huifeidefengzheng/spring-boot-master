package com.dexing.od;

import java.util.Scanner;

/**
 * 输入一个字符串仅包含大小写字母和数字，求字符串中包含的最长的非严格递增连续数字序列的长度（比如12234属于非严格递增连续数字序列）。
 * 输入描述:
 * 输入一个字符串仅包含大小写字母和数字，输入的字符串最大不超过255个字符。
 * 输出描述:
 * 最长的非严格递增连续数字序列的长度
 * 示例1：
 * 输入
 * abc2234019A334bc
 * 输出
 * 4
 * 说明
 * 2234为最长的非严格递增连续数字序列，所以长度为4。
 *
 * 思路：字符串中字符大于'0' 小于'9' 是数字，使用临时字符tem存储前一个数字字符，当前字符ch== tem+1或者ch==tem时，满足要求；
 * 当不满足时，判断当前位置end和开始位置start的距离，每次取最大值，
 */
public class D1340FeiYanGeSorceUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        int start = 0;
        int end = 0;
        int max = 0;
        char tem = ' ';
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch>= '0' && ch<='9'){
                if (start == 0){
                    start = i;
                    end = i;
                    tem = ch;
                    continue;
                }
                if (ch == tem + 1 || ch == tem){
                    tem = ch;
                    end++;
                }else {
                    max = Math.max(max,end - start+1);
                    start = 0;
                    end = 0;
                    tem = ' ';
                }
            }else {
                max = Math.max(max,end - start+1);
                start = 0;
                end = 0;
                tem = ' ';
            }
        }
        System.out.println(max);
    }
}
