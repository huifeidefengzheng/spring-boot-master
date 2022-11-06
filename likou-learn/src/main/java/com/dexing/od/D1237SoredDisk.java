package com.dexing.od;

import java.util.*;

public class D1237SoredDisk {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Scanner scanner = new Scanner(System.in);
        int diskNum = 3;
        String[] stsr = {"2G4M","3M2G","1T"};
        ArrayList<String> integers = new ArrayList<>();
        ArrayList<Disk> disks = new ArrayList<>();
        for (int i = 0; i < diskNum; i++) {
            String s = stsr[i];
            int diskM = 0;
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (Character.isDigit(c)) {
                    stack.push(c - '0');
                } else if ("G".equals(c+"")){
                    String str = "";
                    while (!stack.isEmpty()) {
                        Integer pop = stack.pop();
                        str = pop + str;
                    }
                    diskM = Integer.parseInt(str)*1024 + diskM;
                } else if ("T".equals(c+"")) {
                    String str = "";
                    while (!stack.isEmpty()) {
                        Integer pop = stack.pop();
                        str = pop +str;
                    }
                    diskM = Integer.parseInt(str) *1024*1024 + diskM;
                } else if ("M".equals(c+"")) {
                    String str = "";
                    while (!stack.isEmpty()) {
                        Integer pop = stack.pop();
                        str = pop +str;
                    }
                    diskM = Integer.parseInt(str) + diskM;
                }
            }
            integers.add(s);
            disks.add(new Disk(i,diskM));
        }
        Collections.sort(disks);
        disks.stream().forEach(vo -> System.out.println(integers.get(vo.getId())));
    }

    static class Disk implements Comparable<Disk>{
        private int id;
        private int con;

        public Disk(int id, int con) {
            this.id = id;
            this.con = con;
        }

        public Disk() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCon() {
            return con;
        }

        public void setCon(int con) {
            this.con = con;
        }

        @Override
        public int compareTo(Disk o) {
            if (this.getCon() == o.getCon()) {
                return 0;
            }
            return this.getCon() - o.getCon();
        }
    }
}
