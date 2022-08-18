package com.liwj.count.dao;

import com.liwj.count.pojo.PointsManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: liwj
 * @create: 2022-08-17 20:08
 **/
@Service("pointsManagementDaoImpl")
public class PointsManagementDaoImpl implements PointsManagementDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getPointByKey(String key) {
        if (key == null || key.isEmpty()) {
            return 0;
        }
        String sql = "select point from points_management where `status` = 0  and `key` = ?";
        Object[] args = new Object[]{key};
        Integer integer = null;
        try {
            integer = jdbcTemplate.queryForObject(sql, args, Integer.class);
        } catch (DataAccessException e) {
            //没有用户
            return -1;
        }
        return integer;
    }

    @Override
    public void consumePoint(String key) {
        if (key == null || key.isEmpty()) {
            return;
        }
        String sql = "update points_management set `point` = `point` -1 where `status` = 0 AND `key` = ?";
        Object[] args = new Object[]{key};
        jdbcTemplate.update(sql, args);
    }

    @Override
    public PointsManagement getPointsManagementByKey(String key) {
        if (key == null || key.isEmpty()) {
            return null;
        }
        String sql = "select * from points_management where `status` = 0 AND `key` = ?";
        Object[] args = new Object[]{key};
        PointsManagement pointsManagement = null;
        try {
            pointsManagement = jdbcTemplate.queryForObject(sql, args, (resultSet, i) -> {
                PointsManagement pointsManagement1 = new PointsManagement();
                pointsManagement1.setId(resultSet.getString("id"));
                pointsManagement1.setKey(resultSet.getString("key"));
                pointsManagement1.setPoint(resultSet.getInt("point"));
                return pointsManagement1;
            });
        } catch (DataAccessException e) {
            //没有用户
            return null;
        }
        return pointsManagement;
    }

    @Override
    public void addUser(PointsManagement pointsManagement) {
        if (pointsManagement == null) {
            return;
        }
        String sql = "insert into points_management (`key`,`point`,`id`,`status`) values (?,?,?,0)";
        Object[] args = new Object[]{pointsManagement.getKey(), pointsManagement.getPoint(),pointsManagement.getId()};
        jdbcTemplate.update(sql, args);
    }

    @Override
    public void updatePoint(String key, Integer point) {
        if (key == null || key.isEmpty()) {
            return;
        }
        String sql = "update points_management set `point` =  ? where `status` = 0 AND `key` = ?";
        Object[] args = new Object[]{point, key};
        jdbcTemplate.update(sql, args);
    }
}
