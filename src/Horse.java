public class Horse extends ChessPiece{

    public Horse (String color){
        super(color);
    }

    public String getColor(){
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (checkPos(toLine) && checkPos(toColumn)) {
            if (((toLine == line + 1)||(toLine == line - 1)) && ((toColumn == toColumn + 2)||(toColumn == column - 2))){
                return true;
            } else return false;
        }else return false;
    }
    public String getSymbol(){
        return("H");
    }
}
