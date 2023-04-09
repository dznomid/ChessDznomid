public abstract class ChessPiece {
    String color;
    Boolean check = true;
    public ChessPiece(String color){
        this.color = color;
    }
    public abstract String getColor();
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    public boolean checkPos(int pos ){
        if (pos >= 0 && pos <= 7) return true; else return false;
    }


}
