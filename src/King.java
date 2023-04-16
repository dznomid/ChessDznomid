
public class King extends ChessPiece{
    public King(String color){
        super(color);
    }
    public String getColor(){
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) && chessBoard.board[line][column] != null){
            if (isUnderAttack(chessBoard, toLine, toColumn)){
                return false;}
            if (Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1){
                if (chessBoard.board[toLine][toColumn] == null){
                    return true;
                } else return !chessBoard.board[toLine][toColumn].getColor().equals(color);
            }
        }
        return false;
    }
    public String getSymbol(){
        return "K";
    }
    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column){
        if (checkPos(line) && checkPos(column)) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (chessBoard.board[i][j] != null) {
                        if (!chessBoard.board[i][j].getColor().equals(color)) {
                            if (chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                                return true;
                            }
                        }
                    }
                }
            }
        return false;
        }else return false;
    }
}
