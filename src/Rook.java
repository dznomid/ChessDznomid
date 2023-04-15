public class Rook extends ChessPiece{

    public Rook(String color){
        super(color);
    }

    public String getColor(){
        return color;
    }
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn ){
        ChessPiece[] steps = new ChessPiece[8];
        int count = 0;
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) && chessBoard.board[line][column] != null){
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
    return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
