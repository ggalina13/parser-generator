import java.util.HashMap;
import java.util.HashSet;

public class FollowMakingVisitor extends GrammarOfGrammarBaseVisitor {
    public static Boolean changed;
    public static HashMap<String, HashSet<String>> followByToken;
    @Override public HashSet<String> visitExpr(GrammarOfGrammarParser.ExprContext ctx) {
        //expr : token |
        //        '(' expr ')' |
        //        expr expr;
        if (ctx.getChildCount() == 2){
            //expr : expr expr;
            if (ctx.getChild(0).getChildCount() == 1){
                //expr : token;
                String tokenName = ctx.getChild(0).getChild(0).getText();
                //take first of next expr
                HashSet<String> nextFollow = FirstMakingVisitor.firstByExprCtx.get(ctx.getChild(1));
                if (!followByToken.containsKey(tokenName)){
                    followByToken.put(tokenName, new HashSet<>());
                }
                nextFollow.removeAll(followByToken.get(tokenName));
            }
        }
        return null;
    }
}
