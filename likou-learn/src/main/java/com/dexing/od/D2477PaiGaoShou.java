package com.dexing.od;

import java.util.ArrayList;


/**
 * 给定一个长度为n的整型数组，表示一个选手在n轮内可选择的牌面分数。选手基于规则选牌，请计算所有轮结束后其可以获得的最高总分数。选择规则如下：
 * 1、在每轮里选手可以选择获取该轮牌面，则其总分数加上该轮牌面分数，为其新的总分数。
 * 2、选手也可不选择本轮牌面直接跳到下一轮，此时将当前总分数还原为3轮前的总分数，若当前轮次小于等于3（即在第1、2、3轮选择跳过轮次），则总分数置为0。
 * 3、选手的初始总分数为0，且必须依次参加每一轮。
 * 输入描述:
 * 第一行为一个小写逗号分割的字符串，表示n轮的牌面分数，1<= n <=20。
 * 分数值为整数，-100 <= 分数值 <= 100。
 * 不考虑格式问题。
 * 输出描述:
 * 所有轮结束后选手获得的最高总分数。
 * 示例1
 * 输入
 * 1,-5,-6,4,3,6,-2
 * 输出
 * 11
 * 说明
 * 总共有7轮牌面。
 * 第一轮选择该轮牌面，总分数为1。
 * 第二轮不选择该轮牌面，总分数还原为0。
 * 第三轮不选择该轮牌面，总分数还原为0。
 * 第四轮选择该轮牌面，总分数为4。
 * 第五轮选择该轮牌面，总分数为7。
 * 第六轮选择该轮牌面，总分数为13。
 * 第七轮如果不选择该轮牌面，则总分数还原到3轮1前分数，即第四轮的总分数4，如果选择该轮牌面，总分数为11，所以选择该轮牌面。
 * 因此，最终的最高总分为11。
 */
public class D2477PaiGaoShou {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        String inputStr = "1,-5,-6,4,3,6,-2";
        String[] split = inputStr.split(",");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        int num = 0;
        if (list.size() <= 3) {
            num = getThree(list,list.size());
            System.out.println(num);
            return;
        } else {
            num = getThree(list,3);
        }
        int tem = num;
        for (int i = 3; i < list.size(); i++) {
            Integer integer = list.get(i);
            if (integer> 0){
                tem += integer;
            } else {
                if (tem +integer > num) {
                    tem += integer;
                } else {
                    tem = num;
                }
            }
        }

        System.out.println(tem);



    }

    private static int getThree(ArrayList<Integer> list,int len) {
        int num = 0;
        for (int i = 0; i < len; i++) {
            Integer integer = list.get(i);
            if (integer> 0){
                num+=integer;
            } else {
                num =0;
            }
        }
        return num;
    }
}
