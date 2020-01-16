import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TerminalListMakingVisitor extends GrammarOfGrammarBaseVisitor {
    public static HashSet<String> terminals = new HashSet<String>();
    public static HashMap <String, String> nameByTerminal = new HashMap<>();
    public static HashMap <String, String> terminalByName = new HashMap<>();
    public static HashSet<String> notTerminals = new HashSet<String>();
    Integer lastTerminalNum = 0;

    /*@Override public String visitTerminalRule(GrammarOfGrammarParser.TerminalRuleContext ctx) {
        String tokenName = ctx.getChild(0).getText();
        String rgx = ctx.getChild(2).getText();
        rgx = rgx.substring(1, rgx.length() - 1);
        terminals.add(tokenName);
        rgxByTerminal.put(tokenName, rgx);
        return "";
    }*/
    @Override public String visitTerminalExpr(GrammarOfGrammarParser.TerminalExprContext ctx) {
        String terminal = ctx.getChild(0).getText();
        String terminalName;
        if (terminal.equals("''")){
            terminalName = "EPS";
        }
        else {
            terminalName = "T_" + lastTerminalNum++;
        }
        terminals.add(terminal);
        nameByTerminal.put(terminal, terminalName);
        terminalByName.put(terminalName, terminal);
        //System.out.println(ctx.getChild(0).getText());
        return (String) visitChildren(ctx);
    }
    @Override public String visitNotTerminal(GrammarOfGrammarParser.NotTerminalContext ctx) {
        notTerminals.add(ctx.getText());
        return (String) visitChildren(ctx);
    }
}
