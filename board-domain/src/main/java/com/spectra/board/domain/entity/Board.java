package com.spectra.board.domain.entity;

import java.util.Optional;
import java.util.Set;

import com.spectra.board.domain.granule.Attach;
import com.spectra.board.domain.granule.BoardAttachSet;
import com.spectra.board.domain.granule.BoardOptionKey;
import com.spectra.board.domain.granule.BoardOptionMap;
import com.spectra.board.domain.granule.BoardTagIdSet;
import com.spectra.board.domain.granule.BoardViewerIdSet;
import com.spectra.board.domain.granule.NameValue;
import com.spectra.board.domain.granule.NameValueList;
import com.spectra.board.domain.granule.PostInfo;
import com.spectra.board.domain.granule.PostType;

public class Board extends Entity
{
    private final PostType postType = PostType.BOARD;
    private final Optional<PostInfo> parentPostInfo;
    private final String writerId;
    private final long postDate;
    private String title;
    private String contents;
    private long lastUpdateDate;
    private BoardOptionMap optionMap;
    private BoardAttachSet attachSet;
    private BoardViewerIdSet viewerIdSet;
    private BoardTagIdSet tagIdSet;
    private int viewCount;

    public Board(String writerId)
    {
        this(null, writerId);
    }

    public Board(PostInfo parentPostInfo, String writerId)
    {
        this.parentPostInfo = Optional.ofNullable(parentPostInfo);
        this.writerId = writerId;
        this.postDate = System.currentTimeMillis();
        this.optionMap = new BoardOptionMap();
        this.attachSet = new BoardAttachSet();
        this.viewerIdSet = new BoardViewerIdSet();
        this.tagIdSet = new BoardTagIdSet();
        this.viewCount = 0;
    }

    public PostType getPostType()
    {
        return this.postType;
    }

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

    public long getLastUpdateDate()
    {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(long lastUpdateDate)
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    public long getPostDate()
    {
        return postDate;
    }

    public String getWriterId()
    {
        return writerId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void addBoardOption(BoardOptionKey boardOptionKey, String value)
    {
        this.optionMap.put(boardOptionKey, value);
    }

    public String getBoardOption(BoardOptionKey boardOptionKey)
    {
        return this.optionMap.get(boardOptionKey);
    }

    public void addAttach(Attach attach)
    {
        this.attachSet.add(attach);
    }

    public Set<Attach> getAttachSet()
    {
        return attachSet.getAll();
    }

    public void addViewerId(String viewUserId)
    {
        this.viewerIdSet.add(viewUserId);
        this.viewCount++;
    }

    public Set<String> getViewerIdSet()
    {
        return viewerIdSet.getAll();
    }

    public void addTagId(String tagId)
    {
        this.tagIdSet.add(tagId);
    }

    public Set<String> getTagIdSet()
    {
        return this.tagIdSet.getAll();
    }

    public int getViewCount()
    {
        return viewCount;
    }

    public void setViewCount(int viewCount)
    {
        this.viewCount = viewCount;
    }


    @Override
    public String toString()
    {
        return "Board{" +
                "postType=" + postType +
                ", parentPostInfo=" + parentPostInfo +
                ", writerId='" + writerId + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", postDate=" + postDate +
                ", optionMap=" + optionMap +
                ", attachSet=" + attachSet +
                ", viewerIdSet=" + viewerIdSet +
                ", tagIdSet=" + tagIdSet +
                ", viewCount=" + viewCount +
                "} " + super.toString();
    }

    public void setValues(NameValueList nameValueList)
    {
        this.lastUpdateDate = System.currentTimeMillis();
        for (NameValue nameValue : nameValueList.getList())
        {
            String value = nameValue.getValue();
            switch (nameValue.getName())
            {
                case "title":
                    this.title = value;
                    break;
                case "optionMap":
                    this.optionMap = BoardOptionMap.fromJson(value);
                    break;
                case "attachSet":
                    this.attachSet = BoardAttachSet.fromJson(value);
                    break;
                case "viewerIdSet":
                    this.viewerIdSet = BoardViewerIdSet.fromJson(value);
                    break;
                case "tagIdSet":
                    this.tagIdSet = BoardTagIdSet.fromJson(value);
                    break;
                case "viewCount":
                    this.viewCount = Integer.parseInt(value);
                    break;
                case "contents":
                    this.contents = value;
                    break;
                default:
                    throw new RuntimeException("Undefined field:" + nameValue.getName());
            }
        }
    }
}
