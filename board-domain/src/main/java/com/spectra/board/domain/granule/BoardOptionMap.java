package com.spectra.board.domain.granule;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.spectra.share.util.JsonUtil;

public class BoardOptionMap
{
    private Map<BoardOptionKey, String> map;

    public BoardOptionMap()
    {
        this.map = new HashMap<>();
    }

    public BoardOptionMap(BoardOptionKey boardOptionKey, String value)
    {
        this.map.put(boardOptionKey, value);
    }

    public String get(BoardOptionKey boardOptionKey)
    {
        return this.map.get(boardOptionKey);
    }

    public void put(BoardOptionKey boardOptionKey, String value)
    {
        this.map.put(boardOptionKey, value);
    }

    public static BoardOptionMap fromJson(String value)
    {
        return JsonUtil.fromJson(value, new TypeToken<Map<BoardOptionKey, String>>() {}.getType());
    }

    public static String toJson(BoardOptionMap object)
    {
        return JsonUtil.toJson(object);
    }

    @Override
    public String toString()
    {
        return "BoardOptionMap{" +
                "map=" + map +
                '}';
    }
}
