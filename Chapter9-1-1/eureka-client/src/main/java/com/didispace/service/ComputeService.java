package com.didispace.service;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/5/30 下午3:48.
 * @blog http://blog.didispace.com
 */
@FeignClient(serviceId = "computeService", url = "http://COMPUTE-SERVICE/")
public interface ComputeService {

    @RequestLine("GET /add")
    Integer add(@Param("a") Integer a, @Param("b") Integer b);

}
