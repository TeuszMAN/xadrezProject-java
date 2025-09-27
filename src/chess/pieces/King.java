package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean testRookCastling(Position position) {

        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;

    }
    
    @Override
    public boolean[][] possibleMoves() {
    int rows = getBoard().getRows();
    int columns = getBoard().getColumns();
    boolean[][] possibleMovesMatrix = new boolean[rows][columns];
 
    checksInDirection(possibleMovesMatrix, -1, 0); // Above
    checksInDirection(possibleMovesMatrix, 0, -1); // Left
    checksInDirection(possibleMovesMatrix, +1, 0); // Down
    checksInDirection(possibleMovesMatrix, 0, +1); // Right
		
    checksInDirection(possibleMovesMatrix, -1, -1); // Above and left
    checksInDirection(possibleMovesMatrix, +1, -1); // Left and down
    checksInDirection(possibleMovesMatrix, +1, +1); // Down and right
    checksInDirection(possibleMovesMatrix, -1, +1); // Right and above

    // Special move castling
    if (getMoveCount() == 0 && !chessMatch.getCheck()) {
        // Special move castling king side move
        Position posT1 = new Position(position.getRow(),position.getColumn() + 3);
        if (testRookCastling(posT1)){
            Position p1 = new Position(position.getRow(), position.getColumn()+1);
            Position p2 = new Position(position.getRow(), position.getColumn()+2);

            if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
                possibleMovesMatrix[position.getRow()][position.getColumn()+ 2] = true;
            }

        }
         Position posT2 = new Position(position.getRow(),position.getColumn() -4);
        if (testRookCastling(posT2)){
            Position p1 = new Position(position.getRow(), position.getColumn()-1);
            Position p2 = new Position(position.getRow(), position.getColumn()-2);
            Position p3 = new Position(position.getRow(), position.getColumn()-3);

            if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
                possibleMovesMatrix[position.getRow()][position.getColumn()- 2] = true;
            }

        }

    }
 
    return possibleMovesMatrix;
    }


    private void checksInDirection(boolean[][] possibleMovesMatrix, int rowIncrement, int columnIncrement) {
        Position nextPositionToCheck = new Position(0, 0);
        int newRow = this.position.getRow() + rowIncrement;
        int newColumn = this.position.getColumn() + columnIncrement;
        nextPositionToCheck.setValues(newRow, newColumn);
    
        if (conditionsToMove(nextPositionToCheck)) {
            possibleMovesMatrix[newRow][newColumn] = true;
        }
    }


    private boolean conditionsToMove(Position nextPositionToCheck) {
        if (!this.getBoard().positionExists(nextPositionToCheck)) return false;
        boolean thereNoIsAPiece = !this.getBoard().thereIsAPiece(nextPositionToCheck);
        boolean isThereOpponentPiece = this.isThereOpponentPiece(nextPositionToCheck);
        return thereNoIsAPiece || isThereOpponentPiece;
    }
}
