import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FirstMakingVisitor extends GrammarOfGrammarBaseVisitor<HashSet<String>> {
    public static Boolean changed;
    public static HashMap<String, HashSet<String>> firstByToken;
    public static HashMap<GrammarOfGrammarParser.ExprContext, HashSet<String>> firstByExprCtx;
    public static HashSet<String> hasEpsilonRuleTokens;
    /*@Override public HashSet<String> visitStrings(GrammarOfGrammarParser.StringsContext ctx) {
        changed = true;
        while (changed) {
            changed = false;
            visitChildren(ctx);
        }
        return null;
    }*/
    @Override public HashSet<String> visitRule_(GrammarOfGrammarParser.Rule_Context ctx) {
        String tokenName = ctx.getChild(0).getText();
        Integer nextChildNum = 2;
        while (nextChildNum < ctx.getChildCount()){
            HashSet<String> curChildText = (HashSet<String>) visit(ctx.getChild(nextChildNum)).clone();
            nextChildNum += 2;
            if (!firstByToken.containsKey(tokenName)){
                firstByToken.put(tokenName, new HashSet<>());
            }
            curChildText.removeAll(firstByToken.get(tokenName));
            if (!curChildText.isEmpty()) {
                firstByToken.get(tokenName).addAll(curChildText);
                changed = true;
            }
        }
        return null;
    }
    @Override public HashSet<String> visitExpr(GrammarOfGrammarParser.ExprContext ctx) {
        //expr : token |
        //        '(' expr ')' |
        //        expr expr;
        HashSet<String> ret1 = new HashSet<>();
        HashSet<String> ret2 = new HashSet<>();
        switch (ctx.getChildCount()){
            case 1:
                ret1 = visit(ctx.getChild(0));
                break;
            case 2: {
                ret1 = visit(ctx.getChild(0));
                ret2 = visit(ctx.getChild(1));
                if (ret1.contains("''")){
                    ret1.remove("''");
                    ret1.addAll(ret2);
                }
                break;
            }
            case 3:
                ret1 = visit(ctx.getChild(1));
                break;
        }
        firstByExprCtx.put(ctx, ret1);
        return ret1;
    }

    @Override public HashSet<String> visitTerminalExpr(GrammarOfGrammarParser.TerminalExprContext ctx) {
        HashSet<String> ret = new HashSet<>();
        ret.add(TerminalListMakingVisitor.nameByTerminal.get(ctx.getChild(0).getText()));
        return ret;
    }

    @Override public HashSet<String> visitNotTerminal(GrammarOfGrammarParser.NotTerminalContext ctx) {
        String tokenName = ctx.getText();
        if (!firstByToken.containsKey(tokenName))
            return new HashSet<String>();
        HashSet<String> ret = firstByToken.get(tokenName);
        return ret;
    }

    /*@Override public HashSet<String> visitTerminalRule(GrammarOfGrammarParser.TerminalRuleContext ctx) {
        String tokenName = ctx.getChild(0).getText();
        String terminalRgx = ctx.getChild(2).getText();
        String terminalName = TerminalListMakingVisitor.nameByTerminal.get(terminalRgx);
        if (firstByToken.containsKey(tokenName))
            firstByToken.get(tokenName).add(terminalName);
        else {
            changed = true;
            HashSet <String> a = new HashSet<>();
            a.add(terminalName);
            firstByToken.put(tokenName, a);
        }
        return null;
    }*/
}
