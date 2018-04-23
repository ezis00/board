package com.spectra.board.store.map;

import java.util.HashMap;
import java.util.Map;

import com.spectra.board.domain.entity.User;
import com.spectra.board.domain.store.UserStore;

public class UserMapStore implements UserStore
{
    private Map<String, User> userMap;

    public UserMapStore()
    {
        this.userMap = new HashMap<>();
    }

    @Override
    public User retrieveByEmail(String email)
    {
        return this.userMap.values().stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }

    @Override
    public void create(User user)
    {
        this.userMap.put(user.getId(), user);
    }

    @Override
    public User retrieve(String userId)
    {
        return this.userMap.get(userId);
    }

    @Override
    public void update(User user)
    {
        this.userMap.put(user.getId(), user);
    }
}
