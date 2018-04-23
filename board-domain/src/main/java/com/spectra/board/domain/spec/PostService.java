package com.spectra.board.domain.spec;

import com.spectra.board.domain.entity.Post;
import com.spectra.board.domain.granule.NameValueList;

public interface PostService
{
    String register(Post post);

    Post find(String postId);

    void modify(String postId, NameValueList nameValueList);
}
