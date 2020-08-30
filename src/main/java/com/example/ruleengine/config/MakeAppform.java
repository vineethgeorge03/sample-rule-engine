package com.example.ruleengine.config;

import com.example.ruleengine.models.Address;
import com.example.ruleengine.models.Appform;
import com.example.ruleengine.models.Applicant;
import com.example.ruleengine.models.Loan;

import java.util.ArrayList;
import java.util.List;

public class MakeAppform {

    public Appform getSampleAppform() {

        Address address1 =  new Address();
        address1.setPincode("753001");

        Address address2 = new Address();
        address2.setPincode("560068");

        Loan loan = new Loan();
        loan.setLoanTenure(231);
        loan.setLoanAmount(24520);

        Applicant applicant1 = new Applicant();
        List<Address> addresses1 = new ArrayList<>();
        addresses1.add(address1);
        addresses1.add(address2);

        applicant1.setAddressList(addresses1);
        applicant1.setAge(27);

        List<Address> addresses2 = new ArrayList<>();
        addresses2.add(address2);

        Applicant applicant2 = new Applicant();
        applicant2.setAddressList(addresses2);
        applicant2.setAge(49);

        Appform appform = new Appform();
        List<Applicant> applicantList = new ArrayList<>();
        applicantList.add(applicant1);
        applicantList.add(applicant2);
        appform.setApplicantList(applicantList);
        appform.setLoan(loan);
        return appform;

    }
}
