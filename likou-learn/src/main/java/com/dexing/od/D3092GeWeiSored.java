package com.dexing.od;

import java.util.ArrayList;

/**
 * 给定一个非空数组（列表），其元素数据类型为整型，请按照数组元素十进制最低位从小到大进行排序，十进制最低位相同的元素，相对位置保持不变。
 * 当数组元素为负值时，十进制最低位等同于去除符号位后对应十进制值最低位。
 * 输入描述:
 * 给定一个非空数组，其元素数据类型为32位有符号整数，数组长度[1, 1000]
 * 输出描述:
 * 输出排序后的数组
 * 示例1
 * 输入
 * 1,2,5,-21,22,11,55,-101,42,8,7,32
 * 输出
 * 1,-21,11,-101,2,22,42,32,5,55,7,8
 *
 */
public class D3092GeWeiSored {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String[] split = "1,2,5,-21,22,11,55,-101,42,8,7,32".split(",");
        ArrayList<IntStr> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(new IntStr(Integer.parseInt(split[i]), i));
        }
        list.sort(null);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNum() +",");
        }

    }

    static class IntStr implements Comparable<IntStr> {
        private int num;
        private int index;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public IntStr() {
        }

        public IntStr(int num, int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(IntStr o) {
            if (this.num == o.num) {
                return this.index - o.index;
            } else {
                return Math.abs(this.num) % 10 - Math.abs(o.num) % 10;
            }
        }
    }
}
