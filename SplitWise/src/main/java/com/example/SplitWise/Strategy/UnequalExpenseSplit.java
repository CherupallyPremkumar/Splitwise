package com.example.SplitWise.Strategy;

import com.example.SplitWise.model.Split;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UnequalExpenseSplit implements ExpenseSplit{
    @Override
    public List<Split> validateSplitRequest(List<Split> splitList, double totalAmount) {
        return null;
    }
}
