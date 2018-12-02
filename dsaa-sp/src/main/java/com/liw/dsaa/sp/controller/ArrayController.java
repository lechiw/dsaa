package com.liw.dsaa.sp.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @Description: (用一句话描述该文件做什么)
 * @author: Liw
 * @date: 2018/12/2 10:46
 * <p>
 */
@RestController
@RequestMapping("/array")
@Api(description = "数组")
public class ArrayController {
    @RequestMapping("/index")
    @ApiOperation(value = "数组初始化", notes = "数组初始化")
    public String index(){
        return "init array !!!" ;
    }
}
