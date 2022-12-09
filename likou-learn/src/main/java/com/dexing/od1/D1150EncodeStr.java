package com.dexing.od1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *  给你一串未加密的字符串str，通过对字符串的每一个字母进行改变来实现加密，
 *  加密方式是在每一个字母str[i]偏移特定数组元素a[i]的量，数组a前三位已经赋值：a[0]=1,a[1]=2,a[2]=4。
 *  当i>=3时，数组元素a[i]=a[i-1]+a[i-2]+a[i-3]。 
 *  例如：原文 abcde 加密后 bdgkr，其中偏移量分别是1,2,4,7,13。 
 *  输入描述: 
 *  第一行为一个整数n（1<=n<=1000），表示有n组测试数据，每组数据包含一行，原文str（只含有小写字母，0<长度<=50）。 
 *  输出描述: 
 *  每组测试数据输出一行，表示字符串的密文。 
 *  示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入 
 *  1 
 *  xy 
 *  输出 
 *  ya 
 *  说明 
 *  第一个字符x偏移量是1，即为y，第二个字符y偏移量是2，即为a。
 */
public class D1150EncodeStr {
    // 方法 1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = Integer.parseInt(scanner.nextLine());
        for (int j = 0; j < i; j++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            char[] chars = scanner.nextLine().toCharArray();
            initArr(chars.length,arrayList);
            check(chars,arrayList);
        }
    }

    private static void check(char[] chars, ArrayList<Integer> arrayList) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            Integer integer = arrayList.get(i);
            if (aChar+integer > 'z') {
                int i1 = aChar + integer - 'z' + 'a'-1;
                buffer.append((char) i1);
            } else {
                buffer.append((char) (aChar+integer));
            }
        }
        System.out.println(buffer);
    }

    private static void initArr(int length, ArrayList<Integer> arrayList) {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(4);
        if (length < 3) {
            return;
        }
        for (int i = 3; i < length; i++) {
            arrayList.add(arrayList.get(i-1)+arrayList.get(i-2)+arrayList.get(i-3));
        }
    }

    // 方法 2
    public static void test2() {
        // 处理输入
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            String[] arr = new String[n];
            // 偏移数组大小
            int max = 4;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLine();
                max = Math.max(max, arr[i].length());
            }
            // 偏移数组
            int[] offsetArr = new int[max];
            offsetArr[0] = 1;
            offsetArr[1] = 2;
            offsetArr[2] = 4;
            for (int i = 3; i < max; i++) {
                offsetArr[i] = offsetArr[i - 1] + offsetArr[i - 2] + offsetArr[i - 3];
            }
            for (int i = 0; i < n; i++) {
                String str = arr[i];
                StringBuilder resStr = new StringBuilder();
                for (int j = 0; j < str.length(); j++) {
                    // 取余，避免溢出
                    int res = (str.charAt(j) - 'a' + offsetArr[j]) % 26 + 'a';
                    resStr.append((char) res);
                }
                System.out.println(resStr);
            }
        }
        in.close();
    }
}
