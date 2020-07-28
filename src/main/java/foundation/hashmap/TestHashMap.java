package foundation.hashmap;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 15; i++) {
            map.put("aa"+i+"bb"+(9-i),":"+i);
        }
        int count = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {

            System.out.println(entry.getKey()+entry.getValue());
            count++;
        }
        System.out.println("======lambda====");
        map.forEach((key,value)->{
            System.out.print(key);
            System.out.println(value);
        });
        System.out.println(count);
        System.out.println(map.size());
    }
}
