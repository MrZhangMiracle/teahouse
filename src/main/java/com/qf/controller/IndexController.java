package com.qf.controller;


import com.qf.dto.IndexDto;
import com.qf.service.IndexSeekService;
import com.qf.vo.LayuiR;
import com.qf.vo.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "茶小屋 首页相关接口")
@RestController
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private IndexSeekService seekService;

    /*//输入框模糊查询
    @PostMapping("/query")
    public LayuiR indexSeek(String goods_name
            ,@RequestParam(defaultValue = "1") int pageNo
            ,@RequestParam(defaultValue = "10") int pageSize) {

        return seekService.indexSeek(goods_name, pageNo,pageSize);
    }*/
    @ApiOperation(value = "模糊查询")
    @GetMapping("/query")
    public R indexSeek(String goods_name) {
        R r = seekService.indexSeek(goods_name);
        return r;
    }

    @ApiOperation(value = "根据品牌展示商品")
    @GetMapping("/indexByBrand")
    public R indexByBrand(int goods_brand){
        R r = seekService.indexByBrand(goods_brand);
        return r;
    }

    @ApiOperation(value = "根据品种展示商品")
    @GetMapping("/indexByVariety")
    public R indexByVariety(String goods_variety) {
        R r = seekService.indexByVariety(goods_variety);

        return r;
    }

    @ApiOperation(value = "根据价格区间显示商品")
    @GetMapping("/indexByPrice")
    public R indexByPrice(int low_price, int high_price){
        R r = seekService.indexByPrice(low_price, high_price);
        return r;
    }
}
