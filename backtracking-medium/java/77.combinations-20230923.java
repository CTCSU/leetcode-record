import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 * @lcpr version=21914
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    private int k;
    private int n;

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.addAll(recursion(temp, i));
        }

        return result;

    }

    private List<List<Integer>> recursion(List<Integer> temp, int i) {
        List<List<Integer>> result = new ArrayList<>();
        temp.add(i);
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int j = i + 1; j <= n; j++) {
                if (n - j + 1 >= k - temp.size()) {
                    result.addAll(recursion(temp, j));
                }
            }
        }
        temp.remove(temp.get(temp.size() - 1));
        return result;
    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // 4\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 1\n1\n
 * // @lcpr case=end
 * 
 */
