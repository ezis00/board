package com.spectra.board.store.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.spectra.board.domain.entity.Board;
import com.spectra.board.domain.granule.PostInfo;
import com.spectra.board.domain.store.BoardStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardMapStore implements BoardStore
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Map<String, Board> map;

    public BoardMapStore()
    {
        this.map = new HashMap<>();
    }

    @Override
    public void create(Board board)
    {
        logger.info(board.toString());
        this.map.put(board.getId(), board);
    }

    @Override
    public Board retrieve(String boardId)
    {
        return this.map.get(boardId);
    }

    @Override
    public void update(Board board)
    {
        this.map.put(board.getId(), board);
    }

    @Override
    public List<Board> retrieveByParentPostInfo(PostInfo postInfo)
    {
        logger.info(postInfo.toString());
        for (Board board : new ArrayList<>(this.map.values()))
        {
            logger.info(board.getParentPostInfo().toString());
        }
        return this.map.values().stream().filter(board -> board.getParentPostInfo().equals(postInfo)).collect(Collectors.toList());
    }
}
