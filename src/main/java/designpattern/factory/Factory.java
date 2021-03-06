package designpattern.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 通过配置文件获取类
 */
public class Factory {
    public static Api getApi(String s) {
        Properties p = new Properties();
        InputStream in =  Factory.class.getClassLoader().getResourceAsStream("FactoryTest.properties");
        try {
            p.load(in);
        } catch (IOException e) {
            System.out.println("装载工厂配置文件出错了，具体的堆栈信息如下：");
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Api api = null;

        try {
            api = (Api) Class.forName(p.getProperty(s)).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return api;
    }
}
