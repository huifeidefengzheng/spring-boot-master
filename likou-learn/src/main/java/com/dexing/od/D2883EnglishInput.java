package com.dexing.od;

import java.util.*;


/**
 * 主管期望你来实现英文输入法单词联想功能。需求如下：
 * 依据用户输入的单词前缀，从已输入的英文语句中联想出用户想输入的单词，按字典序输出联想到的单词序列，如果联想不到，请输出用户输入的单词前缀。
 * 注意：
 * 英文单词联想时，区分大小写
 * 缩略形式如”don’t”，判定为两个单词，”don”和”t”
 * 输出的单词序列，不能有重复单词，且只能是英文单词，不能有标点符号
 * 输入描述:
 * 输入为两行。
 * 首行输入一段由英文单词word和标点符号组成的语句str；
 * 接下来一行为一个英文单词前缀pre。
 * 0 < word.length() <= 20
 * 0 < str.length <= 10000
 * 0 < pre <= 20
 * 输出描述:
 * 输出符合要求的单词序列或单词前缀，存在多个时，单词之间以单个空格分割
 * 示例1
 * 输入
 * I love you
 * He
 * 输出
 * He
 * 说明
 * 从用户已输入英文语句”I love you”中提炼出“I”、“love”、“you”三个单词，接下来用户输入“He”，从已输入信息中无法联想到任何符合要求的单词，因此输出用户输入的单词前缀。
 * 示例2
 * 输入
 * The furthest distance in the world, Is not between life and death, But when I stand in front of you, Yet you don’t know that I love you.
 * f
 * 输出
 * front furthest
 * 说明
 * 从用户已输入英文语句”The furthest distance in the world, Is not between life and death, But when I stand in frontof you, Yet you dont know that I love you.”中提炼出的单词，符合“f”作为前缀的，有“furthest”和“front”，按字典序排序并在单词间添加空格后输出，结果为“front furthest”。
 */
public class D2883EnglishInput {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        //Scanner sc = new Scanner(System.in);
        String input = "The furthest distance fin fin the world, Is not between life and death, But when I stand in front of you, Yet you don’t know that I love you.";
        String target = "f";
        List<String> list = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || ( ch>= 'A' && ch<= 'Z') ){
                word.append(ch);
            }else {
                list.add(word.toString());
                word = new StringBuilder();
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).startsWith(target)) {
                res.add(list.get(i));
            }
        }
        Collections.sort(res);
        String tem = "";
        if (res.size() > 0){
            for (int i = 0; i < res.size(); i++) {
                String s = res.get(i);
                if (s.equals(tem)) {
                    continue;
                }
                System.out.print(res.get(i) + " ");
                tem = s;
            }
            System.out.println();
        }else {
            System.out.println(target);
        }
    }

    public static void test() {
        String word = "The furthest distance fin fin the world, Is not between life and death, But when I stand in front of you, Yet you don’t know that I love you.";
        String pre = "f";
        String[] strings = word.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            if (string.startsWith(pre)) {
                list.add(string);
            }
        }
        if (list.size() ==0) {
            System.out.println(pre);
        } else {
            outPut(list);
        }
        System.out.println();
    }

    private static void outPut(ArrayList<String> list) {
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        String tem = "";
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (tem.equals(s)) {
                continue;
            }
            if (i == list.size() -1) {
                System.out.print(list.get(i));
            } else {
                System.out.print(list.get(i) + " ");
            }
            tem = s;
        }
    }
}
