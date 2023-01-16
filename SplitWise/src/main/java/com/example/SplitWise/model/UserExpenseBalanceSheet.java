package com.example.SplitWise.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
@ToString
public class UserExpenseBalanceSheet {
    Map<String, Balance> userVsBalance;
     @Setter
    double totalYourExpense;

    @Getter @Setter
    double totalPayment;
   @Getter @Setter
    double totalYouOwe;
   @Getter @Setter
    double totalYouGetBack;
    public UserExpenseBalanceSheet(){

        userVsBalance = new HashMap<>();
        totalYourExpense = 0;
        totalYouOwe = 0;
        totalYouGetBack = 0;
    }
    public double getTotalYourExpense()
    {
        return totalYourExpense;
    }
    public Map<String ,Balance> getUserVsBalance()
    {
        return userVsBalance;
    }

}
