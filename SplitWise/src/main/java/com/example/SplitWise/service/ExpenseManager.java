package com.example.SplitWise.service;

import com.example.SplitWise.Strategy.ExpenseSplit;
import com.example.SplitWise.Strategy.ExpenseSplitType;
import com.example.SplitWise.Strategy.SplitFactory;
import com.example.SplitWise.model.Expense;
import com.example.SplitWise.model.Split;
import com.example.SplitWise.model.User;
import com.example.SplitWise.model.UserExpenseBalanceSheet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ExpenseManager {

    BalanceSheetManager balanceSheetManager;

    public ExpenseManager()
    {
        balanceSheetManager=new BalanceSheetManager();
    }
    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser)
    {
        log.info("entered into ExpenseManager CretaeMethod");
        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
        log.info("after completing getting condition");
        List<Split> finalSplits=expenseSplit.validateSplitRequest(splitDetails,expenseAmount);
        log.info("splitting is done based on the user request");

        Expense expense=new Expense(expenseId,description,expenseAmount,paidByUser,splitType,finalSplits);
        log.info("expense object is ceated");
       balanceSheetManager.updateUserExpenseBalanceSheet(paidByUser,finalSplits,expenseAmount);
        log.info("completed updation in ExpenseBalance Sheet");
     return expense;

    }
}
