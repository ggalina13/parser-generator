import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LexicalAnalyzerGenerator {
    public void generate() throws IOException {
        Path dirPath =  Paths.get("/home/galina13/IdeaProjects/MPP2/GeneratedParser/src");
        Files.createDirectories(dirPath);
        String fileName = "LexicalAnalyzer.java";
        PrintWriter printWriter = new PrintWriter(new File(dirPath.toString(), fileName));
        printWriter.write(makeLexer().toString());
        printWriter.close();
    }
    private StringBuilder makeLexer() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("import javafx.util.Pair;\n" +
                "import java.text.ParseException;\n" +
                "import java.util.HashMap;\n" +
                "import java.util.regex.Matcher;\n" +
                "import java.util.regex.Pattern;\n\n" +
                "class LexicalAnalyzer {\n" +
                "\tprivate final String input;\n" +
                "\tprivate char curChar;\n" +
                "\tprivate int curPos;\n" +
                "\tprivate Terminal curTerminal;\n" +
                "\tprivate String curTerminalText;\n" +
                "\tLexicalAnalyzer(String input) {\n" +
                "\t\tthis.input = input;\n" +
                "\t\tcurPos = 0;\n");
        //rgxByTerminal.put(Terminal.COMMA, ",");
        for (String terminal : TerminalListMakingVisitor.terminals){
            String name = TerminalListMakingVisitor.nameByTerminal.get(terminal);
            stringBuilder.append("\t\trgxByTerminal.put(Terminal." +
                    name + ", \"" +
                    terminal.substring(1, terminal.length() - 1) + "\");\n");
        }
        stringBuilder.append("\t\tnextChar();\n" +
                "\t}\n" +
                "\tHashMap<Terminal, String> rgxByTerminal = new HashMap<Terminal, String>();\n" +
                "\tprivate void nextChar() {\n" +
                "\t\tcurChar = input.charAt(curPos++);\n" +
                "\t}\n" +
                "\tString getTerminalText() {\n" +
                "\t\treturn curTerminalText;\n" +
                "\t}\n" +
                "\tTerminal curTerminal() {\n" +
                "\t\treturn curTerminal;\n" +
                "\t}\n" +
                "\tprivate boolean isBlank(char c) {\n" +
                "\t\treturn c == ' ' || c == '\\r' || c == '\\n' || c == '\\t';\n" +
                "\t}\n" +
                "\tprivate boolean isVarOrTypeChar(char c) {\n" +
                "\t\treturn !isBlank(c) && c != ',' && c != ';' && c != '*' && c != '&';\n" +
                "\t}\n" +
                "\tPair<Integer, Integer> findFrom(String rgx, String str, Integer from){\n" +
                "\t\tPattern pattern = Pattern.compile(rgx);\n" +
                "\t\tMatcher matcher = pattern.matcher(str);\n" +
                "\t\tif (!(matcher.find(from) && matcher.start() == from))\n" +
                "\t\t\treturn null;\n" +
                "\t\telse\n" +
                "\t\t\treturn new Pair(matcher.start(), matcher.end());\n" +
                "\t}\n" +
                "\tvoid nextTerminal() throws ParseException {\n" +
                "\t\twhile ((curPos < input.length()) && isBlank(curChar)) {\n" +
                "\t\t\tnextChar();\n" +
                "\t\t}\n" +
                "\t\tBoolean found = false;\n" +
                "\t\tfor (Terminal token : Terminal.values()){\n" +
                "\t\t\tPair<Integer, Integer> tokenStartEnd = findFrom(rgxByTerminal.get(token), input, curPos - 1);\n" +
                "\t\t\tif (tokenStartEnd != null){\n" +
                "\t\t\t\tcurTerminal = token;\n" +
                "\t\t\t\tInteger curTerminalStart = tokenStartEnd.getKey();\n" +
                "\t\t\t\tInteger curTerminalEnd = tokenStartEnd.getValue();\n" +
                "\t\t\t\tcurPos = curTerminalEnd;\n" +
                "\t\t\t\tcurTerminalText = input.substring(curTerminalStart, curTerminalEnd);\n" +
                "\t\t\t\tif (curPos < input.length())\n" +
                "\t\t\t\t\tnextChar();\n" +
                "\t\t\t\t\tfound = true;\n" +
                "\t\t\t\t\tbreak;\n" +
                "\t\t\t\t}\n" +
                "\t\t}\n" +
                "\t\tif (!found)\n" +
                "\t\t\tthrow new ParseException( \"Illegal character \" + curChar, curPos) ;\n" +
                "\t}\n" +
                "}\n");

        return stringBuilder;
    }
}

/*

    void nextTerminal() throws ParseException {
        while ((curPos < input.length()) && isBlank(curChar)) {
            nextChar();
        }
        Boolean found = false;
        for (Terminal token : Terminal.values()){
            Pair<Integer, Integer> tokenStartEnd = findFrom(rgxByTerminal.get(token), input, curPos - 1);
            if (tokenStartEnd != null){
                curTerminal = token;
                Integer curTerminalStart = tokenStartEnd.getKey();
                Integer curTerminalEnd = tokenStartEnd.getValue();
                curPos = curTerminalEnd;
                curTerminalText = input.substring(curTerminalStart, curTerminalEnd);
                if (curPos < input.length())
                    nextChar();
                found = true;
                break;
            }
        }
        if (!found)
            throw new ParseException( "Illegal character " + curChar, curPos) ;
    }
}
 */