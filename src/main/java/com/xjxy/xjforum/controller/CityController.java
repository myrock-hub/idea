package com.xjxy.xjforum.controller;

import com.xjxy.xjforum.entity.City;
import com.xjxy.xjforum.service.CityServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;


import java.util.List;

@RestController("/city")
public class CityController {
    @Autowired
    CityServiceImpl cityService;

    @ApiOperation(value="按id查询城市信息")
    @ResponseBody
    @RequestMapping("/queryCityList")
    public String queryCityList(@RequestParam("id") int id)  {
        List<City> queryCityList = cityService.queryCityList(id);
        String jsonString = JSON.toJSONString(queryCityList);
        return  jsonString;
    }

    @ApiOperation(value="查询全部城市信息")
    @ResponseBody
    @RequestMapping("/findAll")
    public String findAll()  {
        List<City> cityList = cityService.findAll();
        String jsonString = JSON.toJSONString(cityList);
        return  jsonString;
    }
}
