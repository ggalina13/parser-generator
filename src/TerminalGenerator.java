import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TerminalGenerator {
    public void generate() throws IOException {
        Path dirPath =  Paths.get(TerminalListMakingVisitor.projectPath);
        Files.createDirectories(dirPath);
        String fileName = "Terminal.java";
        PrintWriter printWriter = new PrintWriter(new File(dirPath.toString(), fileName));
        printWriter.write(makeTerminal().toString());
        printWriter.close();
    }
    private StringBuilder makeTerminal(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("public enum Terminal {\n");
        String terminalEnum = "\t";
        boolean start = true;
        for (String terminal : TerminalListMakingVisitor.terminals){
            if (terminal.equals("''"))
                continue;
            if (!start){
                terminalEnum += ", ";
            }
            start = false;
            terminalEnum += TerminalListMakingVisitor.nameByTerminal.get(terminal);
        }
        stringBuilder.append(terminalEnum + "\n");
        stringBuilder.append("}");
        return stringBuilder;
    }
}
