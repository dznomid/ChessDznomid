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
        toLine != line && toColumn != column && Math.abs(line - toLine) == Math.abs(column - toColumn) &&
                !chessBoard.board[toLine][toColumn].getColor().equals(this.color)){
            if (toLine > line && toColumn > column){  // riqht up sq
                desNum = 1;
                for (int i = 0; i < 8; i++){
                    for (int j = 0; j < 8; j++){
                        des[j][i] = chessBoard.board[j][i];
                    }
                }
            }
            if (toLine < line && toColumn > column){   // right bot sq
                desNum = 2;
                for (int i = 0; i < 8; i++){
                    for (int j = 7; j >= 0; j--){
                        des[j][i] = chessBoard.board[j][i];
                    }
                }
            }
            if (toLine < line && toColumn < column){     // left bot sq
                desNum = 3;
                for (int i = 0; i < 8; i++){
                    for (int j = 0; j < 8; j++){
                        des[j][i] = chessBoard.board[j][i];
                    }
                }
            }
            if (toLine > line && toColumn < column){    // left up sq
                desNum = 4;
                for (int i = 0; i < 8; i++){
                    for (int j = 7; j >= 0; j--){
                        des[j][i] = chessBoard.board[j][i];
                    }
                }
            }
            switch (desNum){
                case 1:
                    l++; c++;
                    while (des[l][c] == null && l < toLine && c < toColumn) {
                        l++; c++;
                    }
                    break;
                case 2:
                    l++; c--;
                    while (des[l][c] == null && l < toLine && c > toColumn) {
                        l++; c--;
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

            }
            if (l == toLine && c == toColumn) return true; else return false;
        }
        return false;

    }
    public String getSymbol(){
        return "B";
    }
}
