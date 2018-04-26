package com.spectra.board.domain.entity.board;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.spectra.board.domain.entity.Tag;
import com.spectra.board.domain.entity.User;
import com.spectra.board.domain.granule.Attach;
import com.spectra.board.domain.granule.AttachType;
import com.spectra.board.domain.granule.BoardAttachSet;
import com.spectra.board.domain.granule.BoardOptionKey;
import com.spectra.board.domain.granule.BoardOptionMap;
import com.spectra.board.domain.granule.Level;
import com.spectra.board.domain.granule.Notify;
import com.spectra.board.domain.granule.NotifyOptionKey;
import com.spectra.board.domain.granule.PostInfo;
import com.spectra.board.domain.granule.PostType;
import com.spectra.board.domain.share.granule.IdSet;
import com.spectra.board.domain.share.granule.NameValue;
import com.spectra.board.domain.share.granule.NameValueList;

public class Posting extends Board
{
    private final PostType postType = PostType.BOARD;
    private String title;
    private String contents;
    private long lastUpdateDate;
    private BoardOptionMap optionMap;
    private BoardAttachSet attachSet;
    private IdSet viewerIdSet;
    private IdSet tagIdSet;
    private Notify notify;
    private int viewCount;

    transient private List<Comment> commentList;
    transient private List<Posting> postingList;
    transient private List<Vote> voteList;
    transient private List<Tag> tagList;

    public Posting(String writerId)
    {
        this(null, writerId);
    }

    public Posting(PostInfo parentPostInfo, String writerId)
    {
        super(parentPostInfo, writerId);
        this.optionMap = new BoardOptionMap();
        this.attachSet = new BoardAttachSet();
        this.viewerIdSet = new IdSet();
        this.tagIdSet = new IdSet();
        this.viewCount = 0;
    }

    public PostType getPostType()
    {
        return this.postType;
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

    public Notify getNotify()
    {
        return notify;
    }

    public void setNotify(Notify notify)
    {
        this.notify = notify;
    }

    public int getViewCount()
    {
        return viewCount;
    }

    public void setViewCount(int viewCount)
    {
        this.viewCount = viewCount;
    }

    public static Posting getNotifySample()
    {
        Posting posting = new Posting(Channel.getSample().getCurrentPostInfo(), User.getAdminSample().getId());
        posting.setTitle("회식 설문조사 안내");
        posting.setContents("차주에 진행되는 회식과 관련해서 아래 항목의 설문에 응답 부탁드립니다.");
        posting.addBoardOption(BoardOptionKey.NOTICE, Boolean.toString(true));
        Notify notify = new Notify("20180424120000", "20180428120000", Arrays.asList(Level.EMAIL, Level.SMS));
        notify.addNotifyOption(NotifyOptionKey.REPORT_ME_FLAG, Boolean.toString(true));
        posting.setNotify(notify);
        return posting;
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
                case "contents":
                    this.contents = value;
                    break;
                case "optionMap":
                    this.optionMap = BoardOptionMap.fromJson(value);
                    break;
                case "attachSet":
                    this.attachSet = BoardAttachSet.fromJson(value);
                    break;
                case "viewerIdSet":
                    this.viewerIdSet = IdSet.fromJson(value);
                    break;
                case "tagIdSet":
                    this.tagIdSet = IdSet.fromJson(value);
                    break;
                case "notify":
                    this.notify = Notify.fromJson(value);
                    break;
                case "viewCount":
                    this.viewCount = Integer.parseInt(value);
                    break;
                default:
                    throw new RuntimeException("Undefined field:" + nameValue.getName());
            }
        }
    }

    public static Posting getNoticeSample()
    {
        Posting posting = new Posting(Channel.getSample().getCurrentPostInfo(), User.getAdminSample().getId());
        posting.setTitle("사내 보안 프로그램 패치 공유");
        posting.setContents("아래 보안 프로그램을 꼭 설치 부탁드립니다..");
        posting.addBoardOption(BoardOptionKey.NOTICE, Boolean.toString(true));
        posting.addAttach(new Attach(AttachType.EXE, "보안프로그램패치파일"));
        return posting;
    }

    public static Posting getPrivateSample()
    {
        Posting posting = new Posting(Channel.getSample().getCurrentPostInfo(), User.getAdminSample().getId());
        posting.setTitle("작성중");
        posting.setContents("작성중인 글입니다.");
        posting.addBoardOption(BoardOptionKey.PRIVATE, Boolean.toString(true));
        return posting;
    }

    @Override
    public String toString()
    {
        return "Posting{" +
                "postType=" + postType +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", optionMap=" + optionMap +
                ", attachSet=" + attachSet +
                ", viewerIdSet=" + viewerIdSet +
                ", tagIdSet=" + tagIdSet +
                ", viewCount=" + viewCount +
                "} " + super.toString();
    }
}
