package com.spectra.board.domain.granule;

import java.util.HashSet;
import java.util.Set;

import com.spectra.share.util.JsonUtil;

public class BoardAttachSet
{
    private Set<Attach> attachList;

    public BoardAttachSet()
    {
        this.attachList = new HashSet<>();
    }

    public BoardAttachSet(Set<Attach> attachList)
    {
        this.attachList = attachList;
    }

    public Set<Attach> getAll()
    {
        return this.attachList;
    }

    public void add(Attach attach)
    {
        this.attachList.add(attach);
    }

    public static BoardAttachSet fromJson(String value)
    {
        return JsonUtil.fromJson(value, BoardAttachSet.class);
    }

    @Override
    public String toString()
    {
        return "ChannelMemberIdSet{" +
                "attachList=" + attachList +
                '}';
    }
}
