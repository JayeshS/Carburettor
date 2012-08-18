package org.js.carburettor.board

import org.junit.Test

class BoardTest {

    @Test
    void getShouldReturnCorrectSquareForGivenRankAndFile() {
        Board board = Board.createEmptyBoard()
        Square x = board['b2']
        assert x.file == 'b'
        assert x.rank == 2
    }
}
