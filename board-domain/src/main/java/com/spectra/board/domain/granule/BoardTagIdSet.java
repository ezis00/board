package com.spectra.board.domain.granule;

import java.util.HashSet;
import java.util.Set;

import com.spectra.share.util.JsonUtil;

public class BoardTagIdSet
{
    private Set<String> tagIdSet;

    public BoardTagIdSet()
    {
        this.tagIdSet = new HashSet<>();
    }

    public BoardTagIdSet(Set<String> tagIdSet)
    {
        this.tagIdSet = tagIdSet;
    }

    public Set<String> getAll()
    {
        return this.tagIdSet;
    }

    public void add(String memberId)
    {
        this.tagIdSet.add(memberId);
    }

    public static BoardTagIdSet fromJson(String value)
    {
        return JsonUtil.fromJson(value, BoardTagIdSet.class);
    }

    @Override
    public String toString()
    {
        return "ChannelMemberIdSet{" +
                "tagIdSet=" + tagIdSet +
                '}';
    }
}
