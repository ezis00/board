package com.spectra.board.service;

import com.spectra.board.domain.logic.SurveyLogic;
import com.spectra.board.store.map.SurveyMapStore;

public class SurveyJavaLogic extends SurveyLogic
{
    public SurveyJavaLogic()
    {
        super(new SurveyMapStore());
    }
}
