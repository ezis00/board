package com.spectra.board.domain.entity;

import java.util.Set;

import com.spectra.board.domain.granule.NameValue;
import com.spectra.board.domain.granule.NameValueList;
import com.spectra.board.domain.granule.PostInfo;
import com.spectra.board.domain.granule.PostType;
import com.spectra.board.domain.granule.SurveyAnswer;
import com.spectra.board.domain.granule.SurveyAnswerSet;
import com.spectra.board.domain.granule.SurveyOptionKey;
import com.spectra.board.domain.granule.SurveyOptionMap;

public class Survey extends Post
{
    private final PostType postType = PostType.SURVEY;
    private String title;
    private SurveyAnswerSet answerSet;
    private SurveyOptionMap optionMap;
    private long expiredDate;
    private long lastUpdateDate;

    public Survey(PostInfo parentPostInfo, String title, String writerId)
    {
        super(parentPostInfo, writerId);
        this.title = title;
        this.optionMap = new SurveyOptionMap();
        this.answerSet = new SurveyAnswerSet();
    }

    public PostType getPostType()
    {
        return this.postType;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void addOption(SurveyOptionKey surveyOptionKey, String value)
    {
        this.optionMap.put(surveyOptionKey, value);
    }

    public String getOption(SurveyOptionKey surveyOptionKey)
    {
        return optionMap.get(surveyOptionKey);
    }

    public void addAnswer(SurveyAnswer surveyAnswer)
    {
        this.answerSet.add(surveyAnswer);
    }

    public Set<SurveyAnswer> getSet()
    {
        return answerSet.getAll();
    }

    public long getExpiredDate()
    {
        return expiredDate;
    }

    public void setExpiredDate(long expiredDate)
    {
        this.expiredDate = expiredDate;
    }

    public SurveyAnswerSet getAnswerSet()
    {
        return answerSet;
    }

    public void setAnswerSet(SurveyAnswerSet answerSet)
    {
        this.answerSet = answerSet;
    }

    public SurveyOptionMap getOptionMap()
    {
        return optionMap;
    }

    public void setOptionMap(SurveyOptionMap optionMap)
    {
        this.optionMap = optionMap;
    }

    public long getLastUpdateDate()
    {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(long lastUpdateDate)
    {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString()
    {
        return "Survey{" +
                "title='" + title + '\'' +
                ", answerSet=" + answerSet +
                ", optionMap=" + optionMap +
                ", expiredDate=" + expiredDate +
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
                default:
                    throw new RuntimeException("Undefined field:" + nameValue.getName());
            }
        }
    }
}
