package com.example.ruleengine.service;

import com.example.ruleengine.config.MakeAppform;
import com.example.ruleengine.models.Appform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RuleServiceImpl implements RuleService{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Boolean> runRuleForLpc(String lpc, Appform appform) throws NoSuchMethodException {

        List<Integer> ruleIdsForLpc = getRulesIdsForLpcFromDb(lpc);
        List<String> rulesForLpc = getRulesForLpcFromDb(ruleIdsForLpc);
       //  Appform appform =  getSampleAppform();

        return parseRules(appform, rulesForLpc);

    }

    private List<Integer> getRulesIdsForLpcFromDb(String lpc) {
        String ruleIdsquery = "SELECT rule_id from rules_lpc where lpc = ?";
        List<Integer> ruleIdsForLpc = new ArrayList<>();
        jdbcTemplate.query(ruleIdsquery, new Object[] {lpc}, (rs, rowNum) -> ruleIdsForLpc.add(rs.getInt("rule_id")));
        return ruleIdsForLpc;
    }

    private List<String> getRulesForLpcFromDb(List<Integer> ruleIdsForLpc) {
        String inSql = String.join(",", Collections.nCopies(ruleIdsForLpc.size(), "?"));
        String rulesQuery = String.format("SELECT rule from rules  where id in (%s)", inSql);

        List<String> rules = new ArrayList<>();
        jdbcTemplate.query(rulesQuery, ruleIdsForLpc.toArray(), (rs, rowNum) -> rules.add(rs.getString("rule")));
        return rules;
    }

    private Appform getSampleAppform() {
        return new MakeAppform().getSampleAppform();
    }

    private Map<String, Boolean> parseRules(Appform appform, List<String> rules) throws NoSuchMethodException {
        Map<String,Boolean> ruleStatus = new HashMap<>();
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(appform);
        context.registerFunction("pincodeValidator", CustomValidators.class.getDeclaredMethod("pincodeValidator", List.class));
        Boolean hasAllRulesPassed = true;
        for(String rule: rules) {
            Expression exp = parser.parseExpression(rule);
            Boolean passed = (Boolean) exp.getValue(context);
            ruleStatus.put(rule, passed);
            hasAllRulesPassed = hasAllRulesPassed && passed;
            System.out.println("rule status: " + passed + " " + rule);
        }
        ruleStatus.put("overallStatus", hasAllRulesPassed);
        return ruleStatus;
    }
}
