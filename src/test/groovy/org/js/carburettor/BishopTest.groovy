package org.js.carburettor

import org.js.carburettor.piece.Bishop
import org.js.carburettor.board.Squares
import org.js.carburettor.piece.Colour
import org.junit.Test
import static org.js.carburettor.piece.Colour.*
import static org.js.carburettor.board.Squares.*
import org.js.carburettor.piece.Pawn

class BishopTest {

    private Bishop bishop;

    @Test
    void canCreateNewBishop() {
        bishop = new Bishop(colour: WHITE, position: B3)
        assert bishop.position == Squares.B3
    }

    @Test
    void shouldMoveDiagonally() {
        bishop = new Bishop(colour: WHITE, position: B3)
        List possibleMoves = bishop.getPossibleMoves()
        assert possibleMoves.containsAll([C4, D5, E6, F7, G8])
        assert possibleMoves.containsAll([A2, A4])
        assert possibleMoves.containsAll([C2, D1])
        assert possibleMoves.size() == 9
    }

    @Test
    void shouldNotJumpOverAPiece() {
        bishop = new Bishop(colour: WHITE, position: B3)
        Pawn aPawn = new Pawn(colour: WHITE, position: C4)
        List possibleMoves = bishop.getPossibleMoves()
        assert !possibleMoves.contains(C4)
        assert !possibleMoves.contains(D5)
        assert possibleMoves.containsAll([A2, A4])
        assert possibleMoves.containsAll([C2, D1])
        assert possibleMoves.size() == 4
    }

    @Test
    void shouldCaptureOpponentsPiece() {
        bishop = new Bishop(colour: WHITE, position: B3)
        Pawn opponentsPawn = new Pawn(colour: BLACK, position: C4)
        List possibleMoves = bishop.getPossibleMoves()
        assert possibleMoves.contains(C4)
    }
}