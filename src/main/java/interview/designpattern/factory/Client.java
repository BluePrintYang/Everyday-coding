package interview.designpattern.factory;


public class Client {
    public static void main(String[] args) {
        Api api1 = Factory.getApi();
        Api api2 = Factory.getApi();
        api1.operation("test");
        api2.operation("test");
    }
}
