package org.js.carburettor.piece

import org.js.carburettor.board.Board
import org.junit.Before
import org.junit.Test
import static org.js.carburettor.board.Board.reset

class QueenTest {

    private Board board
    private Queen queen

    @Before
    void resetBoard() {
        board = Board.createEmptyBoard()
        reset()
    }

    @Test
    void canCreateQueen() {
        queen = new Queen(colour: Colour.WHITE, position: board['B3'])
        assert queen.colour == Colour.WHITE
        assert queen.position == board['B3']
        assert queen.position.piece == queen
    }

    @Test
    void canMoveDiagonally() {
        queen = new Queen(colour: Colour.WHITE, position: board['B3'])
        assert queen.possibleMoves.containsAll([board['C4'], board['D5'], board['E6'], board['F7'], board['G8'],  board['C2'], board['D1'], board['A4'], board['A2']])
    }

    @Test
    void canMoveAlongRanksAndFiles() {
        queen = new Queen(colour: Colour.WHITE, position: board['B3'])
        assert queen.possibleMoves.containsAll([board['C3'], board['D3'], board['E3'], board['F3'], board['G3'], board['H3'],  board['B2'], board['B1'],  board['A3'],  board['B4'], board['B5'], board['B6'], board['B7'], board['B8']])
    }
}
