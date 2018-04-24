package com.spectra.board.domain.entity;

import java.util.Optional;

import com.spectra.board.domain.granule.NameValue;
import com.spectra.board.domain.granule.NameValueList;
import com.spectra.board.domain.granule.PostInfo;
import com.spectra.board.domain.granule.PostType;

public abstract class Post extends Entity
{
    private final Optional<PostInfo> parentPostInfo;
    private String contents;
    private long postDate;
    private final String writeUserId;

    protected Post(String writeUserId)
    {
        this(null, writeUserId);
    }

    protected Post(PostInfo parentPostInfo, String writeUserId)
    {
        super();
        this.parentPostInfo = Optional.ofNullable(parentPostInfo);
        this.writeUserId = writeUserId;
        this.postDate = System.currentTimeMillis();
    }

    public abstract PostType getPostType();

    public PostInfo getCurrentPostInfo()
    {
        return new PostInfo(getPostType(), getId());
    }

    public Optional<PostInfo> getParentPostInfo()
    {
        return parentPostInfo;
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

    @Override
    public String toString()
    {
        return "Post{" +
                "parentPostInfo=" + parentPostInfo +
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
                default:
                    throw new RuntimeException("Undefined field:" + nameValue.getName());
            }
        }
    }
}
