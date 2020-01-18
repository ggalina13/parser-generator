import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;

public class Main {
    public static void main( String[] args) throws Exception
    {
        try {
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
            while (firstVisitor.changed) {
                firstVisitor.changed = false;
                firstVisitor.visit(tree);
            }
        /*for (String token : firstVisitor.firstByToken.keySet()){
            System.out.print(token + " : ");
            for (String firstEl : firstVisitor.firstByToken.get(token)){
                System.out.print(terminalVisitor.terminalByName.get(firstEl) + " ");
            }
            System.out.println();
        }*/
            //System.out.println();
            //System.out.println();
            TerminalListMakingVisitor.terminalByName.put("END", "'\\\\$'");
            TerminalListMakingVisitor.terminals.add("'\\\\$'");
            TerminalListMakingVisitor.nameByTerminal.put("'\\\\$'", "END");
            FollowMakingVisitor followVisitor = new FollowMakingVisitor();
            followVisitor.followByToken = new HashMap<>();
            followVisitor.changed = true;
            followVisitor.foundStart = false;
            while (followVisitor.changed) {
                followVisitor.changed = false;
                followVisitor.visit(tree);
            }
        /*for (String token : followVisitor.followByToken.keySet()){
            System.out.print(token + " : ");
            for (String firstEl : followVisitor.followByToken.get(token)){
                System.out.print(terminalVisitor.terminalByName.get(firstEl) + " ");
            }
            System.out.println();
        }*/
            TerminalGenerator terminalGenerator = new TerminalGenerator();
            terminalGenerator.generate();
            ParserGenerator parserGeneratorVisitor = new ParserGenerator();
            parserGeneratorVisitor.visit(tree);
            LexicalAnalyzerGenerator lexerGenerator = new LexicalAnalyzerGenerator();
            lexerGenerator.generate();
            TreeGenerator treeGenerator = new TreeGenerator();
            treeGenerator.generate();
        }
        catch (Exception e){
            System.out.println("Ochen zhal we proigrali. Try another grammar");
        }
    }
}