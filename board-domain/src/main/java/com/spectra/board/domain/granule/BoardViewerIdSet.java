package com.spectra.board.domain.granule;

import java.util.HashSet;
import java.util.Set;

import com.spectra.share.util.JsonUtil;

public class BoardViewerIdSet
{
    private Set<String> viewerIdSet;

    public BoardViewerIdSet()
    {
        this.viewerIdSet = new HashSet<>();
    }

    public BoardViewerIdSet(Set<String> viewerIdSet)
    {
        this.viewerIdSet = viewerIdSet;
    }

    public Set<String> getAll()
    {
        return this.viewerIdSet;
    }

    public void add(String memberId)
    {
        this.viewerIdSet.add(memberId);
    }

    public static BoardViewerIdSet fromJson(String value)
    {
        return JsonUtil.fromJson(value, BoardViewerIdSet.class);
    }

    @Override
    public String toString()
    {
        return "ChannelMemberIdSet{" +
                "viewerIdSet=" + viewerIdSet +
                '}';
    }
}
