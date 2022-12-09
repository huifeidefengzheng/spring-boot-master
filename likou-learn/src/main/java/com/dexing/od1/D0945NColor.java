package com.dexing.od1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 *  疫情过后，希望小学终于又重新开学了，三年二班开学第一天的任务是将后面的黑板报重新制作。
 *  黑板上已经写上了N个正整数，同学们需要给这每个数分别上一种颜色。
 *  为了让黑板报既美观又有学习意义，老师要求同种颜色的所有数都可以被这种颜色中最小的那个数整除。
 *  现在请你帮帮小朋友们，算算最少需要多少种颜色才能给这N个数进行上色。
 *  输入描述
 *  第一行有一个正整数N，其中。
 *  第二行有N个int型数(保证输入数据在[1,100]范围中)，表示黑板上各个正整数的值。
 *  输出描述
 *  输出只有一个整数，为最少需要的颜色种数。
 *  示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入
 *  3
 *  2 4 6
 *  输出
 *  1
 *  说明
 *  所有数都能被2整除
 *  示例2
 *  输入
 *  4
 *  2 3 4 9
 *  输出
 *  2
 *  说明
 *  2与4涂一种颜色，4能被2整除；3与9涂另一种颜色，9能被3整除。不能4个数涂同一个颜色，因为3与9不能被2整除。所以最少的颜色是两种。
 *
 *  1：最重要是理解这句话 ”同种颜色的所有数都可以被这种颜色中最小的那个数整除“ 
 *  2：然后又需要最少的颜色个数。 
 *  3：因为输入的数据量很小，最大只有100个，那么暴力法又可以上场了。直接两层 for 循环，每个数都互相比较一下，如果可以相除，那就只保留其中一个即可。以此类推，当所有的数字都互相比完之后，留下的就是最少的个数啦。 
 * 
 */
public class D0945NColor {
        public static void main(String[] args) {
            // 处理输入
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            Arrays.sort(nums);
            boolean[] used = new boolean[n];
            int result = 0;
            for (int i = 0; i < n; i++) {
                if (used[i]) {
                    continue;
                } else {
                    for (int j = i; j < n; j++) {
                        if (nums[j] % nums[i] == 0) {
                            used[j] = true;
                        }
                    }
                    result += 1;
                }
            }
            System.out.println(result);
        }
}
