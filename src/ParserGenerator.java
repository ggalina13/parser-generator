import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;

public class ParserGenerator extends GrammarOfGrammarBaseVisitor{
    PrintWriter printWriter = null;
    @Override public Void visitStart(GrammarOfGrammarParser.StartContext ctx) {
        Path dirPath =  Paths.get("/home/galina13/IdeaProjects/MPP2/GeneratedParser/src");
        try {
            Files.createDirectories(dirPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileName = "Parser.java";
        try {
            printWriter = new PrintWriter(new File(dirPath.toString(), fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        printWriter.write(generateBegin().toString());
        visitChildren(ctx);
        printWriter.write("}\n");
        printWriter.close();
        return null;
    }
    private StringBuilder generateBegin() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("import java.text.ParseException;\n" +
                "class Parser {\n" +
                "\tprivate LexicalAnalyzer lex;\n" +
                "\tTree parse(String input) throws ParseException {\n" +
                "\t\tlex = new LexicalAnalyzer(input);\n" +
                "\t\tlex.nextTerminal();\n" +
                "\t\treturn parse" + FollowMakingVisitor.start +  "();\n" +
                "\t}\n");
        return  stringBuilder;
    }

    @Override public Void visitRule_(GrammarOfGrammarParser.Rule_Context ctx) {
        StringBuilder stringBuilder = new StringBuilder();
        String tokenName = ctx.getChild(0).getText();
        stringBuilder.append("");
        Integer nextChildNum = 2;
        Boolean hasEps = false;
        stringBuilder.append("\t//" + ctx.getText() + "\n" +
                "\tprivate Tree parse" +
                tokenName + "() throws ParseException {\n" +
                "\t\tTree ret = new Tree(\""  + tokenName + "\");\n" +
                "\t\tswitch (lex.curTerminal()) {\n");
        while (nextChildNum < ctx.getChildCount()) {
            String nextChildText = ctx.getChild(nextChildNum).getText();
            if ((nextChildText.charAt(0) == '|') | (nextChildText.charAt(0) == '{')){
                nextChildNum++;
                continue;
            }
            HashSet<String> curFirst = (HashSet<String>) FirstMakingVisitor.firstByExprCtx.get(ctx.getChild(nextChildNum)).clone();
            if (curFirst.contains("EPS")){
                curFirst.remove("EPS");
                hasEps = true;
            }
            if (curFirst.isEmpty()){
                nextChildNum++;
                continue;
            }
            String condition = "\t\t\tcase ";
            boolean start = true;
            for (String terminal : curFirst){
                if (start){
                    start = false;
                } else {
                    condition += ": case ";
                }
                condition += terminal;
            }
            condition += ":\n";
            stringBuilder.append(condition);
            printWriter.write(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            visit(ctx.getChild(nextChildNum));
            stringBuilder.append("\t\t\t\treturn ret;\n");
            printWriter.write(stringBuilder.toString());
            stringBuilder = new StringBuilder();
            nextChildNum++;
        }
        HashSet <String> ruleFollow = FollowMakingVisitor.followByToken.get(tokenName);
        if (hasEps && (!ruleFollow.isEmpty())){

            stringBuilder.append("\t\t\tcase ");
            String condition = "";
            boolean start = true;
            for (String terminal : ruleFollow){
                if (start){
                    start = false;
                } else {
                    condition += ": case ";
                }
                condition += terminal;
            }
            condition += ":\n";
            stringBuilder.append(condition);
            stringBuilder.append("\t\t\t\tret.addChild(new Tree(\"EPS\"));\n");
        }
        stringBuilder.append( "\t\t\tdefault:\n" +
                "\t\t\t\tthrow new AssertionError(lex.curTerminal() + \" found as first token of S in Parser\");\n" +
                "\t\t}\n" +
                "\t}\n\n");
        printWriter.write(stringBuilder.toString());
        return  null;
    }
    @Override public Void visitTerminalExpr(GrammarOfGrammarParser.TerminalExprContext ctx) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\t\t\t\tret.addChild(new Tree(\"" +
                ctx.getText().substring(1,ctx.getText().length() - 1) + "\"));\n" +
                "\t\t\t\tlex.nextTerminal();\n\n");
        printWriter.write(stringBuilder.toString());
        return null;
    }
    @Override public Void visitNotTerminal(GrammarOfGrammarParser.NotTerminalContext ctx) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\t\t\t\tTree " + ctx.getText() + " = parse" +
                ctx.getText() + "();\n" +
                "\t\t\t\tret.addChild(" + ctx.getText() + ");\n\n");
        printWriter.write(stringBuilder.toString());
        return null;
    }
}
/*
private Tree parseS() throws ParseException {
    switch (lex.curTerminal()) {
        case VARORTYPE:
            //N
            String name = lex.getTerminalText();
            Tree var = new Tree(name);
            lex.nextTerminal();
            //E
            Tree E = parseE();
            //S
            Tree S = parseS();
            return new Tree("Str" + " (" + name + ")", E, S);
        case END:
            //ε
            return new Tree("Str", new Tree("$"));
        default:
            throw new AssertionError(lex.curTerminal() + " found as first token of S in Parser");
    }
}

 */