package com.dexing.od1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *  题目描述 日志采集是运维系统的的核心组件。
 *  日志是按行生成，每行记做一条，由采集系统分批上报。 如果上报太频繁，会对服务端造成压力;
 *  如果上报太晚，会降低用户的体验;如果一次上报的条数太多，会导致超时失败。
 *  为此，项目组设计了如下的上报策略:
 *  1、每成功上报一条日志，奖励1分
 *  2、每条日志每延迟上报1秒，扣1分
 *  3、积累日志达到100条，必须立即上报 给出日志序列，
 *  根据该规则，计算首次上报能获得的最多积分数
 *  输入描述: 
 *  按时序产生的日志条数 T1,T2...Tn，其中 1<=n<=1000，0<=Ti<=100输出描述: 首次上报最多能获得的积分数 
 *  示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入
 *  1 98 1
 *  输出  98
 *  说明： 
 *  T1 时刻上报得 1 分 
 *  T2 时刻上报得98分，最大 
 *  T3 时刻上报得 0 分 
 *  示例2 输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入
 *  3 7 40 10 60
 *  输出
 *  37 
 *  说明： 
 *  T1 时刻上报得 3 分 
 *  T2 时刻上报得 7 分 
 *  T3 时刻上报得 37 分，最大 
 *  T4 时刻上报得 -3 分 
 *  T5 时刻上报，因为已经超了100条的限制，所以只能上报100条，得 -23 分
 *
 *  思路：
 *  1：说实话这个题理解起来很费劲，读懂题意也就是这个题最大的难度了。 
 *  2：就用例子2来说明，因为累计100条就必须上报了，首次上报的条件很容易达成。 
 *      T1时刻不用说，
 *      T2时刻上报，当前为7条，前一秒为3条，总共10条，上报得10分，但是T1的 3条超时了1秒，所以减3分，最后得到7分。
 *      T3时刻上报，当前为40条，加上前两秒的，总共50条，上报得50分，但是T2的 7条超时了1秒，减7分，T1的3条超时了2秒，减6分，最后得37分。
 *  依次类推。 
 *  3：由于题目限制最多1000条，而且求首次上报的最大得分，我觉得暴力法可以解决问题。
 *
 */
public class D1560LogLoad {

    public static void main(String[] args) {
        //处理输入
        Scanner in=new Scanner(System.in);
        List<Integer> logs = Arrays.stream(in.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // 记录到当前秒的总条数
        int sum = 0;

        // 记录到当前秒之前的总条数
        // 每一轮都会减一次
        int pre_sum = 0;

        // 记录到当前秒首次上报要减去的分数
        int n_score = 0;

        // 记录到首次上报的最大得分
        int max_score = 0;

        for (int i=0;i<logs.size();i++) {
            pre_sum = sum;
            sum += logs.get(i);
            // 还有个100条的限制
            if (sum >= 100) {
                sum = 100;
                n_score += pre_sum;
                max_score = Math.max(max_score, sum - n_score);
                break;
            }
            n_score += pre_sum;
            max_score = Math.max(max_score,  sum - n_score);
        }
        System.out.println(max_score);


    }
    
}
