package org.js.carburettor.piece

import org.js.carburettor.board.Square

class Rook extends Piece {

    Integer defaultWeight = 550

    @Override
    List<Square> getPossibleMoves() {
        List<Square> possibleSquares = []
        Closure sameRankOrFile = {it}
        getMoves(sameRankOrFile, boardTraversal.nextRank(), possibleSquares)
        getMoves(sameRankOrFile, boardTraversal.previousRank(), possibleSquares)
        getMoves(boardTraversal.previousFile(), sameRankOrFile, possibleSquares)
        getMoves(boardTraversal.nextFile(), sameRankOrFile, possibleSquares)

        return possibleSquares
    }

}
