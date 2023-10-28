import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 * @lcpr version=30102
 *
 * [23] Merge k Sorted Lists
 */

// @lcpr-template-start

// @lcpr-template-end
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
    public ListNode mergeKLists(ListNode[] list) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((t1, t2) -> t1.val - t2.val);

        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.offer(node);
            }
        }

        ListNode head = new ListNode();
        ListNode current = head;

        while (!priorityQueue.isEmpty()) {

            ListNode temp = priorityQueue.poll();
            current.next = temp;
            current = current.next;
            if (null != current.next) {
                priorityQueue.offer(current.next);
            }
        }

        return head.next;

    }
}
// @lc code=end

/*
 * // @lcpr case=start
 * // [[1,4,5],[1,3,4],[2,6]]\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // []\n
 * // @lcpr case=end
 * 
 * // @lcpr case=start
 * // [[]]\n
 * // @lcpr case=end
 * 
 */
