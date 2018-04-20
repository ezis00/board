package com.spectra.board.domain.granule;

public class Attach
{
    private AttachType attachType;
    private String attachId;

    public Attach(AttachType attachType, String attachId)
    {
        this.attachType = attachType;
        this.attachId = attachId;
    }

    public AttachType getAttachType()
    {
        return attachType;
    }

    public void setAttachType(AttachType attachType)
    {
        this.attachType = attachType;
    }

    public String getAttachId()
    {
        return attachId;
    }

    public void setAttachId(String attachId)
    {
        this.attachId = attachId;
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
