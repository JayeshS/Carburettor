package org.js.carburettor.piece

import org.junit.Test
import static org.js.carburettor.piece.Colour.*
import static org.js.carburettor.board.Board.*
import org.js.carburettor.board.Square

class RookTest {

    private Rook rook

    @Test
    void canCreateRook() {
        rook = new Rook(colour: WHITE, position: D5)
        assert rook.position == D5
        assert rook.position.piece == rook
    }

    @Test
    void shouldMoveAlongRanksAndFiles() {
        rook = new Rook(colour: WHITE, position: D5)
        List<Square> possibleMoves = rook.getPossibleMoves()
        assert possibleMoves.containsAll([D1, D2, D3, D4, D6, D7, D8])
        assert possibleMoves.containsAll([A5, B5, C5, E5, F5, G5, H5])
    }
}
