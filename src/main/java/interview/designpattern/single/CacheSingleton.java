package interview.designpattern.single;

import java.util.HashMap;
import java.util.Map;

/**
 * 缓存实现单例模式
 */
public class CacheSingleton {

    private final static String DEFAULT_KEY = "One";

    private static Map<String,CacheSingleton> map = new HashMap<>();

    private CacheSingleton(){}

    public static CacheSingleton getInstance(){
        CacheSingleton instance = map.get(DEFAULT_KEY);
        if (instance==null){
            instance=new CacheSingleton();
            map.put(DEFAULT_KEY,instance);
        }
        return map.get(DEFAULT_KEY);
    }

}
