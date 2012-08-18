package org.js.carburettor.piece

import org.js.carburettor.board.Square

class King extends Piece {

    @Override
    List<Square> getPossibleMoves() {
        def possibleMoves = []
        getMoves(boardTraversal.previousFile(), boardTraversal.sameRank(), true, possibleMoves)
        getMoves(boardTraversal.previousFile(), boardTraversal.previousRank(), true, possibleMoves)
        getMoves(boardTraversal.sameFile(), boardTraversal.previousRank(), true, possibleMoves)
        getMoves(boardTraversal.nextFile(), boardTraversal.previousRank(), true, possibleMoves)
        getMoves(boardTraversal.nextFile(), boardTraversal.sameRank(), true, possibleMoves)
        getMoves(boardTraversal.nextFile(), boardTraversal.nextRank(), true, possibleMoves)
        getMoves(boardTraversal.sameFile(), boardTraversal.nextRank(), true, possibleMoves)
        getMoves(boardTraversal.previousFile(), boardTraversal.nextRank(), true, possibleMoves)
        return possibleMoves
    }

}
