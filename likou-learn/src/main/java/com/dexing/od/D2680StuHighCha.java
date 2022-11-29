package com.dexing.od;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;

/**
 * 小明今年升学到小学一年级，来到新班级后发现其他小朋友们身高参差不齐，然后就想基于各小朋友和自己的身高差对他们进行排序，请帮他实现排序。
 * 输入描述:
 * 第一行为正整数H和N，0<H<200，为小明的身高，0<N<50，为新班级其他小朋友个数。
 * 第二行为N个正整数H1-HN，分别是其他小朋友的身高，取值范围0<Hi<200（1<=i<=N），且N个正整数各不相同。
 * 输出描述:
 * 输出排序结果，各正整数以空格分割。和小明身高差绝对值最小的小朋友排在前面，和小明身高差绝对值最大的小朋友排在最后，如果两个小朋友和小明身高差一样，则个子较小的小朋友排在前面。
 * 示例1
 * 输入
 * 100 10
 * 95 96 97 98 99 101 102 103 104 105
 * 输出
 * 99 101 98 102 97 103 96 104 95 105
 * 说明
 * 小明身高100，班级学生10个，身高分别为95 96 97 98 99 101 102 103 104 105，按身高差排序后结果为：99 101 98 102 97 103 96 104 95 105。
 */
public class D2680StuHighCha {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int xiaoH = 100;
        String input = "95 96 97 98 99 101 102 103 104 105";
        String[] split = input.split("\\s+");
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            int ht = Integer.parseInt(split[i]);
            Student student = new Student(ht,Math.abs(ht-xiaoH));
            list.add(student);
        }
        list.sort(null);
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if (i == list.size() -1) {
                System.out.print(student.hight);
            } else {
                System.out.print(student.hight + " ");
            }
        }
        System.out.println();
    }

    static class Student implements Comparable<Student>{
        private int hight;
        private int hightCha;

        public Student() {
        }

        public Student(int hight, int hightCha) {
            this.hight = hight;
            this.hightCha = hightCha;
        }

        public int getHight() {
            return hight;
        }

        public void setHight(int hight) {
            this.hight = hight;
        }

        public int getHightCha() {
            return hightCha;
        }

        public void setHightCha(int hightCha) {
            this.hightCha = hightCha;
        }

        @Override
        public int compareTo(Student o) {
            if (this.hightCha == o.hightCha) {
                return this.hight - o.hight;
            } else {
                return this.hightCha - o.hightCha;
            }
        }
    }
}
