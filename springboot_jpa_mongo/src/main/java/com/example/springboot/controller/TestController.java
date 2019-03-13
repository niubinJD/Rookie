package com.example.springboot.controller;

import com.example.springboot.ConfigBean;
import com.example.springboot.ReturnData;
import com.example.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @Autowired
    ConfigBean configBean;

    @Autowired
    TestService service; // 依赖注入

    @Value("${test.config}")
    private  String testConfig; // 绑定配置项

    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public String getConfig(){
        return configBean.getUsername();
    }


    @RequestMapping(value = "/tests", method = RequestMethod.GET)
    public ReturnData getAllTests() {

        return  new ReturnData(service.getAll(), 200);
    }

    @RequestMapping(value = "/list/", method = RequestMethod.GET)
    public ReturnData getTestsByPage(@RequestParam(required=true) int currentPage, @RequestParam(required=true) int pageSize) {
        return new ReturnData(service.getThePage(currentPage, pageSize), 200);
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ReturnData getTestByName(@RequestParam(required=false, defaultValue="小明") String name) {
        return  new ReturnData(service.findOne(name), 200);
    }

    @RequestMapping(value = "/errorText", method = RequestMethod.GET)
    public ReturnData testExecption() throws Exception {
        throw new Exception("全局异常处理");
//        return  new ReturnData(null, 200);
    }
}
