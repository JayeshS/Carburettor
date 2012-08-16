package org.js.carburettor.piece

import org.js.carburettor.board.Square
import org.js.carburettor.board.Squares
import org.js.carburettor.board.BoardTraversal

class Rook extends Piece {

    private BoardTraversal boardTraversal = new BoardTraversal()

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
