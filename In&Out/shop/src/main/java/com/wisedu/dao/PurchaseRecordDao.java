package com.wisedu.dao;

import com.wisedu.pojo.PurchaseRecordPojo;
import org.apache.ibatis.annotations.Mapper;

//mybatis产品接口定义
@Mapper
public interface PurchaseRecordDao {
    public int insertPurchaseRecord(PurchaseRecordPojo pr);
} 