package com.liwj.count.controller;

import com.liwj.count.dao.PointsManagementDao;
import com.liwj.count.dao.PointsManagementDaoImpl;
import com.liwj.count.pojo.PointsManagement;
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
    public String getPointByKey(String key) {
        if (key == null || key.isEmpty()) {
            return "key is null";
        }
        return pointsManagementDaoImpl.getPointByKey(key).toString();
    }
    @RequestMapping("/addUser")
    public String addUser(String key,Integer point) {
        if (point == null ) {
            return "point is null";
        }
        if (key == null || key.isEmpty()) {
            return "key is null";
        }
        Integer pointByKey = pointsManagementDaoImpl.getPointByKey(key);
        if (pointByKey==-1){
            PointsManagement pointsManagement = new PointsManagement();
            pointsManagement.setKey(key);
            pointsManagement.setId(key);
            pointsManagement.setPoint(point);
            pointsManagementDaoImpl.addUser(pointsManagement);
            return "add success";
        }else {
            return "key is exist";
        }
    }


    @RequestMapping("/updatePoint")
    public String updatePoint(String key,Integer point) {
        if (point==null){
            return "point is null";
        }
        if (key == null || key.isEmpty()) {
            return "key is null";
        }
        Integer pointByKey = pointsManagementDaoImpl.getPointByKey(key);
        if (pointByKey==-1){
            return "key is not exist";
        }else {
            pointsManagementDaoImpl.updatePoint(key,point);
            return "update success";
        }
    }
}
