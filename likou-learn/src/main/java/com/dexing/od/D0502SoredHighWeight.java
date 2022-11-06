package com.dexing.od;

import java.util.*;

/**
 * 某学校举行运动会,学生们按编号（1、2、3…n)进行标识现需要按照身高由低到高排列，对身高相同的人，按体重由轻到重排列，对于身高体重都相同的人，维持原有的编号顺序关系。
 * 请输出排列后的学生编号
 * 输入描述：
 * 
 * 两个序列，每个序列由N个正整数组成，(0<n<=100)。
 * 第一个序列中的数值代表身高
 * 第二个序列中的数值代表体重
 * 输出描述：
 * 
 * 排列结果，每个数值都是原始序列中的学生编号，编号从1开始，身高从低到高，身高相同体重从轻到重，体重相同维持原来顺序。
 * 示例：
 * 
 * 输入：
 * 
 * 4
 * 100 100 120 130
 * 40 30 60 50
 * 输出：
 * 
 * 2134
 * 输入：
 * 
 * 3
 * 90 110 90
 * 45 60 45
 * 输出：
 * 
 * 132
 */
public class D0502SoredHighWeight {
    public static void main(String[] args) {
        test02();
    }

    public static void test01() {
        int stuNum = 4;
        String[] h = {"100", "100", "120", "130"};
        String[] w = {"40", "30", "60", "50"};

        HashMap<Integer, Student> map = new HashMap<>();
        for (int i = 0; i < h.length; i++) {
            Student student = new Student(i + 1);
            student.setHigt(Integer.parseInt(h[i]));
            map.put(i + 1, student);
        }
        for (int i = 0; i < w.length; i++) {
            Student student = map.get(i + 1);
            student.setWeight(Integer.parseInt(w[i]));
        }
        for (int i = 0; i < stuNum; i++) {
            for (int j = stuNum - 1; j > i; j--) {
                if (map.get(j + 1).getHigt() < map.get(j).getHigt()) {
                    Student student = map.get(j + 1);
                    map.put(j + 1, map.get(j));
                    map.put(j, student);
                } else if (map.get(j + 1).getHigt() == map.get(j).getHigt()) {
                    if (map.get(j + 1).getWeight() < map.get(j).getWeight()) {
                        Student student = map.get(j + 1);
                        map.put(j + 1, map.get(j));
                        map.put(j, student);
                    }
                }
            }
        }
        for (int i = 0; i < stuNum; i++) {
            System.out.print(map.get(i + 1).getId());
        }

    }

    public static void test02() {
        int[] h = {90, 110, 90};
        int[] w = {45, 60, 45};

        PriorityQueue<Student> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getHigt() == o2.getHigt()) {
                return o2.getWeight() - o1.getWeight();
            }
            return o2.getHigt() - o1.getHigt();
        });
        for (int i = 0; i < 3; i++) {
            Student student = new Student(i + 1);
            student.setHigt(h[i]);
            student.setWeight(w[i]);
            queue.offer(student);
        }
        queue.forEach(vo -> System.out.print(vo.getId()));
    }

    public static void test3() {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        String[] high = sc.nextLine().split(" ");
        String[] weight = sc.nextLine().split(" ");
        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            playerList.add(new Player(i+1,Integer.parseInt(high[i]),Integer.parseInt(weight[i])));
        }
        Collections.sort(playerList);
        for (int i = 0; i < playerList.size(); i++) {
            System.out.print(playerList.get(i).idx+" ");
        }
    }


    static class Player implements Comparable<Player>{
        private int idx;
        private int high;
        private int weight;

        public Player(int idx, int high, int weight) {
            this.idx = idx;
            this.high = high;
            this.weight = weight;
        }

        @Override
        public int compareTo(Player ply) {
            if (ply.high > this.high){
                return -1;
            }
            if (ply.weight > this.weight){
                return -1;
            }
            if (ply.idx > this.idx){
                return -1;
            }
            return 0;
        }
    }
}
