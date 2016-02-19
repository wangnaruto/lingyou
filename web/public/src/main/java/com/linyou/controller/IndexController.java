package com.linyou.controller;

import com.linyou.model.Bean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shuli on 16/2/17.
 */
@Slf4j
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/index.html")
    public String index(){

        Bean bean = new Bean();
        bean.setStr("");

        log.info("xsxxxx");

        return "";
    }
}
