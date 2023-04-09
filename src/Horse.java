public class Horse extends ChessPiece{

    public Horse (String color){
        super(color);
    }

    public String getColor(){
        return this.color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (checkPos(toLine) && checkPos(toColumn) && checkPos(line) && checkPos(column)) {
            if (line != toLine && column != toColumn
                    && (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color))
                    && chessBoard.board[line][column] != null){
                int [][] positions = new int[][]{
                        {line + 1, column + 2}, {line + 1, column - 2},
                        {line -1, column + 2}, {line - 1, column -2},
                        {line + 2, column + 1}, {line + 2, column - 1},
                        {line - 2, column + 1}, {line - 2, column - 1}
                };
                for (int i = 0; i < positions.length; i++){
                    if (positions[i][0] == toLine && positions[i][1] == toColumn){
                        return true;
                    }
                }
            }
        }else return false;
        return false;   //!!!!!!!!!! maybe true...
    }
    public String getSymbol(){
        return("H");
    }
}
