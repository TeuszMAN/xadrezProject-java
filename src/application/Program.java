package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class Program {

    public static void main (String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        Scanner sc = new Scanner(System.in);

        while (true) {
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("source: ");
            ChessPosition source = UI.readChessPosition(sc);
            System.out.println();
            System.out.print("target: ");
            ChessPosition target = UI.readChessPosition(sc);

            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

        }


    }
}
