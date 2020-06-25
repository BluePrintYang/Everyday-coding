package foundation;

public interface IFoo {
    default void bar(int i){
        System.out.println("interface function bar(int)");
    }
}
