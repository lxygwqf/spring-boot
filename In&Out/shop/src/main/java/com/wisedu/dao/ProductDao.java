package com.wisedu.dao;

import com.wisedu.pojo.ProductPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductDao {
    public ProductPojo getProduct(Long id);

//    @Param mybatis参数
//    public int decreseProduct(@Param("id") Long id, @Param("quantity") int quantity, @Param("version") int version);
    public int decreseProduct(@Param("id") Long id, @Param("quantity") int quantity);
} 