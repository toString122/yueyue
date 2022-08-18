package com.liwj.count.controller;

import com.liwj.count.dao.PointsManagementDao;
import com.liwj.count.dao.PointsManagementDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: liwj
 * @create: 2022-08-17 20:11
 **/
@RestController
public class PointController {

    @Autowired
    private PointsManagementDaoImpl pointsManagementDaoImpl;

    @RequestMapping("/getPoint")
    public Integer getPointByKey(String key) {
        if (key == null || key.isEmpty()) {
            return 0;
        }
        return pointsManagementDaoImpl.getPointByKey(key);
    }
}
