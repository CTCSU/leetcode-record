/*
 * @lc app=leetcode.cn id=10 lang=java
 * @lcpr version=21913
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {

        int m = s.length(), n = p.length();
        boolean[][] matched = new boolean[m + 1][n + 1];
        matched[0][0] = true;
        for (int j = 0; j < n; j++) {
            if (p.charAt(j) == '*') {
                matched[0][j + 1] = matched[0][j - 1];
            }
        }

        for (int i = 1; i <= m; i++) {
            char sc = s.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                if (pc == sc || pc == '.') {
                    matched[i][j] = matched[i - 1][j - 1];
                } else if (pc == '*') {
                    char lpc = p.charAt(j - 2);
                    if (lpc == '.' || lpc == sc) {
                        matched[i][j] = matched[i - 1][j] || matched[i][j - 2];
                    } else {
                        matched[i][j] = matched[i][j - 2];
                    }
                }
            }
        }

        return matched[m][n];
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // "aa"\n"a"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "aa"\n"a*"\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // "ab"\n".*"\n
 * // @lcpr case=end
 * 
 */
