package interview.designpattern.factory;

public class ImplB implements Api {
    @Override
    public void operation(String s) {
        System.out.println("In ImplB s is "+s);
    }
}
