package com.spectra.board.domain.granule;

import com.spectra.share.util.JsonUtil;

public class Attach
{
    private final AttachType attachType;
    private final String attachId;

    public Attach(AttachType attachType, String attachId)
    {
        this.attachType = attachType;
        this.attachId = attachId;
    }

    public AttachType getAttachType()
    {
        return attachType;
    }

    public String getAttachId()
    {
        return attachId;
    }

    public static Attach fromJson(String value)
    {
        return JsonUtil.fromJson(value, Attach.class);
    }

    public static String toJson(Attach object)
    {
        return JsonUtil.toJson(object);
    }

    @Override
    public String toString()
    {
        return "Attach{" +
                "attachType=" + attachType +
                ", attachId='" + attachId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attach attach = (Attach) o;

        if (attachType != attach.attachType) return false;
        return attachId != null ? attachId.equals(attach.attachId) : attach.attachId == null;
    }

    @Override
    public int hashCode()
    {
        int result = attachType != null ? attachType.hashCode() : 0;
        result = 31 * result + (attachId != null ? attachId.hashCode() : 0);
        return result;
    }
}
