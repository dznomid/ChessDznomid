public class Pawn extends ChessPiece{

    public Pawn (String color){
        super(color);
    }
    public String getColor(){
        return this.color;
    }

    public String getSymbol(){return "P";}

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (checkPos(toLine) && checkPos(toColumn) && checkPos(line) && checkPos(column)) {
            if (line != toLine && column != toColumn
                    && (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color))
                    && chessBoard.board[line][column] != null){

                if (chessBoard.board[line][column].color.equals("White")){
                    if (line == 1 && toLine == (line + 2)){return true;} else{
                        if (toLine == line + 1 && chessBoard.board[toLine][toColumn] == null){return true;} else{
                            if((toLine == line + 1) && ((toColumn == column + 1 || toColumn == column - 1))
                                    && chessBoard.board[toLine][toColumn] != null){return true;}
                        }
                    }
                }else{
                    if (line == 6 && (toLine == line - 2)){return true;} else{
                        if (toLine == line - 1 && chessBoard.board[toLine][toColumn] == null){return true;} else{
                            if((toLine == line - 1) && ((toColumn == column + 1 || toColumn == column - 1))
                                    && chessBoard.board[toLine][toColumn] != null){return true;} else return false;
                    }
                }
            }
        }
        return false;   //!!!!!!!!!! maybe true...
    } else return false;
    }
}
