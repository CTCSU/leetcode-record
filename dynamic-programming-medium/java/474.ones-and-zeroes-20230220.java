import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * @lc app=leetcode.cn id=474 lang=java
 * @lcpr version=21704
 *
 * [474] Ones and Zeroes
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        List<List<Integer>> countList = Stream.of(strs).map((s) -> {
            int cz = 0, co = 0;
            for (int i = 0; i < s.length(); i++) {
                if ('0' == s.charAt(i)) {
                    cz++;
                } else {
                    co++;
                }
            }

            return List.of(cz, co);
        }).collect(Collectors.toList());

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < countList.size(); i++) {
            List<Integer> countItem = countList.get(i);
            int cz = countItem.get(0), co = countItem.get(1);
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (j >= cz && k >= co) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - cz][k - co] + 1);
                    }
                }
            }
        }

        return dp[m][n];
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
 * // ["10","0001","111001","1","0"]\n5\n3\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // ["10","0","1"]\n1\n1\n
 * // @lcpr case=end
 * 
 */
