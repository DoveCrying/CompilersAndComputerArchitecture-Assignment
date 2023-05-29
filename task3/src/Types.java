import org.antlr.v4.runtime.tree.TerminalNode;

public enum Types {
    INT, BOOL, UNIT, UNKNOWN;

    public static Types toType(SExpressionsParser.TypeContext type)
    {
        Types t;
        int typeNode = (((TerminalNode) (type.getChild(0))).getSymbol().getType());
        if (typeNode == SExpressionsParser.IntType) t = INT;
        else if (typeNode == SExpressionsParser.BoolType) t = BOOL;
        else if(typeNode == SExpressionsParser.UnitType) t = UNIT;
        else  throw new RuntimeException("Shouldn't be here - wrong argument for Types.toType().");
        return t;
    }
}

