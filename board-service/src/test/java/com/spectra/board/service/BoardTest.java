package com.spectra.board.service;

import java.util.Arrays;
import java.util.List;

import com.spectra.board.domain.entity.Scrap;
import com.spectra.board.domain.entity.Tag;
import com.spectra.board.domain.entity.User;
import com.spectra.board.domain.entity.board.Channel;
import com.spectra.board.domain.entity.board.Comment;
import com.spectra.board.domain.entity.board.Posting;
import com.spectra.board.domain.entity.board.Vote;
import com.spectra.board.domain.entity.board.survey.Survey;
import com.spectra.board.domain.entity.board.survey.SurveyResult;
import com.spectra.board.domain.share.granule.NameValueList;
import com.spectra.board.domain.spec.BoardService;
import com.spectra.board.domain.spec.ChannelService;
import com.spectra.board.domain.spec.ReplyService;
import com.spectra.board.domain.spec.ScrapService;
import com.spectra.board.domain.spec.SurveyResultService;
import com.spectra.board.domain.spec.SurveyService;
import com.spectra.board.domain.spec.TagService;
import com.spectra.board.domain.spec.UserService;
import com.spectra.board.domain.spec.VoteService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardTest
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private BoardService boardService;
    private ChannelService channelService;
    private ReplyService replyService;
    private ScrapService scrapService;
    private SurveyService surveyService;
    private SurveyResultService surveyResultService;
    private TagService tagService;
    private UserService userService;
    private VoteService voteService;

    @Before
    public void setup()
    {
        this.boardService = new BoardJavaLogic();
        this.channelService = new ChannelJavaLogic();
        this.replyService = new ReplyJavaLogic();
        this.scrapService = new ScrapJavaLogic();
        this.surveyService = new SurveyJavaLogic();
        this.surveyResultService = new SurveyResultJavaLogic();
        this.tagService = new TagJavaLogic();
        this.userService = new UserJavaLogic();
        this.voteService = new VoteJavaLogic();

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
        scrapBoard();
        replyBoard();
        tagBoard();
        voteBoard();
    }

    private void getAllBoardsByChannel()
    {
        List<Posting> postingList = this.boardService.findByParentPostInfo(Channel.getSample().getCurrentPostInfo());
        for (Posting posting : postingList)
        {
            logger.info(posting.toString());
        }
    }

    private void createChannelSample()
    {
        channelService.register(Channel.getSample());
    }

    private void createBoardSamples()
    {
        boardService.register(Posting.getNotifySample());
        boardService.register(Posting.getNoticeSample());
        boardService.register(Posting.getPrivateSample());
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
        for (Survey survey : Arrays.asList(Survey.getWhatSample(), Survey.getWhenSample(), Survey.getWhereSample()))
        {
            this.surveyResultService.register(new SurveyResult(survey.getId(), admin.getId(), survey.getAnswerSet().getAll().iterator().next().getContents()));
        }
    }

    private void viewBoard()
    {
        for (User viewer : User.getSamples())
        {
            NameValueList nameValueList = new NameValueList();
            nameValueList.add("viewerIdSet", viewer.getId());
            this.boardService.modify(Posting.getNoticeSample().getId(), nameValueList);
        }
    }

    private void scrapBoard()
    {
        this.scrapService.register(Scrap.getSample());
    }

    private void replyBoard()
    {
        this.replyService.register(Comment.getSample());
    }

    private void tagBoard()
    {
        this.tagService.register(Tag.getSample());
    }

    private void voteBoard()
    {
        this.voteService.register(Vote.getSample());
    }
}
