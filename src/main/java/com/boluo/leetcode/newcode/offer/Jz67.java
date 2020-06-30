package com.boluo.leetcode.newcode.offer;

/**
 * 题目描述
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
 * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class Jz67 {

    public static void main(String[] args) {
        System.out.println(cutRope(8));
    }

    public static int cutRope(int target) {

        if(target < 2) {
            return 0;
        }
        if(target == 2) {
            return 1;
        }
        if(target == 3) {
            return 2;
        }
        int[] result = new int[target + 1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        for (int i = 4; i <= target; i++) {

            int max = 0;
            for (int j = 1; j <= i / 2; j++) {

                max = Math.max(max, result[j] * result[i - j]);
            }
            result[i] = max;
        }
        return result[target];
    }
}
