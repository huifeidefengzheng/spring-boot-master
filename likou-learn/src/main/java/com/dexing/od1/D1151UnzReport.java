package com.dexing.od1;

import java.util.Scanner;
import java.util.Stack;

/**
 *  为了提升数据传输的效率，会对传输的报文进行压缩处理。 输入一个压缩后的报文，请返回它解压后的原始报文。 
 *  压缩规则：n[str]，表示方括号内部的 str 正好重复 n 次。 
 *  注意 n 为正整数（0 < n <= 100），str只包含小写英文字母，不考虑异常情况。
 *  
 *  输入描述: 
 *  输入压缩后的报文： 
 *  1）不考虑无效的输入，报文没有额外的空格，方括号总是符合格式要求的； 
 *  2）原始报文不包含数字，所有的数字只表示重复的次数 n ，例如不会出现像 5b 或 3[8] 的输入； 
 *  输出描述: 
 *  解压后的原始报文 
 *  注： 
 *  1）原始报文长度不会超过1000，不考虑异常的情况 
 *  示例 1 
 *  输入输出示例仅供调试，后台判题数据一般不包含示例 
 *  输入 
 *  3[k]2[mn] 
 *  输出 
 *  kkkmnmn 
 *  说明 
 *  k 重复3次，mn 重复2次，最终得到 kkkmnmn 
 *  1：遍历字符串的同时保持原先的状态，由于还有嵌套的结构，因此想到了使用栈这个数据结构。 
 *  2：四种情况需要考虑 
 *  数字
 *  字母
 *  [ 符号
 *  ] 符号
 *  
 *  输入输出示例仅供调试，后台判题数据一般不包含示例 
 *  输入 
 *  3[m2[c]] 
 *  输出 
 *  mccmccmcc 
 *  说明 
 *  m2[c] 解压缩后为 mcc，重复三次为 mccmccmcc 
 */
public class D1151UnzReport {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        //初始化一个栈
        Stack<Character> stack = new Stack<>();
        String resStr = "";
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ']') {
                // 解压缩
                String tmpStr = "";
                while(!stack.isEmpty()) {
                    char pop_char = stack.pop();
                    //小写字母
                    if (pop_char >= 'a' && pop_char <= 'z') {
                        tmpStr = String.valueOf(pop_char) + tmpStr;
                        //数字
                    } else if (Character.isDigit(pop_char)) {
                        int num = 0;
                        if (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                            num = (stack.pop() - '0') * 10 + (pop_char - '0');
                        } else {
                            num = pop_char - '0';
                        }
                        String waitStr = tmpStr;
                        for (int j = 0; j < num - 1; j++) {
                            tmpStr += waitStr;
                        }
                    }
                }
                resStr += tmpStr;
            }
            stack.push(ch[i]);
        }
        System.out.println(resStr);
    }
}
