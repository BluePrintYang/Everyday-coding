package datastructure;

public class MyStack {
    int[] element;

    public MyStack() {
        this.element = new int[0];
    }

    public void push(int n){
        int[] arr = new int[element.length+1];
        for (int i = 0; i < element.length; i++) {
            arr[i]=element[i];
        }
        arr[element.length]=n;
        element=arr;
    }

    public int pop(){
        //空
        if (element.length==0)throw new RuntimeException("stack is empty");
        //
        int res  = element[element.length-1];
        int[] arr = new int[element.length-1];
        for (int i = 0; i < element.length-1; i++) {
            arr[i]=element[i];
        }
        element=arr;
        return res;
    }

    public int peek(){
        return element[element.length-1];
    }

    public boolean isEmpty(){
        return element.length==0;
    }


}
