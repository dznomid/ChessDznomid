public class Queen extends ChessPiece{
    public Queen(String color){
        super(color);
    }
    public String getColor(){
        return color;
    }
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (line == toLine || column == toColumn){
            ChessPiece[] steps = new ChessPiece[8];
            int count = 0;
            if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) && chessBoard.board[line][column] != null
            && (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color))){
                if (column == toColumn){
                    count = line;
                    for(int i = 0; i < 8; i++){
                        steps[i] = chessBoard.board[i][column];
                    }
                    if (line < toLine ) {
                        count++;
                        while (steps[count] == null && count < toLine) {
                            count++;
                        }
                        if (count == toLine) return true; else return false;
                    } else {
                        count--;
                        while (steps[count] == null && count > toLine){
                            count--;
                        }
                        if (count == toLine) return true; else return false;
                    }


                } else if(line == toLine){
                    count = column;
                    for(int i = 0; i < 8; i++){
                        steps[i] = chessBoard.board[line][i];
                    }
                    if (column < toColumn) {
                        count++;
                        while (steps[count] == null && count < toColumn) {
                            count++;
                        }
                        if (count == toColumn) return true; else return false;
                    } else {
                        count --;
                        while (steps[count] == null && count > toColumn){
                            count--;
                        }
                        if (count == toColumn) return true; else return false;
                    }
                }



            } else return false;
        } else {
            int l = line,c = column; // line, column
            int desNum = 0;
            ChessPiece[][] des = new ChessPiece[8][8];
            if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) && chessBoard.board[line][column] != null &&
                    toLine != line && toColumn != column && Math.abs(line - toLine) == Math.abs(column - toColumn)
            && (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color))){

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
            } else return false;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
