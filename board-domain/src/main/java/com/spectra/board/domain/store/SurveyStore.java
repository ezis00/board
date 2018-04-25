package com.spectra.board.domain.store;

import com.spectra.board.domain.entity.Survey;

public interface SurveyStore
{
    void create(Survey survey);

    Survey retrieve(String surveyId);

    void update(Survey survey);
}
