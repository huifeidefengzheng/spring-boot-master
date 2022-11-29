package com.dexing.od;

import java.util.Locale;

/**
 * 给定一个非空字符串S，其被N个‘-’分隔成N+1的子串，给定正整数K，要求除第一个子串外，其余的子串每K个字符组成新的子串，并用‘-’分隔。对于新组成的每一个子串，如果它含有的小写字母比大写字母多，则将这个子串的所有大写字母转换为小写字母；反之，如果它含有的大写字母比小写字母多，则将这个子串的所有小写字母转换为大写字母；大小写字母的数量相等时，不做转换。
 * 输入描述:
 * 输入为两行，第一行为参数K，第二行为字符串S。
 * 输出描述:
 * 输出转换后的字符串。
 * 示例1
 * 输入
 * 3
 * 12abc-abCABc-4aB@
 * 输出
 * 12abc-abc-ABC-4aB-@
 * 说明
 * 子串为12abc、abCABc、4aB@，第一个子串保留，后面的子串每3个字符一组为abC、ABc、4aB、@，abC中小写字母较多，转换为abc，ABc中大写字母较多，转换为ABC，4aB中大小写字母都为1个，不做转换，@中没有字母，连起来即12abc-abc-ABC-4aB-@
 * 示例2
 * 输入
 * 12
 * 12abc-abCABc-4aB@
 * 输出
 * 12abc-abCABc4aB@
 * 说明
 * 子串为12abc、abCABc、4aB@，第一个子串保留，后面的子串每12个字符一组为abCABc4aB@，这个子串中大小写字母都为4个，不做转换，连起来即12abc-abCABc4aB@
 */
public class D3095StrSplit {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int k = 3;
        String input = "12abc-abCABc-4aB@";
        String[] split = input.split("-");
        StringBuffer buffer = new StringBuffer();

        for (int i = 1; i < split.length; i++) {
            buffer.append(split[i]);
        }
        StringBuffer res = new StringBuffer();
        res.append(split[0]).append("-");
        String con = buffer.toString();
        while (con.length() != 0) {
            String substring = "";
            if (con.length() < k) {
                substring = con.substring(0,con.length());
                con = "";
            } else {
                substring = con.substring(0, k);
                con = con.substring(k);
            }
            substring = checkCase(substring);
            res.append(substring).append("-");
        }
        res.deleteCharAt(res.length()-1);
        System.out.println(res);
    }

    private static String checkCase(String substring) {
        int up = 0,low = 0;
        for (int i = 0; i < substring.length(); i++) {
            char c = substring.charAt(i);
            if (c >= 'A' && c <= 'Z'){
                up++;
            } else if (c >= 'a' && c <= 'z') {
                low++;
            }
        }
        if (up > low) {
            return substring.toUpperCase(Locale.ROOT);
        } else if (up< low){
            return substring.toLowerCase(Locale.ROOT);
        } else {
            return substring;
        }
    }
}
