package com.dexing.od1;

import java.util.Stack;

public class D0108DeePKuoHao {
    public static void main(String[] args) {
        test();
    }

    private static void deal(char[] chars) {
        Stack<Character> stack = new Stack<>();
        int deep_max = 0;
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(aChar);
                deep_max = Math.max(stack.size(), deep_max);
                continue;
            }

            if (stack.size() == 0) {
                System.out.println(0);
                return;
            }

            Character character = stack.pop();

            if (aChar == ')') {
                if (character == '(') {
                    continue;
                }
                System.out.println(0);
                return;
            }

            if (aChar == ']') {
                if (character == '[') {
                    continue;
                }
                System.out.println(0);
                return;
            }

            if (aChar == '}') {
                if (character == '{') {
                    continue;
                }
                System.out.println(0);
                return;
            }
        }

        System.out.println(stack.size() == 0 ? deep_max : 0);
    }

    public static void test() {
        char[] chars = ")(".toCharArray();
        Stack<Character> stack = new Stack<>();
        int deeep =0;
        boolean pu = true;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(' ||c == '{' ||c == '[') {
                stack.push(c);
                pu = true;
            } else {
                if (pu) {
                    deeep = 0;
                }
                if (stack.size() != 0) {
                    Character peek = stack.peek();
                    if (c == ')' && peek == '(') {
                        deeep++;
                        stack.pop();
                        pu =false;
                    }
                    if (c == ']' && peek == '[') {
                        deeep++;
                        stack.pop();
                        pu =false;
                    }
                    if (c == '}' && peek == '{') {
                        deeep++;
                        stack.pop();
                        pu =false;
                    }
                } else {
                    deeep=0;
                }
            }
        }
        if (stack.size() != 0) {
            System.out.println(0);
            return;
        } else {
            System.out.println(deeep);
        }
    }
}
