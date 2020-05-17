package designpattern.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) throws IOException {
        Properties p = new Properties();
        InputStream in = TestProperties.class.getClassLoader().getResourceAsStream("Test.properties");
        p.load(in);
        in.close();
        String s = p.getProperty("a");
        System.out.println(s);
    }
}
