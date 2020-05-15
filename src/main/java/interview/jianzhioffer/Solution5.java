package interview.jianzhioffer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class Solution5 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() != 0) return stack2.pop();
        while (stack1.size() != 0) {
            stack2.push(stack1.pop());
        }
            return stack2.pop();
    }

    public static void main(String[] args) {
        Solution5 s = new Solution5();

        System.out.println(s.pop());
    }
}
