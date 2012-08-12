package org.js.carburettor

import org.junit.Test

class SquaresTest {

    @Test
    void getShouldReturnCorrectSquareForGivenRankAndFile() {
        Square x = Squares.get('B', 2)
        assert x.file == 'B'
        assert x.rank == 2
    }
}
