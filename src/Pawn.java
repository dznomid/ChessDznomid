public class Pawn extends ChessPiece{

    public Pawn (String color){
        super(color);
    }
    public String getColor(){
        return this.color;
    }

    public String getSymbol(){return "P";}

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (checkPos(toLine) && checkPos(toColumn) && checkPos(line) && checkPos(column) && chessBoard.board[line][column] != null) {
            if (column == toColumn){
                int dir, start;
                if (color.equals("White")){
                    start = 1;
                    dir = 1;
                } else {
                    start = 6;
                    dir = -1;
                }
                if (line + dir == toLine){
                    return chessBoard.board[toLine][toColumn] == null;
                }
                if ((line + 2 * dir) == toLine && line == start){
                    return chessBoard.board[toLine][toColumn] == null;
                }

            } else {
                if ((column - toColumn == 1 || column - toColumn == -1) && (line - toLine == 1 || line - toLine == -1)
                && chessBoard.board[toLine][toColumn] != null){
                    return !chessBoard.board[toLine][toColumn].getColor().equals(color);
                } else return false;
            }
        }
        return false;
    }

}
