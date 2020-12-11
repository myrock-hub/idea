package com.xjxy.xjforum.controller;

import com.xjxy.xjforum.entity.City;
import com.xjxy.xjforum.service.CityServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSON;


import java.util.List;

@RestController("/city")
public class CityController {
    @Autowired
    CityServiceImpl cityService;

    @ApiOperation(value="按id查询城市信息")
    @ResponseBody
    @GetMapping("/queryCityList")
    public String queryCityList(@RequestParam("id") int id)  {
        List<City> queryCityList = cityService.queryCityList(id);
        String jsonString = JSON.toJSONString(queryCityList);
        return  jsonString;
    }

    @ApiOperation(value="查询全部城市信息")
    @ResponseBody
    @GetMapping("/findAllByPage")
    public String findAll(@RequestParam("page") int page,@RequestParam("size") int size)  {
        Page<City> cityList = cityService.findAlllist(page,size);
        String jsonString = JSON.toJSONString(cityList);
        return  jsonString;
    }
}
