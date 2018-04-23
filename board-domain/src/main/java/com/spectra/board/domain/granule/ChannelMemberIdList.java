package com.spectra.board.domain.granule;

import java.util.ArrayList;
import java.util.List;

import com.spectra.share.util.JsonUtil;

public class ChannelMemberIdList
{
    private List<String> memberIdList;

    public ChannelMemberIdList()
    {
        this.memberIdList = new ArrayList<>();
    }

    public ChannelMemberIdList(List<String> memberIdList)
    {
        this.memberIdList = memberIdList;
    }

    public List<String> getAll()
    {
        return this.memberIdList;
    }

    public void add(String memberId)
    {
        this.memberIdList.add(memberId);
    }

    public static ChannelMemberIdList fromJson(String value)
    {
        return JsonUtil.fromJson(value, ChannelMemberIdList.class);
    }

    @Override
    public String toString()
    {
        return "ChannelMemberIdList{" +
                "memberIdList=" + memberIdList +
                '}';
    }
}
