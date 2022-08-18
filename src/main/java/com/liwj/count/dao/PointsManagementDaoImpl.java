package com.liwj.count.dao;

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
        String sql = "select point from points_management where `status` = 0 AND `point` > 0  and `key` = ?";
        Object[] args = new Object[]{key};
        Integer integer = null;
        try {
            integer = jdbcTemplate.queryForObject(sql, args, Integer.class);
        } catch (DataAccessException e) {
            return 0;
        }

        return integer == null || integer<=0 ? 0 : integer;
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
}
