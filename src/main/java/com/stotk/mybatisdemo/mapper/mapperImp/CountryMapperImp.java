package com.stotk.mybatisdemo.mapper.mapperImp;

import com.stotk.mybatisdemo.model.Country;

import java.util.List;

/**
 *
 */
public interface CountryMapperImp {
    /**
     * 查询城市信息
     *
     * @return
     */
    List<Country> selectAll();
}
