package com.example.ruleengine.service;

import com.example.ruleengine.models.Appform;

import java.util.Map;

public interface RuleService {
    Map<String, Boolean> runRuleForLpc(String lpc, Appform appform) throws NoSuchMethodException;
}
