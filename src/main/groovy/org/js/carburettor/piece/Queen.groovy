package org.js.carburettor.piece

import org.js.carburettor.board.Square
import org.js.carburettor.board.BoardTraversal

class Queen extends Piece {

    private BoardTraversal boardTraversal = new BoardTraversal()

    @Override
    List<Square> getPossibleMoves() {
        def possibleMoves = []

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
