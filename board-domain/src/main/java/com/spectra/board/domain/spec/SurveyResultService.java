package com.spectra.board.domain.spec;

import com.spectra.board.domain.entity.board.survey.SurveyResult;

public interface SurveyResultService
{
    String register(SurveyResult surveyResult);

    SurveyResult find(String surveyResultId);
}
