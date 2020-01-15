import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;

public class Main {
    public static void main( String[] args) throws Exception
    {
        GrammarOfGrammarLexer lexer = new GrammarOfGrammarLexer(CharStreams.fromFileName("/home/galina13/IdeaProjects/MT/parserGenerator2/src/input.txt"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarOfGrammarParser parser = new GrammarOfGrammarParser(tokens);
        ParseTree tree = parser.start();
        TerminalListMakingVisitor terminalVisitor = new TerminalListMakingVisitor();
        terminalVisitor.visit(tree);
        FirstMakingVisitor firstVisitor = new FirstMakingVisitor();
        firstVisitor.firstByToken = new HashMap<>();
        firstVisitor.firstByExprCtx = new HashMap<>();
        firstVisitor.changed = true;
        while (firstVisitor.changed){
            firstVisitor.changed = false;
            firstVisitor.visit(tree);
        }
        for (String token : firstVisitor.firstByToken.keySet()){
            System.out.print(token + " : ");
            for (String firstEl : firstVisitor.firstByToken.get(token)){
                System.out.print(terminalVisitor.terminalByName.get(firstEl) + " ");
            }
            System.out.println();
        }
        FollowMakingVisitor followVisitor = new FollowMakingVisitor();
        followVisitor.followByToken = new HashMap<>();
        followVisitor.changed = true;
        while (followVisitor.changed){
            followVisitor.changed = false;
            followVisitor.visit(tree);
        }
    }
}