package com.spectra.board.domain.entity;

public abstract class Post extends Entity
{
    private String contents;
    private long postDate;
    private String writeUserId;

    protected Post()
    {
    }

    protected Post(String id)
    {
        super(id);
    }

    protected Post(String contents, String writeUserId)
    {
        this.contents = contents;
        this.writeUserId = writeUserId;
        this.postDate = System.currentTimeMillis();
    }

    public String getContents()
    {
        return contents;
    }

    public void setContents(String contents)
    {
        this.contents = contents;
    }

    public long getPostDate()
    {
        return postDate;
    }

    public void setPostDate(long postDate)
    {
        this.postDate = postDate;
    }

    public String getWriteUserId()
    {
        return writeUserId;
    }

    public void setWriteUserId(String writeUserId)
    {
        this.writeUserId = writeUserId;
    }
}
