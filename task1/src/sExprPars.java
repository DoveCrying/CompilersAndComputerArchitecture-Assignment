import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class sExprPars {
    public static void main(String[] args) throws IOException
    {
        CharStream input = CharStreams.fromStream(System.in);
        AlgorithmANTLRLexer lexer = new AlgorithmANTLRLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        AlgorithmANTLRParser parser = new AlgorithmANTLRParser(tokens);
        ParseTree tree = parser.topLevel();
        AlgorithmANTLRAnalyser converter = new AlgorithmANTLRAnalyser();
        System.out.println(converter.visit(tree));
    }
}
