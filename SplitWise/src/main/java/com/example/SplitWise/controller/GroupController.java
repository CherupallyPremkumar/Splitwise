package com.example.SplitWise.controller;

import com.example.SplitWise.Strategy.ExpenseSplitType;
import com.example.SplitWise.model.Expense;
import com.example.SplitWise.model.Group;
import com.example.SplitWise.model.Split;
import com.example.SplitWise.model.User;
import com.example.SplitWise.service.ExpenseManager;
import com.example.SplitWise.service.GroupManager;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController

public class GroupController {
    @Autowired
    private GroupManager groupManager;


    private Group group;

    @RequestMapping(value = "/createGroup",method = RequestMethod.POST)
    public ResponseEntity createGroup(String groupId ,String groupName, @NonNull User createdbtUser)
    {
        groupManager.createGroup(groupId,groupName,createdbtUser);
        return ResponseEntity.ok("created_Group");
    } @RequestMapping(value = "/getGroup",method = RequestMethod.GET)
    public Group getGroup(String groupId )
    {
        return groupManager.getGroup(groupId);

    }
    @RequestMapping(value = "/createExpence",method = RequestMethod.POST)
    public void createExpence( String groupId,String expenseId, String description, double expenseAmount, ExpenseSplitType expenseSplitType, User paidByUser )
    {
         groupManager.createExpense(groupId, expenseId,description, expenseAmount, expenseSplitType,paidByUser);

    }
    @RequestMapping(value = "/addUserToGroup",method = RequestMethod.POST)
    public ResponseEntity addUserToGroup(String groupId,User user )
    {
         groupManager.addUserToGroup(groupId,user);
         return ResponseEntity.ok("added USer");

    }@RequestMapping(value = "/SplitListUser",method = RequestMethod.POST)
    public ResponseEntity SplitListUser(String groupId,User user )
    {
        groupManager.SplitListUser(groupId,user);
         return ResponseEntity.ok("added USer");
    }@RequestMapping(value = "/SplitListUserPercentage",method = RequestMethod.POST)
    public ResponseEntity SplitListUserPercentage(String groupId,User user,int percentage)
    {
        groupManager.SplitListUserPercentage(groupId,user,percentage);
         return ResponseEntity.ok("added USer");
    }
}
