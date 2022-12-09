package com.dexing.od1;


/**
 * 羊、狼、农夫都在岸边，当羊的数量小于狼的数量时，狼会攻击羊，农夫则会损失羊。农夫有一艘容量固定的船，能够承载固定数量的动物。
 *  要求求出不损失羊情况下将全部羊和狼运到对岸需要的最小次数。只计算农夫去对岸的次数，回程时农夫不会运送羊和狼。
 *  备注：农夫在或农夫离开后羊的数量大于狼的数量时狼不会攻击羊。
 *  农夫自身不占用船的容量。
 *  输入描述
 *  第一行输入为M，N，X， 分别代表羊的数量，狼的数量，小船的容量。
 *  输出描述
 *  输出不损失羊情况下将全部羊和狼运到对岸需要的最小次数。
 *  （若无法满足条件则输出0）
 *
 *  示例1：
 *  输入： 5 3 3
 *  输出： 3
 *  说明： 第一次运2只狼 第二次运3只羊 第三次运2只羊和1只狼
 *  示例2：
 *  输入：
 *  5 4 1
 *  输出： 0
 *  说明： 如果找不到不损失羊的运送方案，输出0
 *
 *  思路：
 *   1：首先几个边界条件要清楚
 *  第一、羊的数量不能小于狼的数量
 *  第二、农夫自身不占用船的容量。
 *  第三、回程时农夫不会运送羊和狼。
 *  2：不管在河的两岸都需要满足羊的数量不能小于狼的数量。
 *  3：这样的话明显一个DFS 就可以解决问题，因为有重复的子问题就是运送多少只动物的情况下是否满足不损失动物的条件。
 */
public class D0425SheepWolf {

    public static int minTimes= 0;
    public static void main(String[] args) {

    }
    public static void test() {
        String[] split = "".split("\\s+");
        int sheepNum = Integer.parseInt(split[0]);
        int wolfNum = Integer.parseInt(split[1]);
        int num = Integer.parseInt(split[2]);
        int minTimes = (sheepNum+wolfNum)*num;
        // 已运到对岸羊和狼的个数
        int sTem = 0,wTem=0;
        def(sheepNum,wolfNum,num,sTem,wTem,0);
        if (minTimes == (sheepNum+ wolfNum)*num) {
            System.out.println(0);
        } else {
            System.out.println(minTimes);
        }
    }

    private static int def(int sheepNum, int wolfNum, int num, int sTem, int wTem, int i) {
        // 可以一次运走，结束循环
        if (num >= sheepNum+wolfNum) {
            if (i+1<minTimes) {
                minTimes=i+1;
            }
            return minTimes;
        }
        // 一次运一部分
        // 上船的羊数量不可以超过船的容量
        for (int j = 0; j <= sheepNum && j <= num; j++) {
            // 上船的狼数量+船上羊数量不能超过船容量
            for (int k = 0; k <= wolfNum && j+k <= num; k++) {
                // 不可以不运
                if (j+k == 0) {
                    continue;
                }
                // 船离岸后，原来的岸上，要么没有羊，要么羊比狼多，才可以运，对岸也要做检查，不考虑回运动物
                if ((sheepNum -j == 0|| sheepNum -j > wolfNum -j) && (sTem +j  == 0 || sTem+j > wTem + j)) {
                    // 运输
                    int result = def(sheepNum -j,wolfNum -k,num,sTem+i,wTem+k,i+1);
                    // 如果获取了结果，
                    if (result < minTimes) {
                        minTimes = result;
                    }
                }
            }
        }
        return 0;
    }
}
