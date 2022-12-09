package com.dexing.od1;

import java.util.Scanner;
import java.util.Stack;

/**
 * 向一个空栈中依次存入正整数， 假设入栈元素 n(1<=n<=2^31-1)按顺序依次为 nx…n4、 n3、n2、 n1, 每当元素入栈时，如果 n1=n2+…+ny(y 的范围[2,x]， 1<=x<=1000)，则 n1~ny 全部元素出栈，重新入栈新元素 m(m=2*n1)。
 *  如：依次向栈存入 6、 1、 2、 3, 当存入 6、 1、 2 时，栈底至栈顶依次为[6、 1、 2]；当存入 3时， 3=2+1， 3、 2、 1 全部出栈，重新入栈元素 6(6=2*3)，此时栈中有元素 6；
 *  因为 6=6，所以两个 6 全部出栈，存入 12，最终栈中只剩一个元素 12。
 *  输入描述:
 *  使用单个空格隔开的正整数的字符串，如”5 6 7 8″， 左边的数字先入栈，输入的正整数个数为 x， 1<=x<=1000。
 *  输出描述:
 *  最终栈中存留的元素值，元素值使用空格隔开，如”8 7 6 5″， 栈顶数字在左边。 6 1 2 3
 *  示例 1  输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入
 *  5 10 20 50 85 1
 *  输出
 *  1 170
 *  说明
 *  5+10+20+50=85， 输入 85 时， 5、 10、 20、 50、 85 全部出栈，入栈 170，最终依次出栈的数字为 1 和 170。
 *  示例2  输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入
 *  6 7 8 13 9
 *  输出
 *  9 13 8 7 6
 *  示例3  输入输出示例仅供调试，后台判题数据一般不包含示例
 *  输入
 *  1 2 5 7 9 1 2 2
 *  输出
 *  4 1 9 14 1
 *
 */
public class D0837Stack {
    public static Stack<Integer> num_stack = new Stack<>();

    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        //解析为int数组
        String[] nums_str_list = line.split(" ");
        int[] nums = new int[nums_str_list.length];
        for (int i = 0; i < nums_str_list.length; i++) {
            nums[i] = Integer.parseInt(nums_str_list[i]);
        }

        // 模拟入栈过程
        for (int i = 0; i < nums.length; i++) {
            push_attempt(nums[i]);
        }

        String result = "";
        while (!num_stack.empty()) {
            result += num_stack.pop() + " ";
        }
        System.out.println(result.trim());
    }

    //自定义入栈过程
    public static void push_attempt(int num) {
        int temp = 0;
        for (int i = num_stack.size() - 1; i >= 0; i--) {
            temp += num_stack.get(i);
            if (temp == num) {
                int stackSize = num_stack.size();
                for (int j = i; j < stackSize; j++) {
                    num_stack.pop();
                }
                push_attempt(temp * 2);
                return;
            } else if (temp > num) {
                break;
            }
        }
        num_stack.push(num);
    }
}
