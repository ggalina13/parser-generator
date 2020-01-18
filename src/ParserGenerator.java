import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;

public class ParserGenerator extends GrammarOfGrammarBaseVisitor{
    String curRule;
    PrintWriter printWriter = null;
    public static String type;
    public static String nullValue;
    public static String global, superGlobal;
    public static Integer terminalNum = 0;
    HashSet<String> init = new HashSet<>();
    @Override public Void visitStart(GrammarOfGrammarParser.StartContext ctx) {
        Path dirPath =  Paths.get(TerminalListMakingVisitor.projectPath);
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
        if (ctx.getChildCount() != 2) {
            type = ctx.getChild(1).getText();
            nullValue = ctx.getChild(2).getText();
            superGlobal = ctx.getChild(4).getText().substring(1,ctx.getChild(4).getText().length() - 1) + "\n";
            global = ctx.getChild(5).getText().substring(1, ctx.getChild(5).getText().length() - 1);
            global = global.replaceAll("\n", "\n\t");
            global += "\n";
        }
        printWriter.write(generateBegin().toString());
        visitChildren(ctx);
        printWriter.write("}\n");
        printWriter.close();
        return null;
    }
    private StringBuilder generateBegin() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("import java.text.ParseException;\n" + superGlobal +
                "class Parser {\n" +
                "\t" + global +
                "\tprivate LexicalAnalyzer lex;\n" +
                "\tTree parse(String input) throws ParseException {\n" +
                "\t\tlex = new LexicalAnalyzer(input);\n" +
                "\t\tlex.nextTerminal();\n" +
                "\t\treturn parse" + FollowMakingVisitor.start +  "();\n" +
                "\t}\n");
        return  stringBuilder;
    }

    @Override public Void visitRule_(GrammarOfGrammarParser.Rule_Context ctx) {
        init = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        String tokenName = ctx.getChild(0).getText();
        curRule = "main" + tokenName;

        stringBuilder.append("");
        Integer nextChildNum = 2;
        Boolean hasEps = false;
        String lastCode = "";
        stringBuilder.append("\t//" + ctx.getText() + "\n" +
                "\tprivate Tree parse" +
                tokenName + "() throws ParseException {\n" +
                "\t\tTree " + curRule + " = new Tree(\""  + tokenName + "\");\n" +
                "\t\t" + type + " curValue = " +
                        nullValue + ";\n" +
                "\t\tswitch (lex.curTerminal()) {\n");
        while (nextChildNum < ctx.getChildCount()) {
            terminalNum = 0;
            String nextChildText = ctx.getChild(nextChildNum).getText();
            if ((nextChildText.charAt(0) == '|')){
                nextChildNum++;
                continue;
            }
            if (nextChildText.charAt(0) == '{') {
                stringBuilder.append("\t\t\t\t" + nextChildText.substring(1, nextChildText.length() - 1) + "\n");
                stringBuilder.append("\n\t\t\t\t" + curRule + ".value = curValue;\n" + "\t\t\t\treturn " + curRule + ";\n");
                printWriter.write(stringBuilder.toString());
                stringBuilder = new StringBuilder();
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
                if ((nextChildNum < ctx.getChildCount()) &&(ctx.getChild(nextChildNum).getText().charAt(0) == '{')){
                    lastCode = ctx.getChild(nextChildNum).getText();
                    nextChildNum++;
                }
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
            nextChildNum++;
            if (nextChildNum >= ctx.getChildCount() || ctx.getChild(nextChildNum).getText().charAt(0) != '{') {

                stringBuilder.append( "\n\t\t\t\t" + curRule + ".value = curValue;\n" + "\t\t\t\treturn " + curRule + ";\n");
                printWriter.write(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
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
            if (!lastCode.equals("")){
                stringBuilder.append("\t\t\t\t" + lastCode.substring(1, lastCode.length() - 1) + "\n");
            }
            stringBuilder.append( "\n\t\t\t\t" + curRule + ".value = curValue;\n");
            stringBuilder.append("\t\t\t\t" + curRule + ".addChild(new Tree(\"EPS\"));\n" +
                    "\t\t\t\treturn " + curRule + ";\n");

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
        stringBuilder.append("\t\t\t\t" + curRule + ".addChild(new Tree(\"" +
                ctx.getText().substring(1,ctx.getText().length() - 1) + "\"));\n");
        if (!init.contains("text"  + terminalNum)){
                stringBuilder.append("\t\t\t\tString text"  + terminalNum + " = lex.getTerminalText();\n" +
                "\t\t\t\tlex.nextTerminal();\n\n");
                init.add("text"  + terminalNum);
                terminalNum++;
        }
        else {
            stringBuilder.append("\t\t\t\ttext"  + terminalNum + " = lex.getTerminalText();\n" +
                    "\t\t\t\tlex.nextTerminal();\n\n");
            terminalNum++;
        }
        printWriter.write(stringBuilder.toString());
        return null;
    }
    @Override public Void visitNotTerminal(GrammarOfGrammarParser.NotTerminalContext ctx) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!init.contains(ctx.getText())) {
            stringBuilder.append("\t\t\t\tTree " + ctx.getText() + " = parse" +
                    ctx.getText() + "();\n" +
                    "\t\t\t\t" + curRule + ".addChild(" + ctx.getText() + ");\n\n");
            init.add(ctx.getText());
        }
        else {
            stringBuilder.append("\t\t\t\t" + ctx.getText() + " = parse" +
                    ctx.getText() + "();\n" +
                    "\t\t\t\t" + curRule + ".addChild(" + ctx.getText() + ");\n\n");
        }
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