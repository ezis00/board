package com.spectra.board.domain.store;

import com.spectra.board.domain.entity.User;

public interface UserStore
{
    User retrieveByEmail(String email);

    void create(User userCdo);

    User retrieve(String userId);

    void update(User user);
}
