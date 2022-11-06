package com.dexing.niuke;

public class Compare {

    public static void main(String[] args) {
        String[] split = "2.1.0".split("\\.");
        System.out.println(compare2("1.0.0","1"));
    }

    /**
     * 牛客项目发布项目版本时会有版本号，比如1.02.11，2.14.4等等
     * 现在给你2个版本号version1和version2，请你比较他们的大小
     * 版本号是由修订号组成，修订号与修订号之间由一个"."连接。1个修订号可能有多位数字组成，修订号可能包含前导0，且是合法的。例如，1.02.11，0.1，0.2都是合法的版本号
     * 每个版本号至少包含1个修订号。
     * 修订号从左到右编号，下标从0开始，最左边的修订号下标为0，下一个修订号下标为1，以此类推。
     *
     *比较规则：
     * 一. 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较忽略任何前导零后的整数值。比如"0.1"和"0.01"的版本号是相等的
     * 二. 如果版本号没有指定某个下标处的修订号，则该修订号视为0。例如，"1.1"的版本号小于"1.1.1"。因为"1.1"的版本号相当于"1.1.0"，第3位修订号的下标为0，小于1
     * 三.  version1 > version2 返回1，如果 version1 < version2 返回-1，不然返回0.
     *
     * 比较版本号
     *
     * @param version1 string字符串
     * @param version2 string字符串
     * @return int整型
     */
    public static int compare(String version1, String version2) {
        // write code here
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int length = v1.length - 1;
        int length1 = v2.length - 1;
        for (int i = 0; i <= length || i <= length1; i++) {
            // 字符串
            String str1 = i <= length ? v1[i] : "0";
            String str2 = i <= length1 ? v2[i] : "0";
            Integer value1 = Integer.valueOf(str1);
            Integer value2 = Integer.valueOf(str2);
            if (value1 > value2) {
                return 1;
            } else if (value1 < value2) {
                return -1;
            }
        }
        return 0;
    }

    public static int compare2(String version1, String version2) {
        // write code here
        int len1 = 0, len2 = 0, n1 = version1.length(), n2 = version2.length();
        while(len1 < n1 || len2 < n2) {
            int num1 = 0, num2 = 0;//初始化为0
            while(len1 < n1 && version1.charAt(len1) != '.') {
                //此时如果长度较短的字符串到了尽头，不进入循环，对应数字为0
                num1 = num1 * 10 + (version1.charAt(len1++) - '0');
            }
            while(len2 < n2 && version2.charAt(len2) != '.') {
                num2 = num2 * 10 + (version2.charAt(len2++) - '0');
            }
            if(num1 > num2) {
                return 1;
            } else if(num1 < num2) {
                return -1;
            }
            //指针后移
            ++len1;
            ++len2;
        }
        return 0;
    }
}
