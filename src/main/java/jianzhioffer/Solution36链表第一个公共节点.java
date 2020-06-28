package jianzhioffer;

/**
 * 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class Solution36链表第一个公共节点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p2 = pHead2;
        while (pHead1 != null) {
            while (pHead2 != null) {
                if (pHead1.val == pHead2.val) return pHead1;
                pHead2 = pHead2.next;
            }
            pHead2 = p2;
            pHead1 = pHead1.next;
        }
        return null;
    }
}
