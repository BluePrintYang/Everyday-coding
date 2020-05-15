package interview.foundation.hashmap;



public class TestMyHashMap {
    public static void main(String[] args) {
        MyMap<String,String> map = new MyHashMap();
        for (int i = 0;i<100;i++){
            map.put("yll"+i,"yll"+i);
            System.out.println(map.get("yll"+i));
        }
        System.out.println(map.size());
        /*TestMyHashMap t = new TestMyHashMap();
        String a = "100";
        int b = 100;
        System.out.println("对象的hashcode为：" + t.hashCode());
        System.out.println("整数100的hashcode为：" + Integer.hashCode(b));
        System.out.println("字符串100的hashcode为：" + a.hashCode());*/
    }
}
