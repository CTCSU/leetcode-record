
/*
 * @lc app=leetcode.cn id=435 lang=java
 *
 * [435] 无重叠区间
 */

// @lc code=start
class Solution {
    private int[][] intervals;

    // public static void main(String[] args) {
    // Solution solution = new Solution();
    // int[][] parameter = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
    // System.out.println(solution.eraseOverlapIntervals(parameter));
    // }

    public int eraseOverlapIntervals(int[][] intervals) {
        this.intervals = intervals;
        // Util.printTwoDimensions(intervals);
        quickSort(0, intervals.length - 1);
        // Util.printTwoDimensions(intervals);

        int lastIndex = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= lastIndex) {
                count++;
                lastIndex = intervals[i][1];
            }
        }

        return intervals.length - count;
    }

    private void quickSort(int l, int r) {
        if (l >= r) {
            return;
        }
        int random = (l + r) / 2;
        swap(l, random);
        int initalL = l, initialR = r;
        int mark = intervals[l][1];
        while (l < r) {
            while (intervals[r][1] > intervals[initalL][1] && l < r) {
                r--;
            }
            while (intervals[l][1] <= mark && l < r) {
                l++;
            }
            swap(l, r);
        }
        swap(initalL, l);
        quickSort(initalL, l - 1);
        quickSort(r + 1, initialR);
    }

    private void swap(int a, int b) {
        int[] temp = intervals[a];
        intervals[a] = intervals[b];
        intervals[b] = temp;
    }

}
// @lc code=end
