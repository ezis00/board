package com.spectra.board.domain.spec;

import java.util.List;

import com.spectra.board.domain.granule.NameValueList;

public interface ReplyService
{
    String register(Post post);

    Post find(String postId);

    List<Post> findByChannelName(String channelName);

    void modify(String postId, NameValueList nameValueList);
}
