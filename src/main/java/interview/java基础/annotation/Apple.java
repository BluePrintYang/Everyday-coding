package interview.java基础.annotation;


/*注解使用*/
public class Apple {
    @FruitProvider(id=1,name = "江苏红富士集团",address = "江苏南京")
    private String appleProvider;

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
}
