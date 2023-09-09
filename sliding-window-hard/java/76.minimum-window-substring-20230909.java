import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=76 lang=java
 * @lcpr version=21913
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int[] all = new int[128];
        Arrays.fill(all, -s.length());
        int hasCount = 0;
        for (int i = 0; i < t.length(); i++) {
            int x = t.charAt(i);

            if (all[x] == -s.length()) {
                all[x] = 0;
                hasCount++;
            }
            all[x]++;
        }

        int l = 0, r = 0;
        int lIndex = Integer.MIN_VALUE, length = Integer.MAX_VALUE;
        while (r < s.length()) {
            int x = s.charAt(r);
            all[x]--;
            if (all[x] == 0) {
                hasCount--;
            }

            while (hasCount == 0) {
                int y = s.charAt(l);
                if (all[y] == 0) {
                    hasCount++;
                    if (r - l < length) {
                        lIndex = l;
                        length = r - l;
                    }
                }
                l++;
                all[y]++;
            }

            r++;
        }

        return length == Integer.MAX_VALUE ? "" : s.substring(lIndex, lIndex + length + 1);
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "ADOBECODEBANC"\n"ABC"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "a"\n"a"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "a"\n"aa"\n
 * // @lcpr case=end
 * 
 */
