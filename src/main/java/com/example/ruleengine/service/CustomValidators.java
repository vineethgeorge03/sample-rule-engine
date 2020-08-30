package com.example.ruleengine.service;

import com.example.ruleengine.models.Address;
import com.example.ruleengine.models.Applicant;

import java.util.ArrayList;
import java.util.List;

public class CustomValidators {

   static ArrayList<String> pincodes = new ArrayList<String>() {
        {
            add("753001");
            add("560068");
            add("123456");
        }
    };
    public static Boolean pincodeValidator(List<Applicant> applicantList) {
       List<Address>  addresses = new ArrayList<>();
       /* taking out addresses of each applicant*/
       for(Applicant applicant: applicantList) {
           for(Address address: applicant.getAddressList()) {
            addresses.add(address);
           }
       }

       Boolean pincodesValid  = true;
       for(Address address: addresses) {
           Boolean validPincode = pincodes.contains(address.getPincode());
           pincodesValid = validPincode && pincodesValid;
       }
       return pincodesValid;
    }

}
