package com.didispace.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/5/23 下午4:08.
 * @blog http://blog.didispace.com
 */
public class RequestLog {

    public String requestURL;
    public String requestURI;
    public String queryString;
    public String remoteAddr;
    public String remoteHost;
    public Integer remotePort;
    public String localAddr;
    public String localName;
    public String method;

    public Map<String, String[]> parameters;
    public Map<String, String> headers;

    public String classMethod;
    public String args;

    public RequestLog(){

    }

    public RequestLog(HttpServletRequest request, JoinPoint joinPoint) {
        // 基本信息
        this.requestURL = request.getRequestURL().toString();
        this.requestURI = request.getRequestURI();
        this.queryString = request.getQueryString();
        this.remoteAddr = request.getRemoteAddr();
        this.remoteHost = request.getRemoteHost();
        this.remotePort = request.getRemotePort();
        this.localAddr = request.getLocalAddr();
        this.localName = request.getLocalName();
        this.method = request.getMethod();
        // 头信息
        this.headers = getHeadersInfo(request);
        // 参数
        this.parameters = request.getParameterMap();
        // 切入点信息
        this.classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        this.args = Arrays.toString(joinPoint.getArgs());
    }

    /**
     * 获取头部信息
     *
     * @param request
     * @return
     */
    private Map<String, String> getHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        String r;
        try {
            r = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            r = getClass() + "转换JSON失败";
        }
        return r;
    }

}
