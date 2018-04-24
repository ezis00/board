package com.spectra.board.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.spectra.board.domain.entity.Board;
import com.spectra.board.domain.entity.Channel;
import com.spectra.board.domain.entity.Entity;
import com.spectra.board.domain.entity.Notify;
import com.spectra.board.domain.entity.Survey;
import com.spectra.board.domain.entity.User;
import com.spectra.board.domain.granule.Attach;
import com.spectra.board.domain.granule.AttachType;
import com.spectra.board.domain.granule.BoardOptionKey;
import com.spectra.board.domain.granule.ChannelMemberIdSet;
import com.spectra.board.domain.granule.ChannelOptionKey;
import com.spectra.board.domain.granule.Level;
import com.spectra.board.domain.granule.NotifyOptionKey;
import com.spectra.board.domain.granule.SurveyAnswer;
import com.spectra.board.domain.granule.SurveyAnswerSet;
import com.spectra.board.domain.granule.SurveyAnswerType;
import com.spectra.board.domain.granule.SurveyOptionKey;
import com.spectra.board.domain.granule.SurveyOptionMap;
import com.spectra.board.domain.granule.UserType;
import com.spectra.board.domain.logic.ChannelLogic;
import com.spectra.board.domain.logic.NotifyLogic;
import com.spectra.board.domain.logic.PostLogic;
import com.spectra.board.domain.logic.UserLogic;
import com.spectra.share.util.TimeUtil;
import org.junit.Before;
import org.junit.Test;

public class BoardTest
{
    private UserLogic userLogic;
    private ChannelLogic channelLogic;
    private PostLogic postLogic;
    private NotifyLogic notifyLogic;

    private List<User> users;

    @Before
    public void setup()
    {
        this.userLogic = new UserJavaLogic();
        this.channelLogic = new ChannelJavaLogic();
        this.postLogic = new PostJavaLogic();
        this.notifyLogic = new NotifyJavaLogic();

        initUser();
    }

    private void initUser()
    {
        users = Arrays.asList(
                new User(UserType.ADMIN, "이정호", "010-2002-0014", "leejh@spectra.co.kr"),
                new User(UserType.MANAGER, "홍길동", "010-1234-5678", "hong@spectra.co.kr"),
                new User(UserType.MANAGER, "김좌진", "010-5678-1234", "kim@spectra.co.kr"),
                new User(UserType.USER, "문재인", "010-5678-4321", "moon@spectra.co.kr"),
                new User(UserType.USER, "안철수", "010-1234-6789", "ahn@spectra.co.kr"),
                new User(UserType.USER, "세종대왕", "010-0123-4567", "se@spectra.co.kr"),
                new User(UserType.USER, "이순신", "010-9012-3456", "lee@spectra.co.kr"),
                new User(UserType.USER, "김건모", "010-8901-2345", "kimo@spectra.co.kr"),
                new User(UserType.USER, "아이유", "010-7890-1234", "iu@spectra.co.kr")
        );
        for (User user : users)
        {
            this.userLogic.register(user);
        }
    }

    @Test
    public void channelTest()
    {
        Channel channel = new Channel("영업 비밀");
        channel.setMemberIdSet(new ChannelMemberIdSet(users.subList(0, 5).stream().map(Entity::getId).collect(Collectors.toSet())));
        channel.addOption(ChannelOptionKey.PRIVATE, "true");
        channel.addOption(ChannelOptionKey.ATTACH_MAX_SIZE_MB, "1000");
        channel.addOption(ChannelOptionKey.THUMBNAIL_IMAGE_ID, "thumbnail_image_id");
        channel.addOption(ChannelOptionKey.BACKGROUND_IMAGE_ID, "background_image_id");
        channelLogic.register(channel);

        surveyBoard(channel.getId());
        noticeBoard(channel.getId());


    }

    private void surveyBoard(String channelId)
    {
        User admin = users.get(0);
        Board board = new Board(channelId, admin.getId());
        board.setTitle("회식 설문조사 안내");
        board.setContents("차주에 진행되는 회식과 관련해서 아래 항목의 설문에 응답 부탁드립니다.");
        board.addBoardOption(BoardOptionKey.NOTICE, Boolean.toString(true));
        postLogic.register(board);

        surveyWhere(admin, board);
        surveyWhen(admin, board);
        surveyWhat(admin, board);
        addNotify(board);
    }

