package com.spectra.board.domain.logic;

import com.spectra.board.domain.entity.Post;
import com.spectra.board.domain.granule.NameValueList;
import com.spectra.board.domain.spec.PostService;
import com.spectra.board.domain.store.PostStore;

public class PostLogic implements PostService
{
    private PostStore postStore;

    public PostLogic(PostStore postStore)
    {
        this.postStore = postStore;
    }

    @Override
    public String register(Post postCdo)
    {
        postStore.create(postCdo);
        return postCdo.getId();
    }

    @Override
    public Post find(String postId)
    {
        return postStore.retrieve(postId);
    }

    @Override
    public void modify(String postId, NameValueList nameValueList)
    {
        Post post = find(postId);
        post.setValues(nameValueList);
        postStore.update(post);
    }
}
