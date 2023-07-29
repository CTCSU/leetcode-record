import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=300 lang=java
 * @lcpr version=21912
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp.get(dp.size() - 1)) {
                dp.add(nums[i]);
            } else {
                updateDp(dp, nums[i]);
            }

        }

    }

    private void updateDp(List<Integer> dp, int i) {
        int l = 0, r = dp.size() - 1;
        while(l <= r) {
            int mid = l + (int)Math.floor((r-l)/2);
            if()
        }

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [10,9,2,5,3,7,101,18]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [0,1,0,3,2,3]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [7,7,7,7,7,7,7]\n
 * // @lcpr case=end
 * 
 */
