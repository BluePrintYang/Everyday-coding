package others;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Scanner;

public class TestJson {
    public static void main(String[] args) {
        String json = "{\"location\":{\"soak\":\"0\",\"address\":\"浙江大学紫金港校区\",\"city\":\"杭州\",\"name\":\"test1\",\"lon\":\"120.082463\",\"lat\":\"30.302093\"}}";
        JSONObject jsonObject = JSON.parseObject(json);
        JSONObject object = (JSONObject) jsonObject.get("location");
        System.out.println("location"+jsonObject.get("location"));
        System.out.println("value:"+object);
        System.out.println("name:"+object.get("name"));
        System.out.println(jsonObject);
    }

}