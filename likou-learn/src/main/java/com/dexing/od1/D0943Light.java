package com.dexing.od1;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 【路灯照明】
 *  一条长l的笔直的街道上有n个路灯，若这条街的起点为0，终点为l，第i个路灯坐标为a[i] ，每盏灯可以覆盖到的最远距离为d，
 *  为了照明需求，所有灯的灯光必须覆盖整条街，但是为了省电，要使这个d最小，请找到这个最小的d。
 *  输入描述:
 *  每组数据第一行两个整数n和l（n大于0小于等于1000，l小于等于1000000000大于0）。
 *  第二行有n个整数(均大于等于0小于等于l)，为每盏灯的坐标，多个路灯可以在同一点。
 *  输出描述:
 *  输出答案，保留两位小数。
 *  示例1  输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入
 *  7 15
 *  15 5 3 7 9 14 0
 *  输出
 *  2.50
 *
 *  1：这个题目只要理解了还是比较简单的，由于两个路灯之间的距离可以分担照明，那么就说明拿出每两个路灯之间距离的一半取出最大值即可，
 *      这样就能保证灯光必须覆盖整条街。
 *  2：特殊情况就是第一个和最后一个路灯距离起点和终点的距离不能减半。 
 *  3：最后再注意输出的要求，要保留两位小数。
 */
public class D0943Light {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        List<Integer> list = Arrays.asList("7 15".split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
        int n = list.get(0);
        int l = list.get(1);
        List<Integer> light = Arrays.asList("15 5 3 7 9 14 0".split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
        Collections.sort(light);
        double tem = 0.00, max = 0.00;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        for (int i = 0; i < light.size(); i++) {
            Integer integer = light.get(i);
            max = Math.max(Double.parseDouble(decimalFormat.format((integer-tem)/2.00)),max);
            tem = integer;
        }
        // 判断两端的距离
        int te = l -light.get(n-1);
        int mm = light.get(0) < te ? te: light.get(0);
        double res = mm < max ? max:mm;
        System.out.println(decimalFormat.format(res));
    }
}
