package org.js.carburettor.piece

import org.junit.Test
import static org.js.carburettor.board.Squares.*
import org.junit.Before

class QueenTest {

    private Queen queen

    @Before
    void resetBoard() {
        reset()
    }

    @Test
    void canCreateQueen() {
        queen = new Queen(colour: Colour.WHITE, position: B3)
        assert queen.colour == Colour.WHITE
        assert queen.position == B3
        assert queen.position.piece == queen
    }

    @Test
    void canMoveDiagonally() {
        queen = new Queen(colour: Colour.WHITE, position: B3)
        assert queen.possibleMoves.containsAll([C4, D5, E6, F7, G8,  C2, D1, A4, A2])
    }

    @Test
    void canMoveAlongRanksAndFiles() {
        queen = new Queen(colour: Colour.WHITE, position: B3)
        assert queen.possibleMoves.containsAll([C3, D3, E3, F3, G3, H3,  B2, B1,  A3,  B4, B5, B6, B7, B8])
    }
}
