package com.spectra.board.domain.granule;

import java.util.ArrayList;
import java.util.List;

import com.spectra.share.util.JsonUtil;

public class ChannelMemberIdList
{
    private List<String> memberUserIdList;

    public ChannelMemberIdList()
    {
        this.memberUserIdList = new ArrayList<>();
    }

    public List<String> getAll()
    {
        return this.memberUserIdList;
    }

    public void add(String memberId)
    {
        this.memberUserIdList.add(memberId);
    }

    public static ChannelMemberIdList fromJson(String value)
    {
        return JsonUtil.fromJson(value, ChannelMemberIdList.class);
    }

    @Override
    public String toString()
    {
        return "ChannelMemberIdList{" +
                "memberUserIdList=" + memberUserIdList +
                '}';
    }
}
