package com.stotk.mybatisdemo.mapper;

import com.stotk.mybatisdemo.model.Country;

import java.util.List;

/**
 *
 */
public interface CountryMapper {
    List<Country> selectAll();
}
