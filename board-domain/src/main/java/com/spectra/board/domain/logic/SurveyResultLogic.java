package com.spectra.board.domain.logic;

import com.spectra.board.domain.entity.SurveyResult;
import com.spectra.board.domain.spec.SurveyResultService;
import com.spectra.board.domain.store.SurveyResultStore;

public class SurveyResultLogic implements SurveyResultService
{
    private SurveyResultStore surveyResultStore;

    public SurveyResultLogic(SurveyResultStore surveyResultStore)
    {
        this.surveyResultStore = surveyResultStore;
    }

    @Override
    public String register(SurveyResult surveyResult)
    {
        surveyResultStore.create(surveyResult);
        return surveyResult.getId();
    }

    @Override
    public SurveyResult find(String surveyResultId)
    {
        return surveyResultStore.retrieve(surveyResultId);
    }
}
