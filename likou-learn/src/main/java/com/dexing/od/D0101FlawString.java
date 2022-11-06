package com.dexing.od;

import java.util.*;

public class D0101FlawString {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("e", 1);
        map.put("i", 1);
        map.put("o", 1);
        map.put("u", 1);
        Scanner scanner = new Scanner(System.in);
        int flaw = Integer.parseInt(scanner.nextLine());
        String str = scanner.nextLine();
        int left = 0, count = 0;
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String s = String.valueOf(c).toLowerCase(Locale.ROOT);
            boolean isYuan = map.containsKey(s);
            // 字符串起始位从i开始，首位不是元音字符的跳过
            if (!isYuan) {
                count++;
            }
            //
            if (count < flaw || !isYuan) {
                continue;
            }
            //
            if (count == flaw && !map.containsKey(str.charAt(i + 1))) {
                String substring = str.substring(left, i + 1);
                strings.add(substring);
                left++;
            }
            if (count > flaw) {

            }
            //
        }

    }

    public static void test2() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 要求出现的瑕疵数
            int flaw = Integer.parseInt(sc.nextLine());
            // 输入字符串
            String input = sc.nextLine().toLowerCase(Locale.ROOT);
            String str = "aeiou";
            // 统计最大值
            int max = 0;
            for (int i = 0; i < input.length(); i++) {
                // 字符串起始位从i开始，首位不是元音字符的跳过
                if (!str.contains("" + input.charAt(i))) {
                    continue;
                }
                Stack<Character> stack = new Stack<>();
                // 统计当前瑕疵个数
                int current = 0;
                for (int j = i; j < input.length(); j++) {
                    char c = input.charAt(j);
                    stack.push(c);
                    if (!str.contains("" + c)) {
                        current++;
                        if (current > flaw) {
                            // 清栈，从0开始统计
                            stack.clear();
                            current = 0;
                        }
                    }
                    // 瑕疵数必须符合要求，最后一个元素必须是元音字符,
                    if (!stack.isEmpty() && current == flaw && str.contains("" + stack.peek())) {
                        max = Math.max(max, stack.size());
                    }
                }
            }
            System.out.println(max);
        }
    }
}
