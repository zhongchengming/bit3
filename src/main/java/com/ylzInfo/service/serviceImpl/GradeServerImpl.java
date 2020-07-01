package com.ylzInfo.service.serviceImpl;

import com.ylzInfo.bean.Grade;
import com.ylzInfo.mapping.GradeMapper;
import com.ylzInfo.service.GradeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * todo
 * <p>
 * @Author LeifChen
 * @Date 2020-06-30
 */
@Service
public class GradeServerImpl implements GradeServer {
   @Autowired
    GradeMapper gradeMapper;
    @Override
    public List<Grade> getAll() {
        List<Grade>list = gradeMapper.selectAll();
        return list;
    }

    @Override
    public void addAgrade(HttpServletRequest request) {
        Grade grade = new Grade();
        String gradeName = request.getParameter("gradename");
        String score = request.getParameter("score");
        grade.setGradename(gradeName);
        grade.setScore(Integer.valueOf(score));
        gradeMapper.insert(grade);
    }

    @Override
    public void updateAgrade(HttpServletRequest request) {
        String gradeName = request.getParameter("gradename");
        String score = request.getParameter("score");
        String id = request.getParameter("id");
        Grade grade = new Grade();
        grade.setId(Integer.valueOf(id));
        grade.setGradename(gradeName.length()>0?gradeName:null);
        grade.setScore(score.length()>0?Integer.valueOf(score):null);
        gradeMapper.updateByPrimaryKeySelective(grade);
    }
}
