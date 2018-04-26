package com.spectra.board.service;

import java.util.Arrays;
import java.util.List;

import com.spectra.board.domain.entity.Board;
import com.spectra.board.domain.entity.Channel;
import com.spectra.board.domain.entity.Survey;
import com.spectra.board.domain.entity.SurveyResult;
import com.spectra.board.domain.entity.User;
import com.spectra.board.domain.share.granule.NameValueList;
import com.spectra.board.domain.spec.BoardService;
import com.spectra.board.domain.spec.ChannelService;
import com.spectra.board.domain.spec.SurveyResultService;
import com.spectra.board.domain.spec.SurveyService;
import com.spectra.board.domain.spec.UserService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardTest
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private UserService userService;
    private ChannelService channelService;
    private BoardService boardService;
    private SurveyService surveyService;
    private SurveyResultService surveyResultService;

    @Before
    public void setup()
    {
        this.userService = new UserJavaLogic();
        this.channelService = new ChannelJavaLogic();
        this.boardService = new BoardJavaLogic();
        this.surveyService = new SurveyJavaLogic();
        this.surveyResultService = new SurveyResultJavaLogic();

        initUser();
    }

    private void initUser()
    {
        for (User user : User.getSamples())
        {
            this.userService.register(user);
        }
    }

    @Test
    public void test()
    {
        createChannelSample();
        createBoardSamples();
        createSurveySamples();
        requestSurveyResponse();
        getAllBoardsByChannel();
        viewBoard();
    }

    private void getAllBoardsByChannel()
    {
        List<Board> boardList = this.boardService.findByParentPostInfo(Channel.getSample().getCurrentPostInfo());
        for (Board board : boardList)
        {
            logger.info(board.toString());
        }
    }

    private void createChannelSample()
    {
        channelService.register(Channel.getSample());
    }

    private void createBoardSamples()
    {
        boardService.register(Board.getNotifySample());
        boardService.register(Board.getNoticeSample());
        boardService.register(Board.getPrivateSample());
    }

    private void createSurveySamples()
    {
        surveyService.register(Survey.getWhereSample());
        surveyService.register(Survey.getWhenSample());
        surveyService.register(Survey.getWhatSample());
    }

    private void requestSurveyResponse()
    {
        User admin = User.getAdminSample();
        for (Board board : Arrays.asList(Board.getNotifySample(), Board.getNoticeSample(), Board.getPrivateSample()))
        {
            Survey survey = this.surveyService.find(board.getId());
            this.surveyResultService.register(new SurveyResult(survey.getId(), admin.getId(), survey.getAnswerSet().getAll().iterator().next().getContents()));
        }
    }

    private void viewBoard()
    {
        for (User viewer : User.getSamples())
        {
            NameValueList nameValueList = new NameValueList();
            nameValueList.add("viewerIdSet", viewer.getId());
            this.boardService.modify(Board.getNoticeSample().getId(), nameValueList);
        }
    }
}
