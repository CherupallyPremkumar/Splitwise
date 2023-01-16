package com.example.SplitWise.service;

import com.example.SplitWise.model.Balance;
import com.example.SplitWise.model.Split;
import com.example.SplitWise.model.User;
import com.example.SplitWise.model.UserExpenseBalanceSheet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceSheetManager {
    public void updateUserExpenseBalanceSheet(User paidByUser, List<Split> splitDetails, double expenseAmount) {
        UserExpenseBalanceSheet paidByUserExpenseSheet = paidByUser.getUserExpenseBalanceSheet();
        paidByUserExpenseSheet.setTotalPayment(paidByUserExpenseSheet.getTotalPayment() + expenseAmount);

        for (Split split : splitDetails) {
            User user = split.getUser();
            UserExpenseBalanceSheet userExpenseBalanceSheet = user.getUserExpenseBalanceSheet();
            double oweAmount = split.getAmountOwe();



            if (paidByUser.getUserId().equals(user.getUserId())) {
                paidByUserExpenseSheet.setTotalYourExpense(paidByUserExpenseSheet.getTotalYourExpense() + oweAmount);
            }
            else {
                paidByUserExpenseSheet.setTotalYouGetBack(paidByUserExpenseSheet.getTotalYouGetBack() + oweAmount);
                Balance userOweBalance;


                if (paidByUserExpenseSheet.getUserVsBalance().containsKey(user.getUserId())) {
                    userOweBalance = paidByUserExpenseSheet.getUserVsBalance().get(user.getUserId());
                } else {
                    userOweBalance = new Balance();
                    paidByUserExpenseSheet.getUserVsBalance().put(user.getUserId(), userOweBalance);
                }


                userOweBalance.setAmountOwe(userOweBalance.getAmountGetBack() + oweAmount);
                userExpenseBalanceSheet.setTotalYouOwe(userExpenseBalanceSheet.getTotalYouOwe() + oweAmount);
                userExpenseBalanceSheet.setTotalYourExpense(userExpenseBalanceSheet.getTotalYourExpense() + oweAmount);
                Balance userPaidBalance;


                if (userExpenseBalanceSheet.getUserVsBalance().containsKey(paidByUser.getUserId())) {
                    userPaidBalance = userExpenseBalanceSheet.getUserVsBalance().get(paidByUser.getUserId());
                } else {
                    userPaidBalance = new Balance();
                    userExpenseBalanceSheet.getUserVsBalance().put(paidByUser.getUserId(), userPaidBalance);
                }


                userPaidBalance.setAmountOwe(userPaidBalance.getAmountOwe() + oweAmount);
            }
        }


    }
}
