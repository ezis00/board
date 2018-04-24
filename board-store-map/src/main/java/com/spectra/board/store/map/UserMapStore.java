package com.spectra.board.store.map;

import java.util.HashMap;
import java.util.Map;

import com.spectra.board.domain.entity.User;
import com.spectra.board.domain.store.UserStore;

public class UserMapStore implements UserStore
{
    private Map<String, User> map;

    public UserMapStore()
    {
        this.map = new HashMap<>();
    }

    @Override
    public User retrieveByEmail(String email)
    {
        return this.map.values().stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }

    @Override
    public void create(User user)
    {
        this.map.put(user.getId(), user);
    }

    @Override
    public User retrieve(String userId)
    {
        return this.map.get(userId);
    }

    @Override
    public void update(User user)
    {
        this.map.put(user.getId(), user);
    }
}
