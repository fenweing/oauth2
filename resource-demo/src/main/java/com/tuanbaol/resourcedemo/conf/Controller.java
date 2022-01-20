package com.tuanbaol.resourcedemo.conf;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/get")
    @ApiOperation("get")
    public String get() {
        return Math.random() + "";
    }
}
