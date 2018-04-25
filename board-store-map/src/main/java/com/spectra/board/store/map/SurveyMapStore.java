package com.spectra.board.store.map;

import java.util.HashMap;
import java.util.Map;

import com.spectra.board.domain.entity.Survey;
import com.spectra.board.domain.store.SurveyStore;

public class SurveyMapStore implements SurveyStore
{
    private Map<String, Survey> map;

    public SurveyMapStore()
    {
        this.map = new HashMap<>();
    }

    @Override
    public void create(Survey survey)
    {
        this.map.put(survey.getId(), survey);
    }

    @Override
    public Survey retrieve(String surveyId)
    {
        return this.map.get(surveyId);
    }

    @Override
    public void update(Survey survey)
    {
        this.map.put(survey.getId(), survey);
    }
}
