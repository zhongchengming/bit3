package com.ylzInfo.service;

import com.ylzInfo.bean.Grade;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * todo
 * <p>
 * @Author LeifChen
 * @Date 2020-06-30
 */
public interface GradeServer {
    List<Grade> getAll();

    void addAgrade(HttpServletRequest request);

    void updateAgrade(HttpServletRequest request);
}
