package com.dexin;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo01 {

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
