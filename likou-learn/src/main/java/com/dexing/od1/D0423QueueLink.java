package com.dexing.od1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


/**
 *  给定一个队列，但是这个队列比较特殊，可以从头部添加数据，也可以从尾部添加数据，但是只能从头部删除数据。输入一个数字n，会依次添加数字1~n（也就是添加n次）。
 *  但是在添加数据的过程中，也会删除数据，要求删除必须按照1~n按照顺序进行删除，所以在删除时，可以根据需要调整队列中数字的顺序以满足删除条件。
 *  输入描述：
 *  第一行一个数据N，表示数据的范围。
 *  接下来的2N行是添加和删除语句。其中：head add x 表示从头部添加元素 x，tail add 表示从尾部添加元素，remove表示删除元素。
 *  输出描述：
 *  输出一个数字，表示最小的调整顺序次数。
 *  示例：
 *  5
 *  head add 1
 *  tail add 2
 *  remove
 *  head add 3
 *  tail add 4
 *  head add 5
 *  remove
 *  remove
 *  remove
 *  remove
 *  输出：
 *  1
 *  说明：
 *  第1步：[1]
 *  第2步：[1,2]
 *  第3步：头部删除1，无需调整，还剩[2]
 *  第4步：[3,2]
 *  第5步：[3,2,4]
 *  第6步：[5,3,2,4]
 *  第7步：头部删除2，调整顺序再删除，还剩[3，4，5]
 *  第8步：头部删除3，无需调整，还剩[4，5]
 *  第9步：头部删除4，无需调整，还剩[5]
 *  第10步：头部删除5，无需调整
 *  只需要调整1次
 *
 */
public class D0423QueueLink {
    public static void main(String[] args) {
        test();
    }

    public static void test2() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<String> arrayList = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            if (s.contains("head add")) {
                String s1 = s.split("\\s+")[2];
                arrayList.add(0,s1);
            }
            if (s.contains("tail add")) {
                String s1 = s.split("\\s+")[2];
                arrayList.add(s1);
            }
            if (s.equals("remove") && arrayList.size()>0) {
                res = removeFirst(arrayList);
            }
        }
        System.out.println(res);
    }

    public static void test() {
        int input = 5;
        ArrayList<String> list = new ArrayList<>();
        intData(list);
        ArrayDeque<Integer> integers = new ArrayDeque<>();
        ArrayList<String> arrayList = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < input*2; i++) {
            String s = list.get(i);
            if (s.contains("head add")) {
                String s1 = s.split("\\s+")[2];
                arrayList.add(0,s1);
            }
            if (s.contains("tail add")) {
                String s1 = s.split("\\s+")[2];
                arrayList.add(s1);
            }
            if (s.equals("remove") && arrayList.size()>0) {
                res = removeFirst(arrayList);
            }

        }
        System.out.println(res);
    }
    
    public static Integer removeFirst(ArrayList<String> arrayList) {
        List<String> tem = arrayList;
        int count =1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            list.add(Integer.parseInt(arrayList.get(i)));
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size()-1; j++) {
                Integer integer = list.get(j);
                Integer integer1 = list.get(j + 1);
                if (integer > integer1) {
                    list.set(j+1,integer);
                    list.set(j,integer1);
                    count++;
                }
            }
        }
        arrayList.remove(String.valueOf(list.get(0)));
        return count;
    }

    private static void intData(ArrayList<String> list) {
        list.add("head add 1");
        list.add("tail add 2");
        list.add("remove");
        list.add("head add 3");
        list.add("tail add 4");
        list.add("head add 5");
        list.add("remove");
        list.add("remove");
        list.add("remove");
        list.add("remove");
    }
}
