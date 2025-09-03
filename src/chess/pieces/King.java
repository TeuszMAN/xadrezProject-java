package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
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
