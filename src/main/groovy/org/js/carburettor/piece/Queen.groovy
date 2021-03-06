package org.js.carburettor.piece

import org.js.carburettor.board.Square

class Queen extends Piece {

    Integer defaultWeight = 950

    @Override
    List<Square> getPossibleMoves() {
        List<Square> possibleSquares = []
        Closure sameRankOrFile = {it}
        getMoves(sameRankOrFile, boardTraversal.nextRank(), possibleSquares)
        getMoves(sameRankOrFile, boardTraversal.previousRank(), possibleSquares)
        getMoves(boardTraversal.previousFile(), sameRankOrFile, possibleSquares)
        getMoves(boardTraversal.nextFile(), sameRankOrFile, possibleSquares)

        getMoves(boardTraversal.nextFile(), boardTraversal.nextRank(), possibleSquares)
        getMoves(boardTraversal.nextFile(), boardTraversal.previousRank(), possibleSquares)
        getMoves(boardTraversal.previousFile(), boardTraversal.nextRank(), possibleSquares)
        getMoves(boardTraversal.previousFile(), boardTraversal.previousRank(), possibleSquares)

        return possibleSquares
    }
}
