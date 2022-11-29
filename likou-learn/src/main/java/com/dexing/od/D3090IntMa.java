package com.dexing.od;


import java.util.Locale;

/**
 * 实现一种整数编码方法，使得待编码的数字越小，编码后所占用的字节数越小。
 * 编码规则如下：
 * 1、编码时7位一组，每个字节的低7位用于存储待编码数字的补码。
 * 2、字节的最高位表示后续是否还有字节，置1表示后面还有更多的字节，置0表示当前字节为最后一个字节。
 * 3、采用小端序编码，低位和低字节放在低地址上。
 * 3、编码结果按16进制数的字符格式输出，小写字母需转换为大写字母。
 * 输入描述:
 * 输入的为一个字符串表示的非负整数
 * 输出描述:
 * 输出一个字符串，表示整数编码的16进制码流
 * 示例1
 * 输入
 * 0
 * 输出
 * 00
 * 说明
 * 输出的16进制字符，不足两位的前面补0，如00、01、02。
 * 示例2
 * 输入
 * 100
 * 输出
 * 64
 * 说明
 * 100的二进制表示为0110 0100，只需要一个字节进行编码；
 * 字节的最高位置0，剩余7位存储数字100的低7位（110 0100），所以编码后的输出为64。
 * 示例3
 * 输入
 * 1000
 * 输出
 * E807
 * 说明
 * 1000的二进制表示为0011 1110 1000，至少需要两个字节进行编码；
 * 第一个字节最高位置1，剩余的7位存储数字1000的第一个低7位（110 1000），所以第一个字节的二进制为1110 1000，即E8；
 * 第二个字节最高位置0，剩余的7位存储数字1000的第二个低7位（000 0111），所以第一个字节的二进制为0000 0111，即07；
 * 采用小端序编码，所以低字节E8输出在前，高字节07输出在后。
 * 备注:
 * 待编码的数字取值范围为[0, 1<<64 - 1]
 */
public class D3090IntMa {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int input = 100;
        String s = Integer.toBinaryString(input);
        boolean flag = false;
        StringBuffer buffer = new StringBuffer();
        while (s.length() > 0) { // 先找到低于7位的
            if (s.length() > 7) {
                flag = true;
            } else { // 2进制不足7位时补0
                flag = false;
                int mid = 7 - s.length();
                for (int i = 0; i < mid; i++) {
                    s = "0"+s;
                }

            }
            String sub = s.substring(s.length() - 7);
            s = s.substring(0,s.length() -7);
            // 1表示高位 0表示前面没有数字了
            if (flag) {
                sub = "1" +sub;
            } else {
                sub = "0" +sub;
            }
            // 先转为2进制整数，在转为16进制
            String res = Integer.toHexString(Integer.parseInt(sub, 2));
            if (res.length() <2) { // 16进制不足2位的补0
                res = "0" +res;
            }
            for (int i = 0; i < res.length(); i++) {
                char c = res.charAt(i);
                if (c >='A' && c <= 'z'){
                    buffer.append(String.valueOf(c).toUpperCase(Locale.ROOT));
                } else {
                    buffer.append(c);
                }
            }
        }
        System.out.println(buffer);
    }




}
