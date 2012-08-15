package org.js.carburettor.piece

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
        bishop = new Bishop(colour: WHITE, position: org.js.carburettor.board.Squares.B3)
        assert bishop.position == Squares.B3
    }

    @Test
    void shouldMoveDiagonally() {
        bishop = new Bishop(colour: WHITE, position: org.js.carburettor.board.Squares.B3)
        List possibleMoves = bishop.getPossibleMoves()
        assert possibleMoves.containsAll([org.js.carburettor.board.Squares.C4, org.js.carburettor.board.Squares.D5, org.js.carburettor.board.Squares.E6, org.js.carburettor.board.Squares.F7, org.js.carburettor.board.Squares.G8])
        assert possibleMoves.containsAll([org.js.carburettor.board.Squares.A2, org.js.carburettor.board.Squares.A4])
        assert possibleMoves.containsAll([org.js.carburettor.board.Squares.C2, org.js.carburettor.board.Squares.D1])
        assert possibleMoves.size() == 9
    }

    @Test
    void shouldNotJumpOverAPiece() {
        bishop = new Bishop(colour: WHITE, position: org.js.carburettor.board.Squares.B3)
        Pawn aPawn = new Pawn(colour: WHITE, position: org.js.carburettor.board.Squares.C4)
        List possibleMoves = bishop.getPossibleMoves()
        assert !possibleMoves.contains(org.js.carburettor.board.Squares.C4)
        assert !possibleMoves.contains(org.js.carburettor.board.Squares.D5)
        assert possibleMoves.containsAll([org.js.carburettor.board.Squares.A2, org.js.carburettor.board.Squares.A4])
        assert possibleMoves.containsAll([org.js.carburettor.board.Squares.C2, org.js.carburettor.board.Squares.D1])
        assert possibleMoves.size() == 4
    }

    @Test
    void shouldCaptureOpponentsPiece() {
        bishop = new Bishop(colour: WHITE, position: org.js.carburettor.board.Squares.B3)
        Pawn opponentsPawn = new Pawn(colour: BLACK, position: org.js.carburettor.board.Squares.C4)
        List possibleMoves = bishop.getPossibleMoves()
        assert possibleMoves.contains(org.js.carburettor.board.Squares.C4)
    }
}
