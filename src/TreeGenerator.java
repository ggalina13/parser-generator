import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TreeGenerator {
    public void generate() throws IOException {
        Path dirPath =  Paths.get(TerminalListMakingVisitor.projectPath);
        Files.createDirectories(dirPath);
        String fileName = "Tree.java";
        PrintWriter printWriter = new PrintWriter(new File(dirPath.toString(), fileName));
        printWriter.write(makeTree().toString());
        printWriter.close();
    }
    private StringBuilder makeTree() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("import java.io.BufferedWriter;\n" +
                "import java.io.File;\n" +
                "import java.io.IOException;\n" +
                "import java.nio.charset.StandardCharsets;\n" +
                "import java.nio.file.Files;\n" +
                "import java.nio.file.Path;\n" +
                "import java.nio.file.Paths;\n" +
                "import java.util.ArrayList;\n" +
                "import java.util.Arrays;\n" +
                "import java.util.List;\n" +
                "public class Tree {\n" +
                "\tpublic " + ParserGenerator.type + " value;\n" +
                "\tprivate final List<Tree> children;\n" +
                "\tpublic final String name;\n" +
                "\tTree(String name) {\n" +
                "\t\tthis.name = name;\n" +
                "\t\tthis.value = " + ParserGenerator.nullValue + ";\n" +
                "\t\tthis.children = new ArrayList<>();\n" +
                "\t}\n" +
                "\tpublic void addChild(Tree child){\n" +
                "\t\tchildren.add(child);\n" +
                "\t}\n" +
                "\tvoid print(Integer testNum){\n" +
                "\t\tString outPath = \"TestsOut/test\" + testNum + \".txt\";\n" +
                "\t\tPath output = Paths.get(outPath);\n" +
                "\t\tif (output.getParent() != null) {\n" +
                "\t\t\ttry {\n" +
                "\t\t\t\tFiles.createDirectories(output.getParent());\n" +
                "\t\t\t} catch (IOException e) {\n" +
                "\t\t\t\tSystem.out.println(\"Can't create output file\");\n" +
                "\t\t\t\treturn;\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t\ttry (BufferedWriter writer = Files.newBufferedWriter(output, StandardCharsets.UTF_8)) {\n" +
                "\t\t\tprintTree(writer, 0);\n" +
                "\t\t} catch (IOException e) {\n" +
                "\t\t\tSystem.out.println(\"Can't write to file\" + outPath + e.getMessage());\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\tvoid printTree(BufferedWriter writer, Integer level) throws IOException{\n" +
                "\t\tfor (int i = 0; i < level; i++){\n" +
                "\t\t\twriter.write(\"________\");\n" +
                "\t\t}\n" +
                "\t\twriter.write(value.toString() + \" \" + name);\n" +
                "\t\twriter.newLine();\n" +
                "\t\tif (!children.isEmpty()){\n" +
                "\t\t\tfor (Tree child : children) {\n" +
                "\t\t\t\tchild.printTree(writer, level + 1);\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}\n");
        return stringBuilder;
    }
}
/*
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree {
    private final String node;
    public Integer value;
    private final List<Tree> children;

    Tree(String node, Tree... children) {
        this.value = 0;
        this.node = node;
        this.children = Arrays.asList(children);
    }

    Tree(String node) {
        this.node = node;
        this.children = new ArrayList<>();
    }
    void print(Integer testNum){
        String outPath = "TestsOut/test" + testNum + ".txt";
        Path output = Paths.get(outPath);
        if (output.getParent() != null) {
            try {
                Files.createDirectories(output.getParent());
            } catch (IOException e) {
                System.out.println("Can't create output file");
                return;
            }
        }
        try (BufferedWriter writer = Files.newBufferedWriter(output, StandardCharsets.UTF_8)) {
            printTree(writer, 0);
        } catch (IOException e) {
            System.out.println("Can't write to file" + outPath + e.getMessage());
        }
    }
    void printTree(BufferedWriter writer, Integer level) throws IOException{
        for (int i = 0; i < level; i++){
            writer.write("________");
        }
        writer.write(node);
        writer.newLine();
        if (!children.isEmpty()){
            for (Tree child : children) {
                child.printTree(writer, level + 1);
            }
        }
    }
}

 */