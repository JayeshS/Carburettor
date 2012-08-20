package org.js.carburettor.piece

import org.js.carburettor.board.Square

class King extends Piece {

    @Override
    List<Square> getPossibleMoves() {
        def possibleMoves = getSphereOfInfluence()

        possibleMoves.removeAll {square ->
            square.isControlledBy(colour.opponent)
        }

        return possibleMoves
    }

    def List getSphereOfInfluence() {
        def possibleMoves = []
        getMoves(boardTraversal.previousFile(), boardTraversal.sameRank(), possibleMoves, true)
        getMoves(boardTraversal.previousFile(), boardTraversal.previousRank(), possibleMoves, true)
        getMoves(boardTraversal.sameFile(), boardTraversal.previousRank(), possibleMoves, true)
        getMoves(boardTraversal.nextFile(), boardTraversal.previousRank(), possibleMoves, true)
        getMoves(boardTraversal.nextFile(), boardTraversal.sameRank(), possibleMoves, true)
        getMoves(boardTraversal.nextFile(), boardTraversal.nextRank(), possibleMoves, true)
        getMoves(boardTraversal.sameFile(), boardTraversal.nextRank(), possibleMoves, true)
        getMoves(boardTraversal.previousFile(), boardTraversal.nextRank(), possibleMoves, true)
        return possibleMoves
    }

}
