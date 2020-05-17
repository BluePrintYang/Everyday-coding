package datastructure;


public class TestMyStack {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());


    }
}
