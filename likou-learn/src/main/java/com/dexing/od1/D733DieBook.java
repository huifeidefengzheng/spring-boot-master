package com.dexing.od1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一组书的长宽，并且只有当一本书的长宽同时小于另一本书的长宽时，两书才能叠放在一起，求该组书中最多能有多少本书叠放在一起。
 * 输入
 *  [[20,16],[15,11],[10,10],[9,10]]
 * 输出
 * 解释
 *  前三本可叠放在一起。
 *
 */
public class D733DieBook {

    public static void main(String[] args) {
        //处理输入
//        Scanner in = new Scanner(System.in);
//        String book_info = in.nextLine().replaceAll("\\[", "").replaceAll("\\]", "");
        String book_info = "[[20,16],[15,11],[10,10],[9,10]]".replaceAll("\\[","").replaceAll("\\]","");
        String[] book_list = book_info.split(",");
        int[][] books = new int[book_list.length / 2][2];
        for (int i = 0; i < books.length; i++) {
            books[i][0] = Integer.parseInt(book_list[i * 2]);
            books[i][1] = Integer.parseInt(book_list[i * 2 + 1]);
        }
        Arrays.sort(books, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int[] dp = new int[books.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < books.length; i++) {
            for (int j = 0; j < i; j++) {
                if (books[i][1] > books[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(dp[i], res);
        }
        System.out.println(res);
    }


}
