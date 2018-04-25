package com.spectra.board.domain.spec;

import java.util.List;

import com.spectra.board.domain.entity.Board;
import com.spectra.board.domain.granule.NameValueList;

public interface BoardService
{
    String register(Board board);

    Board find(String boardId);

    void modify(String boardId, NameValueList nameValueList);
}
