package com.example.SplitWise.model;

import com.example.SplitWise.Strategy.ExpenseSplitType;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    String expenseId;
    String description;
    double expenseAmount;
    User paidbyUser;
    ExpenseSplitType splitType;

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId='" + expenseId + '\'' +
                ", description='" + description + '\'' +
                ", expenseAmount=" + expenseAmount +
                ", paidbyUser=" + paidbyUser +
                ", splitType=" + splitType +
                ", splitDetails=" + splitDetails +
                '}';
    }

    @Getter
    List<Split> splitDetails=new ArrayList<>();

    public Expense(String expenseId, String description, double expenseAmount, User paidbyUser, ExpenseSplitType splitType, List<Split> splitDetails) {
        this.expenseId = expenseId;
        this.description = description;
        this.expenseAmount = expenseAmount;
        this.paidbyUser = paidbyUser;
        this.splitType = splitType;
        this.splitDetails.addAll(splitDetails);
    }
}
