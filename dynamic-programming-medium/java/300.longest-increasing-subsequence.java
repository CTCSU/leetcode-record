import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    // public static void main(String[] args) {
    // Solutionc c = new Solutionc();
    // int[] nums = { 0, 1, 0, 3, 2, 3 };
    // System.out.println(c.lengthOfLIS(nums));
    // }

    public int lengthOfLIS(int[] nums) {
        List<Integer> sequence = new LinkedList<>();
        sequence.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (sequence.get(sequence.size() - 1) < nums[i]) {
                sequence.add(nums[i]);
            } else {
                int size = sequence.size();
                int l = 0, r = size - 1;
                int ans = -1;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (nums[i] <= sequence.get(mid)) {
                        ans = mid;
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                if (ans != -1) {
                    sequence.set(ans, nums[i]);
                }
            }
        }

        return sequence.size();
    }
}
// @lc code=end
