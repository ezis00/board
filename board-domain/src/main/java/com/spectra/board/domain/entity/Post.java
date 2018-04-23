package com.spectra.board.domain.entity;

import java.util.Optional;

import com.spectra.board.domain.granule.NameValue;
import com.spectra.board.domain.granule.NameValueList;
import com.spectra.board.domain.granule.ParentPost;

public abstract class Post extends Entity
{
    private Optional<ParentPost> parentPost;
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
        this(null, contents, writeUserId);
    }

    protected Post(ParentPost parentPost, String contents, String writeUserId)
    {
        this.parentPost = Optional.ofNullable(parentPost);
        this.contents = contents;
        this.writeUserId = writeUserId;
        this.postDate = System.currentTimeMillis();
    }

    public Optional<ParentPost> getParentPost()
    {
        return parentPost;
    }

    public void setParentPost(ParentPost parentPost)
    {
        this.parentPost = Optional.ofNullable(parentPost);
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


    @Override
    public String toString()
    {
        return "Post{" +
                "parentPost=" + parentPost +
                ", contents='" + contents + '\'' +
                ", postDate=" + postDate +
                ", writeUserId='" + writeUserId + '\'' +
                "} " + super.toString();
    }

    public void setValues(NameValueList nameValueList)
    {
        for (NameValue nameValue : nameValueList.getList())
        {
            String value = nameValue.getValue();
            switch (nameValue.getName())
            {
                case "contents":
                    this.contents = value;
                    break;
                case "postDate":
                    this.postDate = Long.parseLong(value);
                    break;
                case "writeUserId":
                    this.writeUserId = value;
                    break;
                default:
                    throw new RuntimeException("Undefined field:" + nameValue.getName());
            }
        }
    }
}
