package com.spectra.board.domain.store;

import com.spectra.board.domain.entity.Post;

public interface PostStore
{
    void create(Post post);

    Post retrieve(String postId);

    void update(Post post);
}
