import java.util.Arrays;
import java.util.stream.Stream;

/*
 * @lc app=leetcode.cn id=416 lang=java
 * @lcpr version=21704
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int redundant = sum % 2;
        if (0 != redundant) {
            return false;
        }

        int m = nums.length;
        int half = sum / 2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = half; j > 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }

        return dp[half];
    }
}
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end

/*
 * // @lcpr case=start
 * // [1,5,11,5]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,2,3,5]\n
 * // @lcpr case=end
 * 
 */
