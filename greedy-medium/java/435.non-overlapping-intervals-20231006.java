import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=435 lang=java
 * @lcpr version=21917
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int last = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (cur[0] < last) {
                count++;
            } else {
                last = cur[1];
            }
        }

        return count;

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,2],[2,3],[3,4],[1,3]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,2],[1,2],[1,2]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[1,2],[2,3]]\n
 * // @lcpr case=end
 * 
 */
