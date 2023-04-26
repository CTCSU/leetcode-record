import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 * @lcpr version=21801
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    int n;
    int k;

    List<List<Integer>> result = new ArrayList<>();

    private void backTrace(int c, List<Integer> list) {
        if (list.size() == k) {
            result.add(List.copyOf(list));
            return;
        }

        if (c > n) {
            return;
        }

        list.add(c);
        backTrace(c + 1, list);
        list.remove(list.size() - 1);
        backTrace(c + 1, list);
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backTrace(1, new ArrayList<>());
        return result;
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
 * // 4\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // 1\n1\n
 * // @lcpr case=end
 * 
 */
