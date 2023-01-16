package com.example.SplitWise.model;


import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

@Getter

@ToString
public class User {
    private String userId;
    private String userName;
    @Autowired
    private UserExpenseBalanceSheet userExpenseBalanceSheet;

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        userExpenseBalanceSheet=new UserExpenseBalanceSheet();
    }
}
