package org.js.carburettor.piece

import org.junit.Before
import org.junit.Test
import static org.js.carburettor.board.Board.*
import static org.js.carburettor.piece.Colour.WHITE

public class KingTest {

    private King king

    @Before
    void resetBoard() {
        reset()
    }

    @Test
    void canCreateKing() {
        King whiteKing = new King(colour: WHITE, position: E1)
        assert whiteKing.position == E1
        assert whiteKing.position.piece == whiteKing
    }

    @Test
    void canMoveOneSquareInAnyDirection() {
        King whiteKing = new King(colour: WHITE, position: E2)
        assert whiteKing.possibleMoves.containsAll([D2, D1, E1, F1, F2, F3, E3, D3])
        assert whiteKing.possibleMoves.size() == 8
    }
}
