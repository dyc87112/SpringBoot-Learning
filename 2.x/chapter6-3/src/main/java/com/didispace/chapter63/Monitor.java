package com.didispace.chapter63;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.influxdb.InfluxDB;
import org.influxdb.dto.Point;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by 程序猿DD on 2021/8/2.
 * <p>
 * Blog: http://blog.didispace.com/
 * Github: https://github.com/dyc87112/
 */
@Service
@AllArgsConstructor
@Slf4j
public class Monitor {

    private InfluxDB influxDB;

    @Scheduled(fixedRate = 5000)
    public void writeQPS() {
        // 模拟要上报的统计数据
        int count = (int) (Math.random() * 100);

        Point point = Point.measurement("ApiQPS")     // ApiQPS表
                .tag("url", "/hello")  // url字段
                .addField("count", count)        // 统计数据
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)  // 时间
                .build();

        // 往test库写数据
        influxDB.write("test", "autogen", point);

        log.info("上报统计数据：" + count);
    }

}
