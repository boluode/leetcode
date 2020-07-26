package com.boluo.leetcode.newcode.offer;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Jz50 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int length = 10;
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = new Random().nextInt(length);
        }
        int[] duplication = new int[1];

        boolean result = solution.duplicate(numbers, length, duplication);

        System.out.println(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
        if(result) {
            System.out.println(Arrays.stream(duplication).boxed().collect(Collectors.toList()));
        }
    }

    public static class Solution {
        // Parameters:
        //    numbers:     an array of integers
        //    length:      the length of array numbers
        //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
        //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
        //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
        // Return value:       true if the input is valid, and there are some duplications in the array number
        //                     otherwise false
        public boolean duplicate(int numbers[],int length,int [] duplication) {

            if(numbers == null || numbers.length == 0) {
                return false;
            }

            int[] nums = new int[length];
            for (int i = 0; i < numbers.length; i++) {

                int number = numbers[i];
                if(nums[number] == 0) {
                    nums[number] = 1;
                } else {
                    duplication[0] = number;
                    return true;
                }
            }
            return false;
        }
    }
}
