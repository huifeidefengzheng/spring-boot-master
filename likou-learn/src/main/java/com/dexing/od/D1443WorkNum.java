package com.dexing.od;

/**
 * 3020年，空间通信集团的员工人数突破20亿人，即将遇到现有工号不够用的窘境。
 * 现在，请你负责调研新工号系统。继承历史传统，新的工号系统由小写英文字母（a-z）和数字（0-9）两部分构成。新工号由一段英文字母开头，之后跟随一段数字，比如"aaahw0001",“a12345”,“abcd1”,“a00”。注意新工号不能全为字母或者数字,允许数字部分有前导0或者全为0。
 * 但是过长的工号会增加同事们的记忆成本，现在给出新工号至少需要分配的人数X和新工号中字母的长度Y，求新工号中数字的最短长度Z。
 * 输入描述:
 * 一行两个非负整数 X Y，用数字用单个空格分隔。
 * 0< X <=2^50 - 1
 * 0< Y <=5
 * 输出描述:
 * 输出新工号中数字的最短长度Z
 * 示例1
 * 输入
 * 260 1
 * 输出
 * 1
 * 示例2
 * 输入
 * 26 1
 * 输出
 * 1
 * 说明
 * 数字长度不能为0
 * 示例3
 * 输入
 * 2600 1
 * 输出
 * 2
 *
 * 思路：
 *   工号用字符Y 和数字组成，
 *   Y表示工号中字符的长度，字符的组合数为 Math.pow(26, y) 即26的Y次方
 *   z表示工号中数字的长度，0-9一共10个数字，可以全用0，或者前导为0，数字部分的组合数为10的z次方
 *   当一个数字时一共的人数为 Math.pow(26, y) * Math.pow(10, 1)
 *   判断当前人数和一个数字的人数，
 */
public class D1443WorkNum {
    public static void main(String[] args) {
        System.out.println(1%2);
        System.out.println(4%3);
    }

    public static void test() {
        int x = 260 , y =1;
        double pow = Math.pow(26, y);
        //数字为一个时的人数为：Math.pow(26,y)* 10;
        double oneNum = Math.pow(26, y) * 10;
        // 判断当前输入人数 和数字为一个时比较
        int num = 1;
        while (x > oneNum) {
            oneNum = Math.pow(26, y) * Math.pow(10, (num ++));
        }
        System.out.println(num);
    }
}
