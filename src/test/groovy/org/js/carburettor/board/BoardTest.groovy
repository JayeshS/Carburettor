package org.js.carburettor.board

import org.junit.Test

class BoardTest {

    @Test
    void getShouldReturnCorrectSquareForGivenRankAndFile() {
        Square x = Board.get('B', 2)
        assert x.file == 'B'
        assert x.rank == 2
    }
}
