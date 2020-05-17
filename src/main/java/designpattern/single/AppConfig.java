package designpattern.single;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    private String paraA;
    private String paraB;

    public String getParaA() {
        return paraA;
    }

    public String getParaB() {
        return paraB;
    }

    public AppConfig() throws IOException {
        readConfig();
    }

    private void readConfig() throws IOException {
        Properties p =new Properties();
        InputStream in = null;
        in=AppConfig.class.getClassLoader().getResourceAsStream("Test.properties");
        p.load(in);
        this.paraA=p.getProperty("a");
        this.paraB=p.getProperty("b");
        in.close();
    }

    public static void main(String[] args) throws IOException {
        AppConfig a = new AppConfig();

        System.out.println(a.getParaA());
    }
}
