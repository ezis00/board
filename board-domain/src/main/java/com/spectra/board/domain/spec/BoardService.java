package com.spectra.board.domain.spec;

import java.util.List;

import com.spectra.board.domain.entity.board.Posting;
import com.spectra.board.domain.granule.PostInfo;
import com.spectra.board.domain.share.granule.NameValueList;

public interface BoardService
{
    String register(Posting posting);

    Posting find(String boardId);

    void modify(String boardId, NameValueList nameValueList);

    List<Posting> findByParentPostInfo(PostInfo postInfo);
}
