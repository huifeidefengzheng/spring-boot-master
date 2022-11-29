package com.dexin;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo01 {

    @Test
    public void test05() {
        int line = 6;
        int tem = 0;
        while (line>0){
            int i = 1 << tem;
            line -= i;
            tem++;
        }
        System.out.println(tem);
    }

    @Test
    public void test03() {
        test();
    }
    public static void test() {
        int len = 3,indx = 0;
        if (len < 3 || len >7) {
            System.out.println(-1);
            return;
        }
        int start = 1;
        for (int i = 0; i < len-1; i++) {
            start= start*10;
        }
        int end = start *10 -1;
        int cou =0;
        while (start <= end) {
            if (checkWater(start)){
                if (cou++ == indx) {
                    System.out.println(start);
                    return;
                }
            }
            start++;
        }
        System.out.println(-1);
    }

    private static boolean checkWater(int start) {
        int temp = start;
        int target =0;
        while (temp%10 > 0) {
            int wei = temp%10;
            target += wei *wei *wei ;
            temp = temp/10;
        }
        return target == start;
    }

    @Test
    public void test01() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(6);
        List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
        list.stream().forEach(vo -> System.out.println(vo));
    }

    @Test
    public void test04() {
        String str = "0a00d";
        System.out.println(str.split("0"));
    }
    @Test
    public void test02() {
        String str = "   I   a am developer.";
        String[] split = str.split("\\s+");
        List<String> strings = Arrays.asList(split);
        List<String> strings1 = strings.subList(0, 2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("222");
        System.out.println(stringBuffer);
    }
}
