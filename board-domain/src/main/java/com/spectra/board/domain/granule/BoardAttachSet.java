package com.spectra.board.domain.granule;

import java.util.HashSet;
import java.util.Set;

import com.spectra.share.util.JsonUtil;

public class BoardAttachSet
{
    private Set<Attach> set;

    public BoardAttachSet()
    {
        this.set = new HashSet<>();
    }

    public BoardAttachSet(Attach attach)
    {
        this.set.add(attach);
    }

    public Set<Attach> getAll()
    {
        return this.set;
    }

    public void add(Attach attach)
    {
        this.set.add(attach);
    }

    public static BoardAttachSet fromJson(String value)
    {
        return JsonUtil.fromJson(value, BoardAttachSet.class);
    }

    @Override
    public String toString()
    {
        return "IdSet{" +
                "set=" + set +
                '}';
    }
}
