package com.spectra.board.service;

import com.spectra.board.domain.logic.SurveyResultLogic;
import com.spectra.board.store.map.SurveyResultMapStore;

public class SurveyResultJavaLogic extends SurveyResultLogic
{
    public SurveyResultJavaLogic()
    {
        super(new SurveyResultMapStore());
    }
}
