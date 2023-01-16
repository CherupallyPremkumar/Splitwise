package com.example.SplitWise.service;

import com.example.SplitWise.Exception.NoUSerExistsException;
import com.example.SplitWise.Exception.UserAlredayExits;
import com.example.SplitWise.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserManager {
    List<User> userList;

    public UserManager() {
        userList = new ArrayList<>();
    }

    public void craeteUser(String userId, String userName) {
        for (User user : userList) {
            if (user.getUserId().equals(userId)) {
                throw new UserAlredayExits();
            }
        }
        User user = new User(userId, userName);
        userList.add(user);
    }

    public User getUser(String userId) {
        for (User user : userList) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        throw new NoUSerExistsException();
    }
    public List<User> getAlluser()
    {
        return userList;
    }

}
