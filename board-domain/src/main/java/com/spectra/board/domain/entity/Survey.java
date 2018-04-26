package com.spectra.board.domain.entity;

import java.util.Set;

import com.spectra.board.domain.granule.SurveyAnswerType;
import com.spectra.board.domain.share.granule.NameValue;
import com.spectra.board.domain.share.granule.NameValueList;
import com.spectra.board.domain.granule.PostInfo;
import com.spectra.board.domain.granule.PostType;
import com.spectra.board.domain.granule.SurveyAnswer;
import com.spectra.board.domain.granule.SurveyAnswerSet;
import com.spectra.board.domain.granule.SurveyOptionKey;
import com.spectra.board.domain.granule.SurveyOptionMap;
import com.spectra.share.util.TimeUtil;

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

    public static Survey getWhereSample()
    {
        Survey survey = new Survey(Board.getNotifySample().getCurrentPostInfo(), "금주 회식 장소 조사", User.getAdminSample().getId());
        SurveyOptionMap surveyOptionMap = new SurveyOptionMap();
        surveyOptionMap.put(SurveyOptionKey.ALLOW_ADD_ANSWER, Boolean.toString(true));
        surveyOptionMap.put(SurveyOptionKey.ALLOW_ANONYMOUS, Boolean.toString(true));
        survey.setOptionMap(surveyOptionMap);
        SurveyAnswerSet surveyAnswerSet = new SurveyAnswerSet();
        surveyAnswerSet.add(new SurveyAnswer(SurveyAnswerType.IMAGE, "A식당 사진"));
        surveyAnswerSet.add(new SurveyAnswer(SurveyAnswerType.IMAGE, "B식당 사진"));
        surveyAnswerSet.add(new SurveyAnswer(SurveyAnswerType.IMAGE, "C식당 사진"));
        survey.setAnswerSet(surveyAnswerSet);
        survey.setExpiredDate(TimeUtil.getTime("20180431120000"));
        return survey;
    }

    public static Survey getWhenSample()
    {
        Survey survey = new Survey(Board.getNotifySample().getCurrentPostInfo(), "금주 회식 날짜 조사", User.getAdminSample().getId());
        SurveyOptionMap surveyOptionMap = new SurveyOptionMap();
        surveyOptionMap.put(SurveyOptionKey.ALLOW_ANONYMOUS, Boolean.toString(true));
        surveyOptionMap.put(SurveyOptionKey.ALLOW_MULTI_SELECT, Boolean.toString(true));
        survey.setOptionMap(surveyOptionMap);
        SurveyAnswerSet surveyAnswerSet = new SurveyAnswerSet();
        surveyAnswerSet.add(new SurveyAnswer(SurveyAnswerType.DATE, "20180509"));
        surveyAnswerSet.add(new SurveyAnswer(SurveyAnswerType.DATE, "20180510"));
        surveyAnswerSet.add(new SurveyAnswer(SurveyAnswerType.DATE, "20180511"));
        survey.setAnswerSet(surveyAnswerSet);
        survey.setExpiredDate(TimeUtil.getTime("20180431120000"));
        return survey;
    }

    public static Survey getWhatSample()
    {
        Survey survey = new Survey(Board.getNotifySample().getCurrentPostInfo(), "금주 회식 메뉴 조사", User.getAdminSample().getId());
        SurveyOptionMap surveyOptionMap = new SurveyOptionMap();
        surveyOptionMap.put(SurveyOptionKey.ALLOW_ADD_ANSWER, Boolean.toString(true));
        surveyOptionMap.put(SurveyOptionKey.ALLOW_ANONYMOUS, Boolean.toString(true));
        surveyOptionMap.put(SurveyOptionKey.ALLOW_MULTI_SELECT, Boolean.toString(true));
        survey.setOptionMap(surveyOptionMap);
        SurveyAnswerSet surveyAnswerSet = new SurveyAnswerSet();
        surveyAnswerSet.add(new SurveyAnswer(SurveyAnswerType.IMAGE, "돼지 사진"));
        surveyAnswerSet.add(new SurveyAnswer(SurveyAnswerType.IMAGE, "소 사진"));
        surveyAnswerSet.add(new SurveyAnswer(SurveyAnswerType.IMAGE, "물고기 사진"));
        survey.setAnswerSet(surveyAnswerSet);
        survey.setExpiredDate(TimeUtil.getTime("20180431120000"));
        return survey;
    }
}
