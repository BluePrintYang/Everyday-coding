package leetcode;

import java.util.LinkedList;


/**
 * 2020.3.1
 * 用队列实现栈
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 */
public class Solution225 {

    private LinkedList<Integer> list;

    /** Initialize your data structure here. */
    public Solution225() {
        list =  new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        list.add(x);
        int sz = list.size();
        while (sz>1){
            list.add(list.remove());
            sz--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return list.remove();
    }

    /** Get the top element. */
    public int top() {
        if (!list.isEmpty()) return list.peek();
        return -1;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.isEmpty();
    }

    public static void main(String[] args) {
        Solution225 s = new Solution225();
        s.push(2);
        int p = s.pop();
        int p2 = s.top();
        boolean t = s.empty();
        System.out.println(p);
    }
}

