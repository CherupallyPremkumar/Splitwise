package com.example.SplitWise.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Split {
    User user;
    double amountOwe;
    @Getter @Setter
    int percentage;

    public Split(User user) {
        this.user = user;
        this.amountOwe = 0;
    }
    public Split(User user ,int percentage) {
        this.user = user;
        this.percentage = percentage;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmountOwe() {
        return amountOwe;
    }

    public void setAmountOwe(double amountOwe) {
        this.amountOwe = amountOwe;
    }
}
