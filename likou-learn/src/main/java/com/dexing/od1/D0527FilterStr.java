package com.dexing.od1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 *  数字0、1、2、3、4、5、6、7、8、9分别关联 a~z 26个英文字母。
 *  0 关联 "a","b","c"
 *  1 关联 "d","e","f"
 *  2 关联 "g","h","i"
 *  3 关联 "j","k","l"
 *  4 关联 "m","n","o"
 *  5 关联 "p","q","r"
 *  6 关联 "s","t"
 *  7 关联 "u","v"
 *  8 关联 "w","x"
 *  9 关联 "y","z"
 *  例如7关联"u","v"，8关联"x","w"，输入一个字符串例如“78”，
 *  和一个屏蔽字符串“ux”,那么“78”可以组成多个字符串例如：“ux”，“uw”，“vx”，“vw”，过滤这些完全包含屏蔽字符串的每一个字符的字符串，然后输出剩下的字符串。
 *  示例
 *  输入：
 *  78
 *  ux
 *  输出：
 *  uw vx vw
 *  说明：ux完全包含屏蔽字符串ux，因此剔除
 */
public class D0527FilterStr {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        HashMap<Integer, List<String>> map = new HashMap<>();
        initData(map);
        char[] chars = "78".toCharArray();
        String input = "ux";
        ArrayList<List<String>> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            int anInt = Integer.parseInt(String.valueOf(chars[i]));
            List<String> strings = map.get(anInt);
            list.add(strings);
        }
        List<String> tem = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            List<String> strings = list.get(i);
            ArrayList<String> list1 = new ArrayList<>();
            for (int j = 0; j < tem.size(); j++) {
                for (int k = 0; k < strings.size(); k++) {
                    String s = tem.get(j) +strings.get(k);
                    if (input.contains(s)) {
                        continue;
                    }
                    list1.add(s);
                }
            }
            tem = list1;
        }
        tem.stream().forEach(vo -> System.out.print(vo));
        System.out.println();
    }

    private static void initData(HashMap<Integer, List<String>> map) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        map.put(0, list1);
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("d");
        list2.add("e");
        list2.add("f");
        map.put(1, list2);
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("g");
        list3.add("h");
        list3.add("i");
        map.put(2, list3);
        ArrayList<String> list4 = new ArrayList<>();
        list4.add("j");
        list4.add("k");
        list4.add("l");
        map.put(3, list4);
        ArrayList<String> list5 = new ArrayList<>();
        list5.add("m");
        list5.add("n");
        list5.add("o");
        map.put(4, list5);
        ArrayList<String> list6 = new ArrayList<>();
        list6.add("p");
        list6.add("q");
        list6.add("r");
        map.put(5, list6);
        ArrayList<String> list7 = new ArrayList<>();
        list7.add("s");
        list7.add("t");
        map.put(6, list7);
        ArrayList<String> list8 = new ArrayList<>();
        list8.add("u");
        list8.add("v");
        map.put(7, list8);
        ArrayList<String> list9 = new ArrayList<>();
        list9.add("w");
        list9.add("x");
        map.put(8, list9);
        ArrayList<String> list10 = new ArrayList<>();
        list10.add("y");
        list10.add("z");
        map.put(9, list10);
    }
}
