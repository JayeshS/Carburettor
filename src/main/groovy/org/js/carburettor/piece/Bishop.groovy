package org.js.carburettor.piece

import org.js.carburettor.board.Square
import org.js.carburettor.board.Squares
import org.js.carburettor.board.BoardTraversal

class Bishop extends Piece {

    private BoardTraversal boardTraversal = new BoardTraversal()

    @Override
    List<Square> getPossibleMoves() {
        return getAllDiagonalSquares()
    }

    private List<Square> getAllDiagonalSquares() {
        List<Square> possibleSquares = []
        getMoves(boardTraversal.nextFile(), boardTraversal.nextRank(), possibleSquares)
        getMoves(boardTraversal.nextFile(), boardTraversal.previousRank(), possibleSquares)
        getMoves(boardTraversal.previousFile(), boardTraversal.nextRank(), possibleSquares)
        getMoves(boardTraversal.previousFile(), boardTraversal.previousRank(), possibleSquares)
        return possibleSquares
    }

}
