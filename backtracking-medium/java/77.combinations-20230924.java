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
    List<List<Integer>> result = new ArrayList<>();
    int n, k;

    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;

        recursion(1);

        return result;

    }

    private void recursion(int cur) {
        if (cur > n) {
            return;
        }
        temp.add(cur);
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
        } else if (k - temp.size() <= n - cur) {
            recursion(cur + 1);
        }
        temp.remove(temp.get(temp.size() - 1));
        recursion(cur + 1);
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
