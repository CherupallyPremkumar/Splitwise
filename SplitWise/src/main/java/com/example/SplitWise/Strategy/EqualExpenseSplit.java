package com.example.SplitWise.Strategy;

import com.example.SplitWise.model.Split;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Slf4j
public class EqualExpenseSplit implements ExpenseSplit{
    @Override
    public List<Split> validateSplitRequest(List<Split> splitList, double totalAmount) {
        log.info("entered into ValisSplitReqestmethod");
        double amountShouldBePresent = totalAmount/splitList.size();
        log.info("executed conition");
        for(Split split: splitList) {
            split.setAmountOwe(amountShouldBePresent);
        }
        log.info("end of the method");
        return splitList;
    }
}
