import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=416 lang=java
 * @lcpr version=21914
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;

        boolean[] canReach = new boolean[half + 1];
        canReach[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > half) {
                return false;
            } else if (nums[i] == half) {
                return true;
            } else {
                for (int j = half; j >= 1; j--) {
                    if (nums[i] <= j) {
                        canReach[j] = canReach[j - nums[i]] || canReach[j];
                    }
                }
            }
        }
        System.out.println(Arrays.toString(canReach));

        return canReach[half];

    }
}
// @lc code=end

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
