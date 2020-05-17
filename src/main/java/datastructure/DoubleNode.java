package datastructure;

public class DoubleNode {
    DoubleNode pre=this;
    DoubleNode next=this;
    int date;

    public DoubleNode(int date) {
        this.date = date;
    }

    //增加结点
    public void after(DoubleNode node){
        DoubleNode nextNode = next;
        this.next=node;
        node.pre=this;
        node.next=nextNode;
        nextNode.pre=node;
    }

    public DoubleNode next(){
        return this.next;
    }

    public DoubleNode pre(){
        return this.pre;
    }

    public int getData() {
        return date;
    }
}
