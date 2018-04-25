package com.spectra.board.domain.logic;

import java.util.List;

import com.spectra.board.domain.entity.Board;
import com.spectra.board.domain.granule.NameValueList;
import com.spectra.board.domain.spec.BoardService;
import com.spectra.board.domain.store.BoardStore;

public class BoardLogic implements BoardService
{
    private BoardStore boardStore;

    public BoardLogic(BoardStore boardStore)
    {
        this.boardStore = boardStore;
    }

    @Override
    public String register(Board board)
    {
        boardStore.create(board);
        return board.getId();
    }

    @Override
    public Board find(String boardId)
    {
        return boardStore.retrieve(boardId);
    }

    @Override
    public void modify(String boardId, NameValueList nameValueList)
    {
        Board board = find(boardId);
        board.setValues(nameValueList);
        boardStore.update(board);
    }
}
