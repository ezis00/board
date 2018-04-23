package com.spectra.board.domain.granule;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.spectra.share.util.JsonUtil;

public class BoardOptionMap
{
    private Map<BoardOptionKey, String> boardOptionMap;

    public BoardOptionMap()
    {
        this.boardOptionMap = new HashMap<>();
    }

    public String get(BoardOptionKey boardOptionKey)
    {
        return this.boardOptionMap.get(boardOptionKey);
    }

    public void put(BoardOptionKey boardOptionKey, String value)
    {
        this.boardOptionMap.put(boardOptionKey, value);
    }

    public static BoardOptionMap fromJson(String value)
    {
        return JsonUtil.fromJson(value, new TypeToken<Map<BoardOptionKey, String>>() {}.getType());
    }

    public static String toJson(Map<BoardOptionKey, String> boardOptionMap)
    {
        return JsonUtil.toJson(boardOptionMap);
    }

    @Override
    public String toString()
    {
        return "BoardOptionMap{" +
                "boardOptionMap=" + boardOptionMap +
                '}';
    }
}
