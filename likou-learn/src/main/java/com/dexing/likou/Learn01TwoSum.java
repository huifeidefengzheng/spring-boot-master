package com.dexing.likou;

import java.util.HashMap;

public class Learn01TwoSum {
    public static void main(String[] args) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        integerIntegerHashMap.put(1,2);
        System.out.println(integerIntegerHashMap.get(1));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (integerIntegerHashMap.containsKey(target - nums[i])) {
                return new int[]{integerIntegerHashMap.get(target - nums[i]),i};
            }
            integerIntegerHashMap.put(nums[i],i);
        }
        return new int[0];
    }


    public int findLUSlength(String a, String b) {

        return 0;
    }
}
