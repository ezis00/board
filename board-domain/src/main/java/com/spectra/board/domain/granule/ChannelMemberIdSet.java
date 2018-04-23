package com.spectra.board.domain.granule;

import java.util.HashSet;
import java.util.Set;

import com.spectra.share.util.JsonUtil;

public class ChannelMemberIdSet
{
    private Set<String> memberIdList;

    public ChannelMemberIdSet()
    {
        this.memberIdList = new HashSet<>();
    }

    public ChannelMemberIdSet(Set<String> memberIdList)
    {
        this.memberIdList = memberIdList;
    }

    public Set<String> getAll()
    {
        return this.memberIdList;
    }

    public void add(String memberId)
    {
        this.memberIdList.add(memberId);
    }

    public static ChannelMemberIdSet fromJson(String value)
    {
        return JsonUtil.fromJson(value, ChannelMemberIdSet.class);
    }

    @Override
    public String toString()
    {
        return "ChannelMemberIdSet{" +
                "memberIdList=" + memberIdList +
                '}';
    }
}
