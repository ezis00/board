package com.spectra.board.domain.store;

import java.util.List;

public interface BoardStore
{
    void create(Post post);

    Post retrieve(String postId);

    void update(Post post);

    List<Post> retrieveByChannelName(String channelName);
}
