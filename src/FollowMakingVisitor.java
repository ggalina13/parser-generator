import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.HashSet;

public class FollowMakingVisitor extends GrammarOfGrammarBaseVisitor {
    public static Boolean changed;
    public static HashMap<String, HashSet<String>> followByToken;
    public static Boolean foundStart;
    public static String start = "";

    public ParseTree findRightmostToken(GrammarOfGrammarParser.ExprContext ctx){
        if (ctx.getChildCount() == 1) {
            if (!TerminalListMakingVisitor.notTerminals.contains(ctx.getChild(0).getChild(0).getText()))
                return null;
            else
                return ctx.getChild(0).getChild(0);
        }
        if (ctx.getChildCount() == 2){
            ParseTree foundToken = findRightmostToken((GrammarOfGrammarParser.ExprContext) ctx.getChild(1));
            return foundToken;
            //if (foundToken == null){
            //    findRightmostToken((GrammarOfGrammarParser.ExprContext) ctx.getChild(0));
            //}
        }
        if (ctx.getChildCount() == 3){
            return findRightmostToken((GrammarOfGrammarParser.ExprContext) ctx.getChild(1));
        }
        return null;
    }

    public ParseTree findLefter(ParseTree ctx){
        ParseTree cur = ctx;
        cur = cur.getParent();
        while (true) {
            if (cur.getChildCount() > 2 && cur.getChild(1).getText() == ":")
                return null;
            if (cur.getChildCount() == 2){
                return findRightmostToken((GrammarOfGrammarParser.ExprContext) cur.getChild(0));
            }
            cur = cur.getParent();
        }
    }
    @Override public HashSet<String> visitExpr(GrammarOfGrammarParser.ExprContext ctx) {
        //expr : token |
        //        '(' expr ')' |
        //        expr expr;
        if (ctx.getChildCount() == 2) {
            //expr : expr expr;
            GrammarOfGrammarParser.ExprContext leftExprCtx = (GrammarOfGrammarParser.ExprContext) ctx.getChild(0);
            ParseTree rightMostTokenCtx = findRightmostToken(leftExprCtx);
            if (rightMostTokenCtx == null) // A -> (B ';') (C D)
                return null;
            String rightMostToken = rightMostTokenCtx.getText();
            GrammarOfGrammarParser.ExprContext nextCtx = (GrammarOfGrammarParser.ExprContext) ctx.getChild(1);
            HashSet<String> nextFirst = (HashSet<String>) FirstMakingVisitor.firstByExprCtx.get(nextCtx).clone();
            if (!followByToken.containsKey(rightMostToken)){
                followByToken.put(rightMostToken, new HashSet<>());
            }
            nextFirst.removeAll(followByToken.get(rightMostToken));
            if (nextFirst.contains("EPS"))
                nextFirst.remove("EPS");
            if (!nextFirst.isEmpty()){ //FOLLOW[B] ∪= FIRST(γ)∖{ε}
                followByToken.get(rightMostToken).addAll(nextFirst);
                changed = true;
            }
        }
        return (HashSet<String>) visitChildren(ctx);
    }

    @Override public HashSet<String> visitRule_(GrammarOfGrammarParser.Rule_Context ctx){
        String tokenName = ctx.getChild(0).getText();
        if (!foundStart){
            foundStart = true;
            start = tokenName;
            followByToken.put(tokenName, new HashSet<>());
            followByToken.get(tokenName).add("END");
        }
        Integer nextChildNum = 2;
        while (nextChildNum < ctx.getChildCount()){
            String curChildText = ctx.getChild(nextChildNum).getText();
            if ((curChildText.charAt(0) == '{') || (curChildText.charAt(0) == '|')){
                nextChildNum++;
                continue;
            }
            //HashSet<String> curChildFirst = FirstMakingVisitor.firstByExprCtx.get(ctx.getChild(nextChildNum));
            // if ε ∈ FIRST(γ)
            //    FOLLOW[B] ∪= FOLLOW[A]
            ParseTree rightMostTokenCtx = findRightmostToken((GrammarOfGrammarParser.ExprContext) ctx.getChild(nextChildNum));
            if (rightMostTokenCtx == null) {
                nextChildNum++;
                continue;
            }
            String rightMostToken = rightMostTokenCtx.getText();
            while (true) {
                if (rightMostToken == null)
                    break;
                HashSet<String> rightTokenFirst = (HashSet<String>) FirstMakingVisitor.firstByToken.get(rightMostToken).clone();
                if (!followByToken.containsKey(rightMostToken)) {
                    followByToken.put(rightMostToken, new HashSet<>());
                }
                if (followByToken.containsKey(tokenName)) { //
                    HashSet<String> mainTokenFollow = (HashSet<String>) followByToken.get(tokenName).clone();
                    mainTokenFollow.removeAll(followByToken.get(rightMostToken));
                    if (!mainTokenFollow.isEmpty()) {
                        changed = true;
                        followByToken.get(rightMostToken).addAll(mainTokenFollow);
                    }
                }
                if (!rightTokenFirst.contains("EPS"))
                    break;
                rightMostTokenCtx = findLefter(rightMostTokenCtx);
                rightMostToken = rightMostTokenCtx.getText();
            }
            nextChildNum ++;
        }
        return (HashSet<String>) visitChildren(ctx);
    }
}
