package com.dexing.od1;

import java.util.ArrayList;

/**
 * 公司创新实验室正在研究如何最小化资源成本，最大化资源利用率，请你设计算法帮他们解决一个任务混部问题：
 * 有taskNum项任务，每个任务有开始时间（startTime），结束时间（endTime）,并行度（parallelism）三个属性，
 * 并行度是指这个任务运行时将会占用的服务器数量，一个服务器在每个时刻可以被任意任务使用但最多被一个任务占用，任务运行完成立即释放（结束时刻不占用）。任务混部问题是指给定一批任务，让这批任务由同一批服务器承载运行，请你计算完成这批任务混部最少需要多少服务器，从而最大最大化控制资源成本。
 *  输入描述： 第一行输入为taskNum，表示有taskNum项任务 接下来taskNum行，每行三个整数，表示每个任务的开始时间 （startTime ），结束时间（endTime ），并行度（parallelism）
 *  输出描述： 一个整数，表示最少需要的服务器数量
 *  示例1 输入输出示例仅供调试，后台判断数据一般不包含示例
 *  输入
 *  3
 *  2 3 1
 *  6 9 2
 *  0 5 1
 *  输出
 *  2
 *  说明 一共有三个任务，第一个任务在时间区间【2，3】运行，占用1个服务 器，第二个任务在时间区间【6，9】运行，占用2个服务器，第三个任 务在时间区间【0，5】运行，占用1个服务器，需要最多服务器的时间 区间为【2，3】和【6，9】，需要2个服务器。
 *  示例2 输入输出示例仅供调试，后台判断数据一般不包含示例 输入 2 3 9 2 4 7 3 输出 5 说明 一共两个任务，第一个任务在时间区间【3，9】运行，占用2个服务 器，第二个任务在时间区间【4，7】运行，占用3个服务器，需要最多 服务器的时间区间为【4，7】，需要5个服务器。
 *  备注： 1<=taskNum<=100000 0<=startTime<endTime<=50000 1<=parallelism<=100
 *
 *  思路：
 *  1：题目与第56题【区间交集】非常相似。大致思路应该是不断的递归对区间求交集，求得交集之后将占用机器数相加，
 *  直到没有交集为止。
 *  2：举一个比较长的例子：
 *  4
 *  0 5 1
 *  2 3 1
 *  4 7 3
 *  6 9 2
 *  排序后区间为：[0,5] [2,3] [4,7] [6,9]
 *  第一轮两两之间求交集：
 *  [0,5] 和 [2,3] 交集为[2,3] 机器数相加为2
 *  [0,5] 和 [4,7] 交集为[4,5] 机器数相加为4
 *  [0,5] 和 [6,9] 无交集
 *  [2,3] 和 [4,5] 无交集
 *  [2,3] 和 [6,9] 无交集
 *  [4,7] 和[6,9] 交集为[6,7] 机器数相加为5
 *  第二轮两两之间求交集：
 *  [2,3] [4,5] [6,7] 两两之间都没有交集，因此最多的机器数为5。
 */
public class D0302SourceLimit {
    private static Integer max =0;
    public static void main(String[] args) {
        test();

    }

    public static void test() {
        ArrayList<Task> list = new ArrayList<>();
        int taskNum = 3;
        initData(list,3);
        list.sort(null);


        // 递归求交集
        while (list.size() > 1) {
            list = calPublicRange(list);
        }
        System.out.println(max);
    }

    private static ArrayList<Task> calPublicRange(ArrayList<Task> list) {
        ArrayList<Task> tasks = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                int left = Math.max(list.get(i).getStart(),list.get(j).getStart());
                int right = Math.min(list.get(i).getEnd(),list.get(j).getEnd());
                if (left<= right) {
                    Task task = new Task();
                    task.setStart(left);
                    task.setEnd(right);
                    task.setParallelism(list.get(i).getParallelism()+list.get(j).getParallelism());
                    tasks.add(task);
                    if (list.get(i).getParallelism()+list.get(j).getParallelism() >max) {
                        max = list.get(i).getParallelism()+list.get(j).getParallelism();
                    }
                }
            }
        }
        return tasks;
    }

    private static void initData(ArrayList<Task> list, int i) {
        String[] split = "2 3 1".split("\\s+");
        Task task = new Task(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        list.add(task);
        String[] split1 = "6 9 2".split("\\s+");
        Task task1 = new Task(Integer.parseInt(split1[0]), Integer.parseInt(split1[1]), Integer.parseInt(split1[2]));
        list.add(task1);
        String[] split2 = "0 5 1".split("\\s+");
        Task task2 = new Task(Integer.parseInt(split2[0]), Integer.parseInt(split2[1]), Integer.parseInt(split2[2]));
        list.add(task2);

    }

    static class Task implements Comparable<Task>{
        private Integer start;
        private Integer end;
        private Integer parallelism;

        public Task(Integer start, Integer end, Integer parallelism) {
            this.start = start;
            this.end = end;
            this.parallelism = parallelism;
        }

        public Task() {
        }

        public Integer getStart() {
            return start;
        }

        public void setStart(Integer start) {
            this.start = start;
        }

        public Integer getEnd() {
            return end;
        }

        public void setEnd(Integer end) {
            this.end = end;
        }

        public Integer getParallelism() {
            return parallelism;
        }

        public void setParallelism(Integer parallelism) {
            this.parallelism = parallelism;
        }

        @Override
        public int compareTo(Task o) {
            if (this.start != o.start) {
                return o.start - this.start;
            } else {
                return o.end - this.end;
            }
        }
    }
}
