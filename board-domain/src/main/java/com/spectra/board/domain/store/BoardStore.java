package com.spectra.board.domain.store;

import java.util.List;

import com.spectra.board.domain.entity.Board;
import com.spectra.board.domain.granule.PostInfo;

public interface BoardStore
{
    void create(Board board);

    Board retrieve(String boardId);

    void update(Board board);

    List<Board> retrieveByParentPostInfo(PostInfo postInfo);
}
