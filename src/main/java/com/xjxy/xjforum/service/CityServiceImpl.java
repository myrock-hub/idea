package com.xjxy.xjforum.service;

import com.xjxy.xjforum.dao.CityDao;
import com.xjxy.xjforum.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl {
    @Autowired
    private CityDao cityDao;

    public City findByCityName(String cityName){
        City city = cityDao.findByName(cityName);
        return city;
    }

    public List<City> queryCityList(int id){
        List<City> list = cityDao.queryCityList(id);
        if (list!=null) {
            return list;
        }
        else {
            return null;
        }
    }
    public Page<City> findAlllist(int page ,int size){
        Pageable pageable = PageRequest.of(page-1,size);
        Page<City> list = cityDao.findAlllist(pageable);
        return list;
    }
}
