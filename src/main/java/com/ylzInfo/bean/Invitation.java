package com.ylzInfo.bean;

public class Invitation {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_invitation.id
     *
     * @mbggenerated Mon Jun 29 23:42:34 CST 2020
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_invitation.userid
     *
     * @mbggenerated Mon Jun 29 23:42:34 CST 2020
     */
    private Integer userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column w_invitation.invitationcode
     *
     * @mbggenerated Mon Jun 29 23:42:34 CST 2020
     */
    private String invitationcode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_invitation.id
     *
     * @return the value of w_invitation.id
     *
     * @mbggenerated Mon Jun 29 23:42:34 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_invitation.id
     *
     * @param id the value for w_invitation.id
     *
     * @mbggenerated Mon Jun 29 23:42:34 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_invitation.userid
     *
     * @return the value of w_invitation.userid
     *
     * @mbggenerated Mon Jun 29 23:42:34 CST 2020
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_invitation.userid
     *
     * @param userid the value for w_invitation.userid
     *
     * @mbggenerated Mon Jun 29 23:42:34 CST 2020
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column w_invitation.invitationcode
     *
     * @return the value of w_invitation.invitationcode
     *
     * @mbggenerated Mon Jun 29 23:42:34 CST 2020
     */
    public String getInvitationcode() {
        return invitationcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column w_invitation.invitationcode
     *
     * @param invitationcode the value for w_invitation.invitationcode
     *
     * @mbggenerated Mon Jun 29 23:42:34 CST 2020
     */
    public void setInvitationcode(String invitationcode) {
        this.invitationcode = invitationcode;
    }
}