package com.feri.feridataweb.redis;

import com.feri.feridataweb.common.SystemConst;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Jedis_Main {
    public static void main(String[] args) {
        //1、创建对象
//        JedisPool jedisPool=new JedisPool(SystemConst.RHOST,SystemConst.RPORT);
//        Jedis jedis1=jedisPool.getResource();
        Jedis jedis=new Jedis(SystemConst.RHOST,SystemConst.RPORT);
        //2、认证

        jedis.auth("root");
        //3、操作
        //string
        jedis.set("2018","加油");
        System.out.println(jedis.get("2018"));
        //list
        jedis.lpush("水果","香蕉","苹果","橘子","梨");
        System.out.println(jedis.lrange("水果",0,jedis.llen("水果")));
        //4、关闭
        jedis.close();

    }
}
