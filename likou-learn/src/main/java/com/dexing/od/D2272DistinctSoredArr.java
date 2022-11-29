package com.dexing.od;

import java.util.*;

public class D2272DistinctSoredArr {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        String[] split = "1,3,3,3,2,4,4,4,5".split(",");
        Map<Integer,Integer> map = new HashMap<>();
        List<Order> list = new ArrayList<>();
        int idxInList = 0;
        for (int i = 0; i < split.length; i++) {
            int value = Integer.parseInt(split[i]);
            Order order = new Order(i,value,1);
            if (list.contains(order)){
                int idx = map.get(value);
                list.get(idx).count++;
            }else {
                map.put(value,idxInList++);
                list.add(order);
            }
        }
        list.sort(null);//能把下标重排吗？
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).value + ",");
        }

    }
    private static class Order implements Comparable<Order>{
        private int idx;//出场顺序
        private int value;
        private int count;

        public Order(int idx ,int value, int count) {
            this.idx = idx;
            this.value = value;
            this.count = count;
        }

        @Override
        public boolean equals(Object obj) {
            Order order = (Order) obj;
            return order.value == this.value;
        }

        @Override
        public int compareTo(Order order) {
            if (order.count != this.count){
                return order.count - this.count;
            }else {
                return this.idx - order.idx ;
            }
        }
    }
}
