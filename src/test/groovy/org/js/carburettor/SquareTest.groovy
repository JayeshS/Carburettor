package org.js.carburettor

import org.js.carburettor.piece.Pawn
import org.junit.Test
import org.js.carburettor.board.Square
import org.js.carburettor.board.Squares
import org.js.carburettor.piece.Colour

class SquareTest {

    private Square square;

    @Test
    void shouldCorrectlyReportIfASquareHasOpponentsPiece() {
        Pawn whitePawn = new Pawn(Colour.WHITE, Squares.A3)
        Pawn blackPawn = new Pawn(Colour.BLACK, Squares.B3)

        assert Squares.A3.hasOpponentPieceComparedTo(blackPawn)
    }

    @Test
    void shouldReturnFalseWhenCheckingForOpponentPiecesForEmptySquares() {
        Pawn whitePawn = new Pawn(Colour.WHITE, Squares.A3)

        assert !Squares.G8.hasOpponentPieceComparedTo(whitePawn)
    }
}
