import redis.clients.jedis.Jedis;

import java.util.HashSet;
import java.util.Set;

public class RedisCheck {
    private static final String REDIS_SCORE_CHECK_KEY = "rjia:test:";

    public static void main(String[] args) {
        addItem(10, "Alibaba");
        addItem(9, "Tencent");
        addItem(8, "Baidu");
        addItem(7, "HuaWei");
        addItem(6, "Netease");

        Set<String> set = getAllItems();
        System.out.println(set);

        try (Jedis jedis = new Jedis("localhost")) {
            System.out.println("------" + jedis.zscore(REDIS_SCORE_CHECK_KEY, "Alibaba"));
//            jedis.zadd(REDIS_SCORE_CHECK_KEY, 99, "Alibaba");
//            System.out.println("------" + jedis.zscore(REDIS_SCORE_CHECK_KEY, "Alibaba"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Set<String> getAllItems() {
        try (Jedis jedis = new Jedis("localhost")) {
            return jedis.zrevrange(REDIS_SCORE_CHECK_KEY, 0, -1);
        } catch (Exception e) {
            e.printStackTrace();
            return new HashSet<>();
        }
    }

    public static void addItem(double score, String item) {
        try (Jedis jedis = new Jedis("localhost")) {
            jedis.zadd(REDIS_SCORE_CHECK_KEY, score, item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(String item) {
        try (Jedis jedis = new Jedis("localhost")) {
            jedis.zrem(REDIS_SCORE_CHECK_KEY, item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
