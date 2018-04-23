package com.spectra.board.service;

import com.spectra.board.domain.entity.Channel;
import com.spectra.board.domain.logic.ChannelLogic;
import com.spectra.board.domain.logic.UserLogic;
import org.junit.Before;
import org.junit.Test;

public class BoardTest
{
    private ChannelLogic channelLogic;
    private UserLogic userLogic;
    @Before
    public void setup()
    {
        this.userLogic = new UserJavaLogic();
        this.channelLogic = new ChannelJavaLogic();
    }

    @Test
    public void test()
    {
        Channel channel = new Channel("영업 비밀");
//        channel.setMemberUserIdList();
//        channelLogic.regist()
    }
}
