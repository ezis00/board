package com.spectra.board.store.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.spectra.board.domain.entity.board.Posting;
import com.spectra.board.domain.granule.PostInfo;
import com.spectra.board.domain.store.BoardStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardMapStore implements BoardStore
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Map<String, Posting> map;

    public BoardMapStore()
    {
        this.map = new HashMap<>();
    }

    @Override
    public void create(Posting posting)
    {
        logger.info(posting.toString());
        this.map.put(posting.getId(), posting);
    }

    @Override
    public Posting retrieve(String boardId)
    {
        logger.info(boardId);
        return this.map.get(boardId);
    }

    @Override
    public void update(Posting posting)
    {
        this.map.put(posting.getId(), posting);
    }

    @Override
    public List<Posting> retrieveByParentPostInfo(PostInfo postInfo)
    {
        logger.info(postInfo.toString());
        for (Posting posting : new ArrayList<>(this.map.values()))
        {
            logger.info(posting.getParentPostInfo().toString());
        }
        return this.map.values().stream().filter(board -> board.getParentPostInfo().equals(postInfo)).collect(Collectors.toList());
    }
}
