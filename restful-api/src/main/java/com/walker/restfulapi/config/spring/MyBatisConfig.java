package com.walker.restfulapi.config.spring;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;

@Configuration
@PropertySource(value ="classpath:jdbc.properties" )
public class MyBatisConfig {

    @Value("${url}")
    private String jdbcUrl;

    @Value("${driverClassName}")
    private String driverClassName;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Value("${filters}")
    private String filters;
    //最大并发连接数
    @Value("${maxActive}")
    private int maxActive;
    //初始化连接数量
    @Value("${initialSize}")
    private int initialSize;
    //配置获取连接等待超时的时间
    @Value("${maxWait}")
    private long maxWait;
    //最小空闲连接数
    @Value("${minIdle}")
    private int minIdle;
    //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
    @Value("${timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;
    //配置一个连接在池中最小生存的时间，单位是毫秒
    @Value("${minEvictableIdleTimeMillis}")
    private long minEvictableIdleTimeMillis;

    @Value("${validationQuery}")
    private String validationQuery;

    @Value("${testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${testOnReturn}")
    private boolean testOnReturn;

    @Value("${maxOpenPreparedStatements}")
    private int maxOpenPreparedStatements;
    //打开removeAbandoned功能
    @Value("${removeAbandoned}")
    private boolean removeAbandoned;
    //1800秒，也就是30分钟
    @Value("${removeAbandonedTimeout}")
    private int removeAbandonedTimeout;
    //关闭连接时输出错误日志
    @Value("${logAbandoned}")
    private boolean logAbandoned;

    @Bean(destroyMethod = "close")
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource=new DruidDataSource();
        try {
            druidDataSource.setDriverClassName(driverClassName);
            druidDataSource.setUrl(jdbcUrl);
            druidDataSource.setUsername(username);
            druidDataSource.setPassword(password);
            druidDataSource.setFilters(filters);
            druidDataSource.setMaxActive(maxActive);
            druidDataSource.setInitialSize(initialSize);
            druidDataSource.setMaxWait(maxWait);
            druidDataSource.setMinIdle(minIdle);
            druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
            druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
            druidDataSource.setValidationQuery(validationQuery);
            druidDataSource.setTestWhileIdle(testWhileIdle);
            druidDataSource.setTestOnBorrow(testOnBorrow);
            druidDataSource.setTestOnReturn(testOnReturn);
            druidDataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
            druidDataSource.setRemoveAbandoned(removeAbandoned);
            druidDataSource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
            druidDataSource.setLogAbandoned(logAbandoned);
        }catch (Exception e){
            e.printStackTrace();
        }

        return druidDataSource;
    }

    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }

}
