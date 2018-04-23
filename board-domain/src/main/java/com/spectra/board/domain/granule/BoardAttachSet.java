package com.spectra.board.domain.granule;

import java.util.ArrayList;
import java.util.List;

import com.spectra.share.util.JsonUtil;

public class BoardAttachSet
{
    private List<Attach> attachList;

    public BoardAttachSet()
    {
        this.attachList = new ArrayList<>();
    }

    public BoardAttachSet(List<Attach> attachList)
    {
        this.attachList = attachList;
    }

    public List<Attach> getAll()
    {
        return this.attachList;
    }

    public void add(Attach memberId)
    {
        this.attachList.add(memberId);
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
