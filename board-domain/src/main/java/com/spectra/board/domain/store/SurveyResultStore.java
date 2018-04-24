package com.spectra.board.domain.store;

import com.spectra.board.domain.entity.SurveyResult;

public interface SurveyResultStore
{
    void create(SurveyResult surveyResult);

    SurveyResult retrieve(String surveyResultId);

    void update(SurveyResult surveyResult);
}
