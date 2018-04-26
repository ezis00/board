package com.spectra.board.domain.granule;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.spectra.share.util.JsonUtil;

public class NotifyOptionMap implements ValueObject
{
    private Map<NotifyOptionKey, String> map;

    public NotifyOptionMap()
    {
        this.map = new HashMap<>();
    }

    public NotifyOptionMap(NotifyOptionKey notifyOptionKey, String value)
    {
        this.map.put(notifyOptionKey, value);
    }

    public String get(NotifyOptionKey notifyOptionKey)
    {
        return this.map.get(notifyOptionKey);
    }

    public void put(NotifyOptionKey notifyOptionKey, String value)
    {
        this.map.put(notifyOptionKey, value);
    }

    public static NotifyOptionMap fromJson(String value)
    {
        return JsonUtil.fromJson(value, new TypeToken<Map<NotifyOptionKey, String>>() {}.getType());
    }

    public static String toJson(NotifyOptionMap object)
    {
        return JsonUtil.toJson(object);
    }

    @Override
    public String toString()
    {
        return "NotifyOptionMap{" +
                "map=" + map +
                '}';
    }
}
