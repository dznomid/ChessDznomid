public class Bishop extends ChessPiece{
    public String getColor(){
        return color;
    }
    public Bishop(String color){
        super(color);
    }
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        int l = line,c = column; // line, column
        int desNum = 0;
        ChessPiece[][] des = new ChessPiece[8][8];
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) && chessBoard.board[line][column] != null &&
        toLine != line && toColumn != column && Math.abs(line - toLine) == Math.abs(column - toColumn)){

            for (int i = 0; i < 8; i++){
                for (int j = 0; j < 8; j++){
                    des[i][j] = chessBoard.board[i][j];
                }
            }
            if (toLine > line && toColumn > column){
                desNum = 1;
            } else if (toLine < line && toColumn > column){
                desNum= 2;
            } else if (toLine < line && toColumn < column){
                desNum = 3;
            } else if (toLine > line && toColumn < column){
                desNum = 4;
            }


            switch (desNum){
                case 1:
                    l++; c++;
                    while (des[l][c] == null && l < toLine && c < toColumn) {
                        l++; c++;
                    }
                    break;
                case 2:
                    l--; c++;
                    while (des[l][c] == null && l > toLine && c < toColumn) {
                        l--; c++;
                    }
                    break;
                case 3:
                    l--;c--;
                    while (des[l][c] == null && l > toLine && c > toColumn) {
                        l--; c--;
                    }
                    break;
                case 4:
                    l++; c--;
                    while (des[l][c] == null && l < toLine && c > toColumn) {
                        l++; c--;
                    }
                    break;
                default: return false;

            }
            if (l == toLine && c == toColumn) {
                if (chessBoard.board[toLine][toColumn] != null) {
                    return !chessBoard.board[toLine][toColumn].getColor().equals(color);
                } else return true;
            }
        }
        return false;

    }
    public String getSymbol(){
        return "B";
    }
}
