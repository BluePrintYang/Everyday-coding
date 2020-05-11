package leetcode;

/**
 * 2020.3.2
 * 反转链表
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class Solution206 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode currTemp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = currTemp;
        }
        return pre;
    }
}
