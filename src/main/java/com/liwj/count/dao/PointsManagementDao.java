package com.liwj.count.dao;

/**
 * @description:
 * @author: liwj
 * @create: 2022-08-17 20:06
 **/
public interface PointsManagementDao {
    Integer getPointByKey(String key);

    void  consumePoint(String key);
}
