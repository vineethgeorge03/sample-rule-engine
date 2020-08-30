package com.example.ruleengine.controller;

import com.example.ruleengine.models.Appform;
import com.example.ruleengine.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RuleController {
    @Autowired
    private RuleService ruleService;

    @PostMapping("runRule/{lpc}")
    public ResponseEntity<Map<String, Boolean>> runRule(@PathVariable String lpc, @RequestBody Appform appform) throws NoSuchMethodException {
        Map<String, Boolean>result = ruleService.runRuleForLpc(lpc, appform);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

/*
*
*
* http://localhost:8080/runRule/CFB
{
    "applicantList": [
        {
            "age": 45,
            "addressList": [
                {
                "pincode": "753001"
                },
                {
                  "pincode": "560068"
                }
            ]
        },
        {
            "age": 26,
            "addressList": [
                {
                    "pincode": "123457"
                }
            ]
        }
    ],
    "loan": {
        "loanTenure": 5,
        "loanAmount": 10001
    }
}*/