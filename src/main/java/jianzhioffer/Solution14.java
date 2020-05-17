package jianzhioffer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        //我想到的解法，先遍历链表获取长度，然后找到长度-k位置即可
       /* ListNode temp = head;
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        if (k > length || length == 0) return null;

        for (int i = 0; i < length - k; i++) {
            temp = temp.next;
        }
        return temp;*/

        //快慢双指针法
        if (head==null||k<=0)return null;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k-1; i++) {
            if (fast==null)return null;
            fast=fast.next;
        }
        if (fast==null)return null;
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
