import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=448 lang=java
 * @lcpr version=21801
 *
 * [448] Find All Numbers Disappeared in an Array
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= nums.length; i++) {
            set.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            set.remove(nums[i]);
        }

        return new ArrayList<>(set);
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
 * // [4,3,2,7,8,2,3,1]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [1,1]\n
 * // @lcpr case=end
 * 
 */
