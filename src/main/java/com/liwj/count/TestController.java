package com.liwj.count;

import com.liwj.count.utils.CosUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @description:
 * @author: liwj
 * @create: 2021-12-04 20:39
 **/
@RestController
public class TestController {

    @Autowired
    CosUtils cosUtils;


    @RequestMapping("t0")
    public void t0(){
//        cosUtils.upload();
    }

    public static void main(String[] args) {
        String md5 = DigestUtils.md5Hex("123456");
        System.out.println("md5 = " + md5);

    }
}
