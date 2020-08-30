package com.example.ruleengine;


/** IGNORE s**/
import com.example.ruleengine.config.MakeAppform;
import com.example.ruleengine.models.Appform;
import com.example.ruleengine.models.Applicant;
import com.example.ruleengine.service.CustomValidators;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.List;
// "applicantList.?[#this.age > 47]"
public class SpelExp {

    public static void main(String[] args) throws NoSuchMethodException {

        MakeAppform makeAppform = new MakeAppform();
        Appform appform = makeAppform.getSampleAppform();

        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext(appform);

/*        Expression exp = parser.parseExpression("applicantList.?[#this.age > 47].size() == applicantList.size()");
        Boolean applicantList = (Boolean) exp.getValue(context);
        System.out.println(applicantList);*/
        /*Expression exp = parser.parseExpression("loan.loanTenure > 4");
        Boolean tenure = (Boolean) exp.getValue(context);
        System.out.println(tenure);*/
/*        Expression exp = parser.parseExpression("loan.loanAmount");
        Integer loanAmount = (Integer) exp.getValue(context);
        System.out.println(loanAmount);*/

        context.registerFunction("pincodeValidator", CustomValidators.class.getDeclaredMethod("pincodeValidator", List.class));
        Expression exp = parser.parseExpression("#pincodeValidator(applicantList)");
        Boolean pincodes = (Boolean)exp.getValue(context);
        System.out.println(pincodes);
/*        List<String> pincodes = new ArrayList<>();
        pincodes.addAll(Arrays.asList("753001","560001","456787"));

        System.out.println(pincodes.indexOf("7530011"));*/

    }

    static boolean validator(List<Applicant> applicants) {
        System.out.println(applicants);
        return true;
    }
}
