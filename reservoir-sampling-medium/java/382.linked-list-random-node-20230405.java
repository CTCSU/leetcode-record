import java.util.Random;

/*
 * @lc app=leetcode.cn id=382 lang=java
 * @lcpr version=21801
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
        int val = head.val;
        ListNode node = head.next;
        int count = 1;
        while (null != node) {
            if (random.nextInt(++count) == 0)
                val = node.val;
            node = node.next;
        }

        return val;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
// @lc code=end

// @lcpr-div-debug-arg-start
// funName=
// paramTypes= []
// returnType=
// @lcpr-div-debug-arg-end
