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

    private ListNode head;
    Random random = new Random();

    public Solution(ListNode head) {
        this.head = head;
    }

    public int getRandom() {

        int count = 1;
        var current = head;
        var result = head.val;
        while (current.next != null) {
            current = current.next;
            count++;
            if (random.nextInt(count) == 0) {
                result = current.val;
            }
        }
        return result;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
// @lc code=end
