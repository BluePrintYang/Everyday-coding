package interview.jianzhioffer;

/**
 * 输入一个链表，反转链表后，输出新链表的表头
 */
public class Solution15 {
    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = null;
        ListNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode t = new ListNode(1);
        t.next = new ListNode(2);
        t.next.next = new ListNode(3);
        t.next.next.next = new ListNode(4);
        System.out.println("" + t.val + t.next.val + t.next.next.val + t.next.next.next.val);
        ListNode s = ReverseList(t);
        System.out.println("" + s.val + s.next.val + s.next.next.val + s.next.next.next.val);
    }
}
