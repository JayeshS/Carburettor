package org.js.carburettor.board

import org.junit.Test
import org.js.carburettor.board.Square
import org.js.carburettor.board.Squares

class SquaresTest {

    @Test
    void getShouldReturnCorrectSquareForGivenRankAndFile() {
        Square x = Squares.get('B', 2)
        assert x.file == 'B'
        assert x.rank == 2
    }
}
