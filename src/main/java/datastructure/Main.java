package datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yangllong
 * @DATE: 2020/7/1 16:02
 */
public class Main {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        Main a = new Main();
        ListNode head = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(5);
        ListNode g = new ListNode(5);
        head.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        a.Print(head);
        ListNode cur = a.delRepeat(head);
        a.Print(cur);
    }

    private ListNode delRepeat(ListNode head) {
        if (head == null || head.next == null) return head;
        Map<Integer, Integer> map = new HashMap<>();
        ListNode cur = head;
        while (head != null) {
            if (map.containsKey(head.val)) map.put(head.val, map.get(head.val) + 1);
            else map.put(head.val, 1);
            head = head.next;
        }

        ListNode res = new ListNode(0);
        ListNode pre = res;
        while (cur != null) {
            if (map.get(cur.val) == 1) {
                res.next = new ListNode(cur.val);
                res = res.next;
            }
            cur = cur.next;
        }
        return pre.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int v) {
            val = v;
        }


    }

    public void Print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("end");
    }
}
