package foundation.lambda;

public class TestLambda {
    public static void main(String[] args) {

        //1.引用类方法
        Converter c = Integer::valueOf;
        //等同于上面的语句
//        Converter c = from -> Integer.valueOf(from);
        Integer val = c.convert("99");
        System.out.println(val);

        //2.引用特定对象的实例方法
        Converter d = "likeIt.org"::indexOf;
        //等同于下面的语句
//        Converter d = from -> "likeIt.org".indexOf(from);
        Integer value = d.convert("It");
        System.out.println(value);

    }
}
