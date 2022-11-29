package com.dexing.od1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *  题目描述
 *  求单向链表中间的节点值，如果奇数个节点取中间，偶数个取偏右边的那个值。
 *  输入描述：
 *  第一行 链表头节点地址path 后续输入的节点数n
 *  后续输入每行表示一个节点，格式: &nbsp; "节点地址 &nbsp;节点值 &nbsp;下一个节点地址(-1表示空指针)“
 *  输入保证链表不会出现环，并且可能存在一些节点不属于链表。
 *  输出描述：
 *  链表中间节点值。
 *  测试用例:
 *  输入:
 *  00010 4
 *  00000 3 -1
 *  00010 5 12309
 *  11451 6 00000
 *  12309 7 11451
 *  输出:
 *  6
 */
public class D0420LinkList {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String[] split = "00010 4".split("\\s+");
        String first = split[0];
        int n = Integer.parseInt(split[1]);

        Map<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<LinkD> arrayList = new ArrayList<>();
        iniData(map);
        // 剔除无效列表
        while (!first.equals("-1")) {
            ArrayList<String> list = map.get(first);
            arrayList.add(new LinkD(first,Integer.parseInt(list.get(0))));
            first = list.get(1);
        }

        int mid =  arrayList.size() /2;
        System.out.println(arrayList.get(mid).getValue());



    }

    static class LinkD{
        private String path;
        private Integer value;

        public LinkD() {
        }

        public LinkD(String path, Integer value) {
            this.path = path;
            this.value = value;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }

    private static void iniData(Map<String, ArrayList<String>> map) {
        String[] split1 = "00000 3 -1".split("\\s+");
        ArrayList<String> list = new ArrayList<>();
        list.add(split1[1]);
        list.add(split1[2]);
        map.put(split1[0],list );

        String[] split2 = "00010 5 12309".split("\\s+");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add(split2[1]);
        list2.add(split2[2]);
        map.put(split2[0],list2);

        String[] split3 = "11451 6 00000".split("\\s+");
        ArrayList<String> list3 = new ArrayList<>();
        list3.add(split3[1]);
        list3.add(split3[2]);
        map.put(split3[0],list3);

        String[] split4 = "12309 7 11451".split("\\s+");
        ArrayList<String> list4 = new ArrayList<>();
        list4.add(split4[1]);
        list4.add(split4[2]);
        map.put(split4[0],list4);

    }
}
