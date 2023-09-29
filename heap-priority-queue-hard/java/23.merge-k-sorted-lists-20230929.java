/*
 * @lc app=leetcode.cn id=23 lang=java
 * @lcpr version=21917
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {

        Queue<ListNode> queue = new PriorityQueue<>((t1, t2) -> t1.val - t2.val);

        for (ListNode listNode : lists) {
            if (null != listNode) {
                queue.offer(listNode);
            }
        }

        ListNode head = new ListNode();
        ListNode dump = head;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            head.next = node;
            head = head.next;
            if (null != head.next) {
                queue.offer(head.next);
            }
        }
        return dump.next;

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
