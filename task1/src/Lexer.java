import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

import java.io.IOException;
import java.util.List;

public class Lexer
{
    public static void main(String[] args) throws IOException {
        CharStream input = CharStreams.fromStream(System.in);
        AlgorithmANTLRLexer lexer = new AlgorithmANTLRLexer(input);
        BufferedTokenStream tokens = new BufferedTokenStream(lexer);
        tokens.fill();
        List<Token> listTok = tokens.getTokens();
        int i = 0;
        for (Token x : listTok)
        {
            i++;
            if (x.getType() == AlgorithmANTLRLexer.Idfr || x.getType() == AlgorithmANTLRLexer.IntLit)
            {
                System.out.print(lexer.getVocabulary().getSymbolicName(x.getType())+"("+x.getText()+")"+",  ");
            }
            else
            {
                System.out.print(lexer.getVocabulary().getSymbolicName(x.getType())+",  ");
            }
            if (i == 6)
            {
                i = 0;
                System.out.print("\n");
            }
        }
    }
}
