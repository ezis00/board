package com.spectra.board.domain.spec;

import com.spectra.board.domain.entity.board.survey.Survey;
import com.spectra.board.domain.share.granule.NameValueList;

public interface SurveyService
{
    String register(Survey survey);

    Survey find(String surveyId);

    void modify(String surveyId, NameValueList nameValueList);
}
