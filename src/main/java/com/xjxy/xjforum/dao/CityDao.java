package com.xjxy.xjforum.dao;

import com.xjxy.xjforum.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CityDao extends PagingAndSortingRepository<City, Long>, JpaSpecificationExecutor<City> {

    @Query("from City t where Name = :Name")
    City findByName(String Name);

    @Query("from City t where ID = :id")
    List<City> queryCityList(@Param("id") int id);

    @Query("select c from City c")
    Page<City> findAlllist(Pageable pageable);

    @Modifying
    @Transactional
    @Query(value ="delete from City where name = ?1", nativeQuery = true)
    int deleteByCountryCode(String name);



}
