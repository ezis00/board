package com.spectra.board.domain.logic;

import com.spectra.board.domain.entity.Survey;
import com.spectra.board.domain.share.granule.NameValueList;
import com.spectra.board.domain.spec.SurveyService;
import com.spectra.board.domain.store.SurveyStore;

public class SurveyLogic implements SurveyService
{
    private SurveyStore surveyStore;

    public SurveyLogic(SurveyStore surveyStore)
    {
        this.surveyStore = surveyStore;
    }

    @Override
    public String register(Survey survey)
    {
        surveyStore.create(survey);
        return survey.getId();
    }

    @Override
    public Survey find(String surveyId)
    {
        return surveyStore.retrieve(surveyId);
    }

    @Override
    public void modify(String surveyId, NameValueList nameValueList)
    {
        Survey survey = find(surveyId);
        survey.setValues(nameValueList);
        surveyStore.update(survey);
    }
}
