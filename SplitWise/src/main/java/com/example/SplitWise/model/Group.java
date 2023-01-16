package com.example.SplitWise.model;

import com.example.SplitWise.Strategy.ExpenseSplitType;
import com.example.SplitWise.service.ExpenseManager;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Setter
public class Group {

    ExpenseManager expenseManager;
    @Getter
    @Setter
    String groupId;
    @Getter
    @Setter
    String groupName;
    List<User> groupMembers;
    List<Expense> expenseList;

    public Group() {
        groupMembers = new ArrayList<>();
        expenseList = new ArrayList<>();
        expenseManager = new ExpenseManager();
    }


    public void addMembers(User memeber) {
        groupMembers.add(memeber);
    }

    public void addExpense(Expense expense) {
        expenseList.add(expense);
    }

    @Override
    public String toString() {
        return "Group{" +
                "expenseManager=" + expenseManager +
                ", groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", groupMembers=" + groupMembers +
                ", expenseList=" + expenseList +
                '}';
    }
}
