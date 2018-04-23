package com.spectra.board.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.spectra.board.domain.entity.Board;
import com.spectra.board.domain.entity.Channel;
import com.spectra.board.domain.entity.Entity;
import com.spectra.board.domain.entity.User;
import com.spectra.board.domain.granule.ChannelMemberIdSet;
import com.spectra.board.domain.granule.ChannelOptionKey;
import com.spectra.board.domain.granule.UserType;
import com.spectra.board.domain.logic.ChannelLogic;
import com.spectra.board.domain.logic.PostLogic;
import com.spectra.board.domain.logic.UserLogic;
import org.junit.Before;
import org.junit.Test;

public class BoardTest
{
    private UserLogic userLogic;
    private ChannelLogic channelLogic;
    private PostLogic postLogic;

    private List<User> users;

    @Before
    public void setup()
    {
        this.userLogic = new UserJavaLogic();
        this.channelLogic = new ChannelJavaLogic();
        this.postLogic = new PostJavaLogic();

        initUser();
    }

    private void initUser()
    {
        users = Arrays.asList(
                new User(UserType.ADMIN, "이정호", "010-2002-0014", "leejh@spectra.co.kr"),
                new User(UserType.MANAGER, "홍길동", "010-1234-5678", "hong@spectra.co.kr"),
                new User(UserType.MANAGER, "김좌진", "010-5678-1234", "kim@spectra.co.kr"),
                new User(UserType.USER, "문재인", "010-5678-4321", "moon@spectra.co.kr"),
                new User(UserType.USER, "안철수", "010-1234-6789", "ahn@spectra.co.kr"),
                new User(UserType.USER, "세종대왕", "010-0123-4567", "se@spectra.co.kr"),
                new User(UserType.USER, "이순신", "010-9012-3456", "lee@spectra.co.kr"),
                new User(UserType.USER, "김건모", "010-8901-2345", "kimo@spectra.co.kr"),
                new User(UserType.USER, "아이유", "010-7890-1234", "iu@spectra.co.kr")
        );
        for (User user : users)
        {
            this.userLogic.register(user);
        }
    }

    @Test
    public void channelTest()
    {
        Channel channel = new Channel("영업 비밀");
        channel.setMemberIdSet(new ChannelMemberIdSet(users.subList(0, 5).stream().map(Entity::getId).collect(Collectors.toSet())));
        channel.addChannelOption(ChannelOptionKey.PRIVATE, "true");
        channel.addChannelOption(ChannelOptionKey.ATTACH_MAX_SIZE_MB, "1000");
        channelLogic.register(channel);


    }

    public void boardTest(String channelId)
    {
        User admin = users.get(0);
        Board board  = new Board(channelId, "금주 회식 장소 투표 안내", "금주 몇월 몇시에 회식을 진행합니다. 원하는 장소를 선택해주세요.", admin.getId());
        postLogic.register(board);

    }
}
