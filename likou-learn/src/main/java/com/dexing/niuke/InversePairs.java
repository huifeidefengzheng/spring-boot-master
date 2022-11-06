package com.dexing.niuke;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P mod 1000000007
 */
public class InversePairs {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(array));
    }


    public static int InversePairs(int [] array) {
        int length = array.length;
        int P = 0;
        for(int i = 0; i < length - 1; i++){
            for(int j = i + 1; j < length; j++){
                if(array[i] > array[j]){
                    P++;
                }
            }
        }
        int chushu = 1000000007;
        return P%chushu;
    }
}
