package interview.designpattern.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) throws IOException {
        Properties p = new Properties();
        InputStream in = TestProperties.class.getResourceAsStream("FactoryTest.properties");
        System.out.println(TestProperties.class.getResource("").getPath());
        System.out.println(in==null);
        p.load(in);
        in.close();
        String s = p.getProperty("ImplA");
        System.out.println(s);
    }
}
