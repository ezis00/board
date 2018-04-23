package com.spectra.board.domain.spec;

import com.spectra.board.domain.entity.User;
import com.spectra.board.domain.granule.NameValueList;

public interface UserService
{
    String regist(User userCdo);

    User find(String userId);

    User findByEmail(String title);

    void modify(String userId, NameValueList nameValueList);
}
