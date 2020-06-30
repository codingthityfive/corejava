package com.study.corejava.aopjiangji;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yaml.snakeyaml.util.UriEncoder;

import java.net.URLEncoder;

@Controller
@RequestMapping("/aoptest")
public class TestCOntroller {
    @Autowired
    private TestService testService;

    @RequestMapping("/te")
    @ResponseBody
    public String test(){



        testService.test();

        return "1111";
    }
}
