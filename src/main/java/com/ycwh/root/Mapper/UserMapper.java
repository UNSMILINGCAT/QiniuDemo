package com.ycwh.root.Mapper;

import com.ycwh.root.POJO.User;

public interface UserMapper
{
    User select(String userName);

    void insert(User user);

    void update(User user);
}
