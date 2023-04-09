public abstract class ChessPiece {
    String color;
    Boolean check = true;
    public ChessPiece(String color){};
    public String getColor(){
        return this.color;
    }
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();


}
