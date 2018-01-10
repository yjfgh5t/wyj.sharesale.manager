package wyx.manager.rest.controller;

import org.jeecgframework.p3.core.web.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ShareIconController extends BaseController {



    @RequestMapping("/test")
    public String Test(){
        return  "测试";
    }
}
