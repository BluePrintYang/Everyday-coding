package redis;

import redis.clients.jedis.Jedis;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author yangllong
 * @Date 2020/6/22 21:16
 */
public class TestPing {
    public static void main(String[] args) {
//        Jedis jedis = new Jedis("192.168.132.128",6379);
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println(jedis.ping());
    }
}
