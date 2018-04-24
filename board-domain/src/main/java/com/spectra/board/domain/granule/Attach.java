package com.spectra.board.domain.granule;

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

    @Override
    public String toString()
    {
        return "Attach{" +
                "attachType=" + attachType +
                ", attachId='" + attachId + '\'' +
                '}';
    }
}
