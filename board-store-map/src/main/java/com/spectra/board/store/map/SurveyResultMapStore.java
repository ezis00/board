package com.spectra.board.store.map;

import java.util.HashMap;
import java.util.Map;

import com.spectra.board.domain.entity.SurveyResult;
import com.spectra.board.domain.store.SurveyResultStore;

public class SurveyResultMapStore implements SurveyResultStore
{
    private Map<String, SurveyResult> map;

    public SurveyResultMapStore()
    {
        this.map = new HashMap<>();
    }

    @Override
    public void create(SurveyResult surveyResult)
    {
        this.map.put(surveyResult.getId(), surveyResult);
    }

    @Override
    public SurveyResult retrieve(String surveyResultId)
    {
        return this.map.get(surveyResultId);
    }

    @Override
    public void update(SurveyResult surveyResult)
    {
        this.map.put(surveyResult.getId(), surveyResult);
    }
}
