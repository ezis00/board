package com.spectra.board.store.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spectra.board.domain.store.BoardStore;

public class BoardMapStore implements BoardStore
{
    private Map<String, Board> map;

    public BoardMapStore()
    {
        this.map = new HashMap<>();
    }

    @Override
    public void create(Board board)
    {
        this.map.put(board.getId(), board);
    }

    @Override
    public Board retrieve(String boardId)
    {
        return this.map.get(boardId);
    }

    @Override
    public List<Board> retrieveByChannelName(String channelName)
    {
        return this.map.values().stream().filter(channel -> ch);
    }

    @Override
    public void update(Board board)
    {
        this.map.put(board.getId(), board);
    }
}
