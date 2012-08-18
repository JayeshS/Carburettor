package org.js.carburettor.board

import org.js.carburettor.piece.Colour
import org.js.carburettor.piece.Pawn
import org.junit.Before
import org.junit.Test

class SquareTest {

    private Board board
    private Square square;
    
    @Before
    void createBoard() {
        board = Board.createEmptyBoard()
    }

    @Test
    void shouldCorrectlyReportIfASquareHasOpponentsPiece() {
        Pawn whitePawn = new Pawn(colour: Colour.WHITE, position: board['A3'])
        Pawn blackPawn = new Pawn(colour: Colour.BLACK, position: board['B3'])

        assert board['A3'].hasOpponentPiece(blackPawn)
    }

    @Test
    void shouldReturnFalseWhenCheckingForOpponentPiecesForEmptySquares() {
        Pawn whitePawn = new Pawn(colour: Colour.WHITE, position: board['A3'])

        assert !board['G8'].hasOpponentPiece(whitePawn)
    }
}
