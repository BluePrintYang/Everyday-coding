package jianzhioffer;

/**
 * 连续子数组的最大和
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和.(子向量的长度至少是1)
 */
public class Solution30Star连续子数组的最大和 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length==0)return 0;
        int[] dp = new int[array.length];
        dp[0]=array[0];
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            int newMax = dp[i]+dp[i-1];
            if (newMax>dp[0])dp[i]=newMax;
            else dp[i]=array[i];
            if (dp[i]>max)max=dp[i];
        }
        return max;
    }

    public int maxSubArray (int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }

            max = Math.max(dp[i],max);
        }
        return max;
    }


    public int FindGreatestSumOfSubArray2(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] += Math.max(array[i - 1], 0);
            max = Math.max(max, array[i]);
        }
        return max;
    }
}
