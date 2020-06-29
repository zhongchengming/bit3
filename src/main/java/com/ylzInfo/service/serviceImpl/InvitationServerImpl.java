package com.ylzInfo.service.serviceImpl;

import com.ylzInfo.bean.Invitation;
import com.ylzInfo.mapping.InvitationMapper;
import com.ylzInfo.service.InvitationServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitationServerImpl implements InvitationServer {
    @Autowired
    InvitationMapper invitationMapper;
    @Override
    public List<Invitation> selectByCode(String invitationcode) {
        List<Invitation>  list=  invitationMapper.selectBycode(invitationcode);
        return list;
    }
}
