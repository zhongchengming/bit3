package com.ylzInfo.service;

import com.ylzInfo.bean.Invitation;

import java.util.List;

public interface InvitationServer {
    List<Invitation> selectByCode(String invitationcode);
}
