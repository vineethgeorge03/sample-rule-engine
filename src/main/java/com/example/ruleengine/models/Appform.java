package com.example.ruleengine.models;

import java.util.ArrayList;
import java.util.List;

public class Appform {
    private List<Applicant> applicantList = new ArrayList<>();
    private Loan loan;

    public List<Applicant> getApplicantList() {
        return applicantList;
    }

    public void setApplicantList(List<Applicant> applicantList) {
        if(this.applicantList != null) {
            this.applicantList = applicantList;
        }
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "Appform{" +
                "applicantList=" + applicantList +
                ", loan=" + loan +
                '}';
    }
}
