package interview.jianzhioffer;


public  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        ListNode l = this;
        StringBuilder s = new StringBuilder();
        while (l!=null){
            s.append(l.val);
            l=l.next;
            if (l!=null) s.append("->");
        }
        return s.toString();
    }

    public static void main(String[] args) {
        ListNode s = new ListNode(2);
        ListNode s1 =s;
        s.next=new ListNode(3);
        s.next.next=new ListNode(4);
        s=s.next;
        System.out.println(s.val);
        System.out.println(s1.val);
        System.out.println(s.toString());
    }
}