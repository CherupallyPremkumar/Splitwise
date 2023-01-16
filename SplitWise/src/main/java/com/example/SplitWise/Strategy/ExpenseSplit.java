package com.example.SplitWise.Strategy;

import com.example.SplitWise.model.Split;

import java.util.List;

public interface ExpenseSplit {

    List<Split> validateSplitRequest(List<Split> splitList, double totalAmount);
}
