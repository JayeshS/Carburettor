package org.js.carburettor.piece

import org.js.carburettor.board.Board
import org.js.carburettor.board.Square
import org.junit.Before
import org.junit.Test
import static org.js.carburettor.board.Board.reset
import static org.js.carburettor.piece.Colour.WHITE

class RookTest {

    private Board board
    private Rook rook

    @Before
    void resetBoard() {
        board = Board.createEmptyBoard()
        reset()
    }
    
    @Test
    void canCreateRook() {
        rook = new Rook(colour: WHITE)
        board.addAt 'd5', rook
        assert rook.position == board['D5']
        assert rook.position.piece == rook
    }

    @Test
    void shouldMoveAlongRanksAndFiles() {
        rook = new Rook(colour: WHITE)
        board.addAt 'd5', rook
        List<Square> possibleMoves = rook.getPossibleMoves()
        assert possibleMoves.containsAll([board['D1'], board['D2'], board['D3'], board['D4'], board['D6'], board['D7'], board['D8']])
        assert possibleMoves.containsAll([board['A5'], board['B5'], board['C5'], board['E5'], board['F5'], board['G5'], board['H5']])
    }
}
