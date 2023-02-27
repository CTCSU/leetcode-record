/*
 * @lc app=leetcode.cn id=215 lang=java
 * @lcpr version=21704
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {

    private int findInRecursion(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }

        int il = l, ir = r;
        int random = l + (int) Math.floor(Math.random() * (r - l));
        swap(nums, il, random);
        int mark = nums[il];
        while (l < r) {
            while (nums[r] < mark && l < r) {
                r--;
            }
            while (nums[l] >= mark && l < r) {
                l++;
            }
            swap(nums, l, r);
        }
        swap(nums, il, r);

        if (r == k - 1) {
            return nums[r];
        } else if (r < k - 1) {
            return findInRecursion(nums, r + 1, ir, k);
        } else {
            return findInRecursion(nums, il, l - 1, k);
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public int findKthLargest(int[] nums, int k) {
        return findInRecursion(nums, 0, nums.length - 1, k);

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
 * // [3,2,1,5,6,4]\n2\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [3,2,3,1,2,4,5,5,6]\n4\n
 * // @lcpr case=end
 * 
 */
