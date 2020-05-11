package kuangshenjava.juc;

public class Test1 {
    public static void main(String[] args) {
        //获取cpu核数
        //CPU密集型，IO密集型
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
