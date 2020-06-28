package jianzhioffer;

/**
 * @Author yangllong
 * @Date 2020/5/31 20:51
 * 删除链表中重复结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Solution56删除链表中重复结点 {
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode cur = new ListNode(0);
        ListNode pre = cur;

        //头结点的val值
        int val = pHead.val;

        //遍历链表
        while (pHead.next != null) {

            //后面结点为空，直接跳出循环

            //下一个结点与当前结点val值相同，跳到下一个不同的结点
            if (pHead.next.val == val) {
                pHead = pHead.next.next;
                if (pHead == null) break;
                while (pHead.val == val) {
                    pHead = pHead.next;
                    if (pHead == null) break;
                }
                //当前结点已经为空，跳出循环
                if (pHead == null) break;
                //不为空，设置新val值
            }
            //否则添加当前结点到cur
            else {
                cur.next = new ListNode(pHead.val);
                cur = cur.next;
                pHead = pHead.next;
            }
            val = pHead.val;

        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(1);
        node.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next.next = new ListNode(1);
        System.out.println(node.toString());
        System.out.println(deleteDuplication(node).toString());
    }
}
