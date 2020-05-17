package designpattern.factory;

public class ImplA implements Api {
    @Override
    public void operation(String s) {
        System.out.println("In ImplA s is "+s);
    }
}
