package designpattern.factory;


public class Client {
    public static void main(String[] args) {
        Api api1 = Factory.getApi("ImplA");
        Api api2 = Factory.getApi("ImplB");
        api1.operation("testA");
        api2.operation("testB");
    }
}
