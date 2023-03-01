import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=300 lang=java
 * @lcpr version=21704
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);

        for (int i = 0; i < nums.length; i++) {
            if (dp.get(dp.size() - 1) < nums[i]) {
                dp.add(nums[i]);
            } else {
                updateDp(dp, nums[i]);
            }
        }

        return dp.size();

    }

    private void updateDp(List<Integer> dp, int target) {
        int l = 0, r = dp.size() - 1;
        int ans = r;
        while (l <= r) {
            int mid = l + (int) Math.floor((r - l) / 2);
            if (dp.get(mid) >= target) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }

        dp.set(ans, target);
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
