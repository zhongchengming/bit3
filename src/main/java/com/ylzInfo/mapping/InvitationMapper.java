package com.ylzInfo.mapping;

import com.ylzInfo.bean.Invitation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InvitationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_invitation
     *
     * @mbggenerated Mon Jun 29 23:42:34 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_invitation
     *
     * @mbggenerated Mon Jun 29 23:42:34 CST 2020
     */
    int insert(Invitation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_invitation
     *
     * @mbggenerated Mon Jun 29 23:42:34 CST 2020
     */
    int insertSelective(Invitation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_invitation
     *
     * @mbggenerated Mon Jun 29 23:42:34 CST 2020
     */
    Invitation selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_invitation
     *
     * @mbggenerated Mon Jun 29 23:42:34 CST 2020
     */
    int updateByPrimaryKeySelective(Invitation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table w_invitation
     *
     * @mbggenerated Mon Jun 29 23:42:34 CST 2020
     */
    int updateByPrimaryKey(Invitation record);

    List<Invitation> selectBycode(@Param("invitationcode") String invitationcode);
}
