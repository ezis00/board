package com.spectra.board.domain.spec;

import com.spectra.board.domain.entity.User;
import com.spectra.board.domain.share.granule.NameValueList;

public interface UserService
{
    String register(User user);

    User find(String userId);

    User findByEmail(String title);

    void modify(String userId, NameValueList nameValueList);
}
