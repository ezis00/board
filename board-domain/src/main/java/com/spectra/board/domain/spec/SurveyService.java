package com.spectra.board.domain.spec;

import com.spectra.board.domain.entity.Survey;
import com.spectra.board.domain.granule.NameValueList;

public interface SurveyService
{
    String register(Survey survey);

    Survey find(String surveyId);

    void modify(String surveyId, NameValueList nameValueList);
}
