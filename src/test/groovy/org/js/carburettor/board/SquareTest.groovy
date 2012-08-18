package org.js.carburettor.board

import org.js.carburettor.piece.Pawn
import org.junit.Test

import org.js.carburettor.piece.Colour

class SquareTest {

    private Square square;

    @Test
    void shouldCorrectlyReportIfASquareHasOpponentsPiece() {
        Pawn whitePawn = new Pawn(colour: Colour.WHITE, position: Board.A3)
        Pawn blackPawn = new Pawn(colour: Colour.BLACK, position: Board.B3)

        assert Board.A3.hasOpponentPiece(blackPawn)
    }

    @Test
    void shouldReturnFalseWhenCheckingForOpponentPiecesForEmptySquares() {
        Pawn whitePawn = new Pawn(colour: Colour.WHITE, position: Board.A3)

        assert !Board.G8.hasOpponentPiece(whitePawn)
    }
}
