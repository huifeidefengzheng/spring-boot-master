package com.dexing.od1;


import java.util.Scanner;

/**
 *  一张地图上有n个城市，城市和城市之间有且只有一条道路相连：要么直接相连，要么通过其它城市中转相连（可中转一次或多次）。城市与城市之间的道路都不会成环。
 *  当切断通往某个城市 i 的所有道路后，地图上将分为多个连通的城市群，设该城市i的聚集度为DPi（Degree of Polymerization），
 *  DPi = max（城市群1的城市个数，城市群2的城市个数，…城市群m 的城市个数）。
 *  请找出地图上DP值最小的城市（即找到城市j，使得DPj = min(DP1,DP2 … DPn))
 *  提示：如果有多个城市都满足条件，这些城市都要找出来（可能存在多个解）
 *  提示：DPi的计算，可以理解为已知一棵树，删除某个节点后；生成的多个子树，求解多个子数节点数的问题。
 *  输入描述：
 *  每个样例：第一行有一个整数N，表示有N个节点。1 <= N <= 1000。
 *  接下来的N-1行每行有两个整数x，y，表示城市x与城市y连接。1 <= x, y <= N
 *  输出描述：
 *  输出城市的编号。如果有多个，按照编号升序输出。
 *  示例1  输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入
 *  5
 *  1 2
 *  2 3
 *  3 4
 *  4 5
 *  输出
 *  3
 *  说明
 *  输入表示的是如下地图：
 *  ①-②-③-④-⑤
 *
 *  对于城市3，切断通往3的所有道路后，形成2个城市群[（1，2），（4，5）]，其聚集度分别都是2。DP3 = 2。
 *  对于城市4，切断通往城市4的所有道路后，形成2个城市群[（1，2，3），（5）]，DP4 = max（3，1）= 3。
 *  依次类推，切断其它城市的所有道路后，得到的DP都会大于2，因为城市3就是满足条件的城市，输出是3。
 *  示例2  输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入
 *  6
 *  1 2
 *  2 3
 *  2 4
 *  3 5
 *  3 6
 *  输出
 *  2 3
 *  说明
 *  将通往2或者3的所有路径切断，最大城市群数量是3，其他任意城市切断后，最大城市群数量都比3大，所以输出2 3。
 *
 *  思   路
 *  1：当切断通往一个城市i的所有路径之后，其他的城市形成了独立的城市群，这比较容易想到并查集，两个城市相连，
 *      就把两个城市合并。循环n次遍历所有城市的结果，每个城市遍历所有的链接信息，如果出现当前循环需要排除的城市，则不执行本次合并操作。
 *  2：并查集实现细节 
 *  并查集模板中初始化时，需要从1开始，因为城市的编号是从1开始。
 *  统计每个城市所在的最大的城市数量，即聚集度 3：并查集实现的C++ 版本可以保存下来以后也可以用。
 */
public class D0730CityCollect {
    //并查集模板
    static class UnionFind {
        int N;
        int count;
        int[] id;
        int[] sz;

        private UnionFind (int n) {
            N = n;
            count = n;
            id = new int[n + 1];
            sz = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

        public int getMax () {
            int max = 0;
            for (int i = 1; i < sz.length; i++) {
                max = Math.max(max, sz[i]);
            }
            return max;
        }

        public void union (int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot != qRoot) {
                if (sz[pRoot] < sz[qRoot]) {
                    id[pRoot] = qRoot;
                    sz[qRoot] += sz[pRoot];
                } else {
                    id[qRoot] = pRoot;
                    sz[pRoot] += sz[qRoot];
                }
                count--;
            }
        }

        private int find (int p) {
            if (p == id[p]) {
                return p;
            }
            id[p] = find(id[p]);
            return id[p];
        }
    }

    public static void main(String[] args) {
        //处理输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n - 1; i++) {
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        int res = Integer.MAX_VALUE;
        int[] maxArray = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            UnionFind uf = new UnionFind(n);
            for (int j = 0; j < n - 1; j++) {
                if (arr[j][0] == i || arr[j][1] == i)  {
                    continue;
                } else {
                    uf.union(arr[j][0], arr[j][1]);
                }
            }
            maxArray[i] = uf.getMax();
            res = Math.min(res, maxArray[i]);
        }
        String result = "";
        for (int i = 1; i < maxArray.length; i++) {
            if (maxArray[i] == res) {
                result += String.valueOf(i) + " ";
            }
        }
        System.out.println(result);
    }
}
