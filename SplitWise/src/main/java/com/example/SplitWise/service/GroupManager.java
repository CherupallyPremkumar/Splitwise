package com.example.SplitWise.service;

import com.example.SplitWise.Exception.NOGroupExistsException;
import com.example.SplitWise.Strategy.ExpenseSplitType;
import com.example.SplitWise.model.Expense;
import com.example.SplitWise.model.Group;
import com.example.SplitWise.model.Split;
import com.example.SplitWise.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@Service
@Slf4j
public class GroupManager {

    List<Group> groupList;
    static List<Split> splits;
    @Autowired
    ExpenseManager expenseManager;

    GroupManager() {

        groupList = new ArrayList<>();
        splits = new ArrayList<>();
    }

    public void createGroup(String groupId, String groupName, User createdUser) {
        Group group = new Group();
        group.setGroupId(groupId);
        group.setGroupName(groupName);
        group.addMembers(createdUser);
        groupList.add(group);
    }

    public Group getGroup(String groupId) {

        for (Group group : groupList) {
            if (group.getGroupId().equals(groupId)) {
                return group;
            }
        }
        throw new NOGroupExistsException();
    }

    public void addUserToGroup(String groupId, User user) {
        for (Group group : groupList) {
            if (Objects.equals(group.getGroupId(), groupId)) {
                System.out.println(group.getGroupId());
                group.addMembers(user);
            }
        }

    }

    public void createExpense(String groupId, String expenseId, String description, double expenseAmount, ExpenseSplitType expenseSplitType, User paidByUser) {
        log.info("entered into createExpense");
        Expense expense = expenseManager.createExpense(expenseId, description, expenseAmount, splits, expenseSplitType, paidByUser);
        log.info("expense is created");
        for (Group group : groupList) {
            if (group.getGroupId().equals(groupId)) {
                group.addExpense(expense);
            }
        }
        splits=new ArrayList<>();
    }

    public Split SplitListUser(String groupId, User user) {
        log.info("intered into Split method");
        System.out.println(user.getUserId());
        Split splitss = new Split(user);
        splits.add(splitss);
        log.info("user is Added to the List");
        return splitss;
    }

    public Split SplitListUserPercentage(String groupId, User user, int percentage) {
        log.info("intered into Split method");
        System.out.println(user.getUserId());
        Split splitss = new Split(user,percentage);
        splits.add(splitss);
        log.info("user is Added to the List");
        return splitss;
    }
}