    private void surveyWhere(User admin, Board board)
    {
        SurveyOptionMap surveyOptionMap = new SurveyOptionMap();
        surveyOptionMap.put(SurveyOptionKey.ALLOW_ADD_ANSWER, Boolean.toString(true));
        surveyOptionMap.put(SurveyOptionKey.ALLOW_ANONYMOUS, Boolean.toString(true));
        SurveyAnswerSet surveyAnswerSet = new SurveyAnswerSet();
        surveyAnswerSet.add(new SurveyAnswer(SurveyAnswerType.IMAGE, "A식당 사진"));
        surveyAnswerSet.add(new SurveyAnswer(SurveyAnswerType.IMAGE, "B식당 사진"));
        surveyAnswerSet.add(new SurveyAnswer(SurveyAnswerType.IMAGE, "C식당 사진"));
        postLogic.register(new Survey(board.getCurrentPostInfo(), "금주 회식 장소 조사", surveyOptionMap, surveyAnswerSet, TimeUtil.getTime("20180431120000"), admin.getId()));
    }

    private void surveyWhen(User admin, Board board)
    {
        SurveyOptionMap surveyOptionMap = new SurveyOptionMap();
        surveyOptionMap.put(SurveyOptionKey.ALLOW_ANONYMOUS, Boolean.toString(true));
        surveyOptionMap.put(SurveyOptionKey.ALLOW_MULTI_SELECT, Boolean.toString(true));
        SurveyAnswerSet surveyAnswerSet = new SurveyAnswerSet();
        surveyAnswerSet.add(new SurveyAnswer(SurveyAnswerType.DATE, "20180509"));
        surveyAnswerSet.add(new SurveyAnswer(SurveyAnswerType.DATE, "20180510"));
        surveyAnswerSet.add(new SurveyAnswer(SurveyAnswerType.DATE, "20180511"));
        postLogic.register(new Survey(board.getCurrentPostInfo(), "금주 회식 날짜 조사", surveyOptionMap, surveyAnswerSet, TimeUtil.getTime("20180431120000"), admin.getId()));
    }

    private void surveyWhat(User admin, Board board)
    {
        SurveyOptionMap surveyOptionMap = new SurveyOptionMap();
        surveyOptionMap.put(SurveyOptionKey.ALLOW_ADD_ANSWER, Boolean.toString(true));
        surveyOptionMap.put(SurveyOptionKey.ALLOW_ANONYMOUS, Boolean.toString(true));
        surveyOptionMap.put(SurveyOptionKey.ALLOW_MULTI_SELECT, Boolean.toString(true));
        SurveyAnswerSet surveyAnswerSet = new SurveyAnswerSet();
        surveyAnswerSet.add(new SurveyAnswer(SurveyAnswerType.IMAGE, "돼지 사진"));
        surveyAnswerSet.add(new SurveyAnswer(SurveyAnswerType.IMAGE, "소 사진"));
        surveyAnswerSet.add(new SurveyAnswer(SurveyAnswerType.IMAGE, "물고기 사진"));
        postLogic.register(new Survey(board.getCurrentPostInfo(), "금주 회식 메뉴 조사", surveyOptionMap, surveyAnswerSet, TimeUtil.getTime("20180431120000"), admin.getId()));
    }

    private void addNotify(Board board)
    {
        Notify notify = new Notify(board.getCurrentPostInfo(), "20180424120000", "20180428120000", Arrays.asList(Level.EMAIL, Level.SMS));
        notify.addNotifyOption(NotifyOptionKey.REPORT_ME_FLAG, Boolean.toString(true));
        notifyLogic.register(notify);
    }

    private void noticeBoard(String channelId)
    {
        User admin = users.get(0);
        Board board = new Board(channelId, admin.getId());
        board.setTitle("사내 보안 프로그램 패치 공유");
        board.setContents("아래 보안 프로그램을 꼭 설치 부탁드립니다..");
        board.addBoardOption(BoardOptionKey.NOTICE, Boolean.toString(true));
        board.addAttach(new Attach(AttachType.EXE, "보안프로그램패치파일"));
        postLogic.register(board);
    }

    public void privateBoard(String channelId)
    {
        User admin = users.get(0);
        Board board = new Board(channelId, admin.getId());
        board.setTitle("작성중");
        board.setContents("작성중인 글입니다.");
        board.addBoardOption(BoardOptionKey.PRIVATE, Boolean.toString(true));
        postLogic.register(board);
    }
}
