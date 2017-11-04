package com.walker.restfulapi.config.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * spring与redis整合
 */
@Configuration
@PropertySource(value = "classpath:redis.properties")
public class RedisConfig {

    @Value("${redis.node1.maxTotal}")
    private Integer redisMaxTotal;

    @Value("${redis.node1.host}")
    private String redisNode1Host;

    @Value("${redis.node1.port}")
    private Integer redisNode1Port;


    private JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisMaxTotal);
        return jedisPoolConfig;
    }

    @Bean
    public ShardedJedisPool shardedJedisPool() {
        List<JedisShardInfo> jedisShardInfos = new ArrayList<>();
        jedisShardInfos.add(new JedisShardInfo(redisNode1Host, redisNode1Port));
        //....添加更多

        return new ShardedJedisPool(jedisPoolConfig(), jedisShardInfos);
    }


}
