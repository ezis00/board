package com.spectra.board.domain.entity;

import java.util.Map;
import java.util.Set;

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

    public Survey(PostInfo parentPostInfo, String title, SurveyOptionMap optionMap, SurveyAnswerSet answerSet, long expiredDate, String writeUserId)
    {
        super(parentPostInfo, writeUserId);
        this.title = title;
        this.optionMap = optionMap;
        this.answerSet = answerSet;
        this.expiredDate = expiredDate;
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<SurveyOptionKey, String> entry : optionMap.getAll().entrySet())
        {
            builder.append(entry.getKey().toString());
            builder.append("\t:\t");
            builder.append(entry.getValue());
        }
        setContents(builder.toString());
    }

    @Override
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
}
