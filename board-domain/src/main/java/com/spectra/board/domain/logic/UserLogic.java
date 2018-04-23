package com.spectra.board.domain.logic;

import com.spectra.board.domain.entity.User;
import com.spectra.board.domain.granule.NameValueList;
import com.spectra.board.domain.spec.UserService;
import com.spectra.board.domain.store.UserStore;

public class UserLogic implements UserService
{
    private UserStore userStore;

    public UserLogic(UserStore userStore)
    {
        this.userStore = userStore;
    }

    @Override
    public String regist(User userCdo)
    {
        User user = userStore.retrieveByEmail(userCdo.getEmail());
        if (user != null)
        {
            throw new RuntimeException("Already Exist title:" + userCdo.getEmail());
        }
        userStore.create(userCdo);
        return userCdo.getId();
    }

    @Override
    public User find(String userId)
    {
        return userStore.retrieve(userId);
    }

    @Override
    public User findByEmail(String title)
    {
        return userStore.retrieveByEmail(title);
    }

    @Override
    public void modify(String userId, NameValueList nameValueList)
    {
        User user = find(userId);
        user.setValues(nameValueList);
        userStore.update(user);
    }
}
