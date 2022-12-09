package com.dexing.od1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 给一块n*m的地块，相当于n*m的二维数组，每个元素的值表示这个小地块的发电量；求在这块地上建立正方形的边长为c的发电站，发电量满足目标电量k的地块数量。
 *  输入描述：
 *  第一行为四个按空格分隔的正整数，分别表示n, m , c k
 *  后面n行整数，表示每个地块的发电量
 *  输出描述：
 *  输出满足条件的地块数量
 *  示例：
 *  输入：
 *  2 5 2 6 &nbsp; // n m c k，下面每行是n*m地块每格的发电量
 *  1 3 4 5 8
 *  2 3 6 7 1
 *  输出：
 *  4
 *  说明：
 *  满足条件的地块有以下几种
 *  第一种：
 *  1 3
 *  2 3
 *  第二种：
 *  3 4
 *  3 6
 *  第三种：
 *  4 5
 *  6 7
 *  第四种：
 *  5 8
 *  7 1
 *
 *  1：这个题在 leetcode 上也有比较类似的：leetcode.1292(https://leetcode.cn/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold)
 *  2：核心解法就是快速的获得矩阵中边长为c的正方形的和，用到的二维前缀和（Prefix Sum）的方法，（我也是复制的leetcode官方的解法，过程不重要，理解最后的公式就行）：
 *      设二维数组 A 的大小为 m * n，行下标的范围为 [1, m]，列下标的范围为 [1, n]。数组 P 是 A 的前缀和数组，等价于 P 中的每个元素 P[i][j]：如果 i 和 j 均大于 0，那么 P[i][j] 表示 A 中以 (1, 1) 为左上角，(i, j) 为右下角的矩形区域的元素之和；如果 i 和 j 中至少有一个等于 0，那么 P[i][j] 也等于 0。
 *      数组 P 可以帮助我们在 O(1)O(1) 的时间内求出任意一个矩形区域的元素之和。具体地，设我们需要求和的矩形区域的左上角为 (x1, y1)，右下角为 (x2, y2)，则该矩形区域的元素之和可以表示为： sum = A[x1..x2][y1..y2] = P[x2][y2] - P[x1 - 1][y2] - P[x2][y1 - 1] + P[x1 - 1][y1 - 1]     其正确性可以通过容斥原理得出。以下图为例，当 A 的大小为 8 * 5，需要求和的矩形区域（深绿色部分）的左上角为 (3, 2)，右下角为 (5, 5) 时，该矩形区域的元素之和为 P[5][5] - P[2][5] - P[5][1] + P[2][1]。
 *
 *  那么如何得到数组 P 呢？我们按照行优先的顺序依次计算数组 P 中的每个元素，即当我们在计算 P[i][j] 时，数组 P 的前 i - 1 行，以及第 i 行的前 j - 1 个元素都已经计算完成。此时我们可以考虑 (i, j) 这个 1 * 1 的矩形区域，根据上面的等式，有：
 *                   A[i][j] = P[i][j] - P[i - 1][j] - P[i][j - 1] + P[i - 1][j - 1] 由于等式中的 A[i][j]，P[i - 1][j]，P[i][j - 1] 和 P[i - 1][j - 1] 均已知，我们可以通过：
 *   P[i][j] = P[i - 1][j] + P[i][j - 1] - P[i - 1][j - 1] + A[i][j]
 *       在 O(1)的时间计算出 P[i][j]。因此按照行优先的顺序，我们可以在O(MN) 的时间得到数组 P。在此之后，我们就可以很方便地在 O(1) 的时间内求出任意一个矩形区域的元素之和了。
 */
public class D0629PlantBuild {
    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        List<Integer> params = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int n = params.get(0);
        int m = params.get(1);
        int c = params.get(2);
        int k = params.get(3);

        int[][] matrix = new int [n][m];
        for (int i=0;i<n;i++) {
            String[] num_strs =in.nextLine().split(" ");
            for (int j=0;j<m;j++) {
                matrix[i][j] = Integer.parseInt(num_strs[j]);
            }
        }

        System.out.println(get_area_count(matrix, k, c));
    }

    public static int get_area_count(int[][] mat, int threshold, int c) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] s = new int [n+1][m+1];
        //1、生成前缀和子矩阵
        for (int i = 1; i <= n; ++i){
            for (int j = 1; j <= m; ++j) {
                //s[i][j]表示以[i,j]作为矩阵最右下角的最大矩阵的前缀和
                //解释：以点[i,j]作为作为最右下角的最大矩阵的前缀和需要加上点[i-1,j]和点[i,j-1]的前缀和，然而会重复多加一个点[i-1][j-1]的前缀和，所以要减一个
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int ans = 0;
        //2、遍历前缀和矩阵，获得边长等于c的矩阵
        for (int i = c; i <= n; ++i) {
            for (int j = c; j <= m; ++j) {
                //重点理解：减去点[i-c][j]和点[i][j-c]的矩阵前缀和，剩下来的为一个边长为c正方形，注意点[i-c][j-c]减了两次，需要加一个回来
                if (s[i][j] - s[i - c][j] - s[i][j - c] + s[i - c][j - c] >= threshold)
                    ans += 1;
            }
        }
        return ans;
    }
}
