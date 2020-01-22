package com.didispace.web;

import org.springframework.web.bind.annotation.*;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/5/19 下午1:27.
 * @blog http://blog.didispace.com
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

}
