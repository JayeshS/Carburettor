package org.js.carburettor.board

import org.js.carburettor.piece.Bishop
import org.js.carburettor.piece.Colour
import org.js.carburettor.piece.Pawn
import org.junit.Test

class BoardTest {

    @Test
    void getShouldReturnCorrectSquareForGivenRankAndFile() {
        Board board = Board.createEmptyBoard()
        Square x = board['b2']
        assert x.file == 'b'
        assert x.rank == 2
    }

    @Test
    void shouldDetectWhenASquareIsControlledByAPawn() {
        Board board = Board.createEmptyBoard()
        board.addAt 'a2', new Pawn(colour: Colour.WHITE)
        assert board['a2'].piece.sphereOfInfluence.contains(board['b3'])
        assert board.isSquareControlledBy(board['b3'], Colour.WHITE)
    }

    @Test
    void shouldDetectWhenASquareIsControlledByABishop() {
        Board board = Board.createEmptyBoard()
        board.addAt 'a2', new Bishop(colour: Colour.WHITE)
        assert board['a2'].piece.sphereOfInfluence.contains(board['c4'])
        assert board.isSquareControlledBy(board['c4'], Colour.WHITE)
    }
}
