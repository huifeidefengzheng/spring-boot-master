package com.dexing.od1;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 【租车骑绿岛】100分 部门组织绿岛骑行团建活动。租用公共双人自行车，每辆自行车最多坐两人，做最大载重M。 给出部门每个人的体重，请问最多需要租用多少双人自行车。
 输入描述： 第一行两个数字m、n，分别代表自行车限重，部门总人数。
 第二行，n个数字，代表每个人的体重，体重都小于等于自行车限重m。
 0 < m <=200 0<n<=1000000 输出描述： 最小需要的双人自行车数量。
 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例 输入
 3 4
 3 2 2 1
 输出
 3
 */
public class D0213ZuBike {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String[] split = "3 5".split("\\s+");
        String[] split1 = "3 2 2 2 1".split("\\s+");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        int count = 0 ,couM = 0 ,tem = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int anInt = Integer.parseInt(split1[i]);
            Integer orDefault = map.getOrDefault(anInt, 0);
            orDefault++;
            map.put(anInt,orDefault);
        }
        for (int i = 0; i < n; i++) {
            int anInt = Integer.parseInt(split1[i]);
            int i1 = m - anInt;
            if (i1 == 0) {
                Integer integer = map.get(anInt);
                if (integer-1 >= 0) {
                    count++;
                    map.put(anInt,integer-1);
                }
                continue;
            }
            if (map.containsKey(i1) && map.get(i1) != 0 && map.get(anInt) != 0) {
                Integer integer = map.get(i1);
                Integer ani = map.get(anInt);
                int i2 = integer - 1;
                int i3 = ani - 1;
                if (i2 >= 0){
                    map.put(i1,i2);
                    count++;
                }
                if (i3 >= 0 ) {
                    map.put(anInt,i3);
                }
            }
        }
        long count1 = map.values().stream().map(v -> v != 0).count();
        if (count1 == 0) {
            System.out.println(count);
        } else {
            System.out.println(count+count1);
        }
    }
}
