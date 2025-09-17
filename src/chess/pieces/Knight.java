package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {
    
    public Knight (Board board, Color color) {
        super (board, color);
    }

    @Override
    public String toString() {
        return "N";
    }


    @Override
    public boolean[][] possibleMoves() {
    int rows = getBoard().getRows();
    int columns = getBoard().getColumns();
    boolean[][] possibleMovesMatrix = new boolean[rows][columns];
 
    checksInDirection(possibleMovesMatrix, -2, 1); // Above Right
    checksInDirection(possibleMovesMatrix, -2, -1); // Above Left
    checksInDirection(possibleMovesMatrix, +1, -2); // Left below
    checksInDirection(possibleMovesMatrix, -1, -2); //Left Above
		
    checksInDirection(possibleMovesMatrix, -1, +2); // Right Above
    checksInDirection(possibleMovesMatrix, +1, +2); // Right Below
    checksInDirection(possibleMovesMatrix, +2, -1); // Down Left
    checksInDirection(possibleMovesMatrix, +2, +1); // Down Right
 
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
