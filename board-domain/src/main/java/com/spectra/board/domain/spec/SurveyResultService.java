package com.spectra.board.domain.spec;

import com.spectra.board.domain.entity.SurveyResult;
import com.spectra.board.domain.granule.NameValueList;

public interface SurveyResultService
{
    String register(SurveyResult surveyResult);

    SurveyResult find(String surveyResultId);
}
