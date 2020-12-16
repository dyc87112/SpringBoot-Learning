package com.didispace.chapter42;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String index(ModelMap map) {
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

}