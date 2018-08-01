package com.didispace;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import com.guard.stone.redis.DefaultCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: zhangshiwan
 * @Date: 2018/7/31 20:07
 * @Description:
 * 通过设置redis各个项目的各个日志根节点日志级别，来动态切换日志级别
 * 比如：
 *  1、连接redis，设置"Logback:level:tradecenter:com.sport"=info
 *  2、扫描任务可以设置扫描间隔，默认一秒执行一次，读取redis值设置日志接入点日志级别
 *  3、redis key规则 "Logback:level:"+ applicationName + ":"+loggerName;
 */
public class DynamicChangeLogByRedis {
    private static Logger logger = LoggerFactory.getLogger(DynamicChangeLogByRedis.class);

    /**
     * 扫描时间间隔 毫秒
     */
    private int scanPeriod = 1000;
    /**
     * 要设置的日志根
     * 比如：com.sport、java.sql
     */
    private List<String> loggerNames;

    /**
     * 项目名称 ，比如 tradecenter
     */
    private String applicationName;

    @Resource
    private DefaultCacheManager defaultCacheManager;


    @PostConstruct
    private void init(){
        Thread thread  = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (CollectionUtils.isEmpty(loggerNames)){
                        loggerNames = new ArrayList<>();
                    }

                    for (String loggername : loggerNames){
                        String logLevel = defaultCacheManager.getObject(getRedisPrex(applicationName,loggername));
                        if (StringUtils.isEmpty(logLevel)){
                            continue;
                        }
                        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
                        loggerContext.getLogger(loggername).setLevel(Level.valueOf(logLevel));
                    }

                } catch (Exception e) {
                    logger.error("动态修改日志级别出错", e);
                }
            }
        });


        ScheduledThreadPoolExecutor scheduleAtFixedRate = new ScheduledThreadPoolExecutor(1);
        // 延时 1 秒后，按 scanPeriod 秒的周期执行任务
        scheduleAtFixedRate.scheduleAtFixedRate(thread, 1000, scanPeriod, TimeUnit.MILLISECONDS);

    }

    private String getRedisPrex(String applicationName,String loggerName){
        return "Logback:level:"+ applicationName + ":"+loggerName;
    }


    public int getScanPeriod() {
        return scanPeriod;
    }

    public void setScanPeriod(int scanPeriod) {
        this.scanPeriod = scanPeriod;
    }

    public List<String> getLoggerNames() {
        return loggerNames;
    }

    public void setLoggerNames(List<String> loggerNames) {
        this.loggerNames = loggerNames;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public DefaultCacheManager getDefaultCacheManager() {
        return defaultCacheManager;
    }

    public void setDefaultCacheManager(DefaultCacheManager defaultCacheManager) {
        this.defaultCacheManager = defaultCacheManager;
    }
}
