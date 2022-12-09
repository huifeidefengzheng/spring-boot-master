package com.dexing.od1;

import java.text.DecimalFormat;
import java.util.Scanner;


/**
 *  每个句子由多个单词组成，句子中的每个单词的长度都可能不一样，我们假设每个单词的长度Ni为该单词的重量，你需要做的就是给出整个句子的平均重量V。
 *  样例1输入输出示例仅供调试，后台判题数据一般不包含示例 
 *  输入 
 *  Who Love Solo 
 *  输出 
 *  3.67
 */
public class D0841WordAvg {
    public static void main(String[] args) {
        // 输入处理
        Scanner in = new Scanner(System.in);
        String input_str = in.nextLine();
        String[] strs =input_str.split(" ");

        // 注意要定义成double 哦
        double total_num = 0.0;
        for (String x : strs) {
            total_num += x.length();
        }

        // 保留两位小数
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format((total_num / strs.length)));
    }
}
