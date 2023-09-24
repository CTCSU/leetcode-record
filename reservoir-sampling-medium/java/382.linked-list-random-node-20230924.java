import java.util.Random;

/*
 * @lc app=leetcode.cn id=382 lang=java
 * @lcpr version=21914
 *
 * [382] Linked List Random Node
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    ListNode head;
    Random random = new Random();

    public Solution(ListNode head) {
        this.head = head;

    }

    public int getRandom() {

        int count = 1;
        ListNode result = head;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            if (random.nextInt(++count) == 0) {
                result = cur;
            }
        }

        return result.val;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
// @lc code=end
