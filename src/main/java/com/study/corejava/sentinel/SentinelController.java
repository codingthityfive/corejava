package com.study.corejava.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sen")
public class SentinelController {

    private static final String key= "sayhello";

    @RequestMapping("say")
    @ResponseBody
    @SentinelResource(value = key, blockHandler = "blockHandlerMethod", fallback = "queryGoodsInfoFallback" ,fallbackClass = SentinelController.class)
    public String sayHello(){
        return "hello";
    }

    //异常处理
    public static String blockHandlerMethod( BlockException e) {
//        log.warn("queryGoodsInfo222 blockHandler", e.toString());
        System.out.println("queryGoodsInfo222 blockHandler"+e.toString());
        return "queryGoodsInfo error, blockHandlerMethod res: " ;

    }

    //降级处理
    public static String queryGoodsInfoFallback(String spuId, Throwable e) {
//        log.warn("queryGoodsInfo222 fallback", e.toString());
        System.out.println("queryGoodsInfo222 fallback"+e.toString());
        return "queryGoodsInfo error, return fallback res: " + spuId;
    }
//    @PostConstruct
//    public void initDegradeRule() {
//        List<DegradeRule> rules = new ArrayList<>();
//        DegradeRule rule = new DegradeRule();
//        rule.setResource(key);
//        // 80s内调用接口出现异常次数超过5的时候, 进行熔断
//        rule.setCount(5);
//        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
//        rule.setTimeWindow(80);
//        rules.add(rule);
//        DegradeRuleManager.loadRules(rules);
//    }
}
