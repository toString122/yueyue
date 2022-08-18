package com.liwj.count.dao;

import com.liwj.count.pojo.PointsManagement;

/**
 * @description:
 * @author: liwj
 * @create: 2022-08-17 20:06
 **/
public interface PointsManagementDao {
    Integer getPointByKey(String key);

    void  consumePoint(String key);

    PointsManagement getPointsManagementByKey(String key);

    void addUser(PointsManagement pointsManagement);

    void updatePoint(String key, Integer point);
}
