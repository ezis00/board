package com.spectra.board.domain.share.granule;

import java.util.HashSet;
import java.util.Set;

import com.spectra.share.util.JsonUtil;

public class IdSet
{
    private Set<String> set;

    public IdSet()
    {
        this.set = new HashSet<>();
    }

    public IdSet(String memberId)
    {
        this.set.add(memberId);
    }

    public Set<String> getAll()
    {
        return this.set;
    }

    public void add(String memberId)
    {
        this.set.add(memberId);
    }

    public void addAll(Set<String> memberIdSet)
    {
        this.set.addAll(memberIdSet);
    }

    public static IdSet fromJson(String value)
    {
        return JsonUtil.fromJson(value, IdSet.class);
    }

    @Override
    public String toString()
    {
        return "IdSet{" +
                "set=" + set +
                '}';
    }

    public static IdSet getSample()
    {
        IdSet sample = new IdSet();
//        sample.add();
        return null;
    }
}
