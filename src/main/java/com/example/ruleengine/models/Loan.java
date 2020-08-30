package com.example.ruleengine.models;

public class Loan {
    private Integer loanTenure;
    private Integer loanAmount;

    public Integer getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Integer loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getLoanTenure() {
        return loanTenure;
    }

    public void setLoanTenure(Integer loanTenure) {
        this.loanTenure = loanTenure;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanTenure=" + loanTenure +
                ", loanAmount=" + loanAmount +
                '}';
    }
}
