package com.spectra.board.domain.store;

import java.util.List;

import com.spectra.board.domain.entity.board.Posting;
import com.spectra.board.domain.granule.PostInfo;

public interface BoardStore
{
    void create(Posting posting);

    Posting retrieve(String boardId);

    void update(Posting posting);

    List<Posting> retrieveByParentPostInfo(PostInfo postInfo);
}
