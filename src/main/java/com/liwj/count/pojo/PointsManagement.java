package com.liwj.count.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: liwj
 * @create: 2022-08-17 20:03
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PointsManagement {
    private String id;
    private String key;		// 卡号
    private Integer point;		// 积分
}
