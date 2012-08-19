package org.js.carburettor.piece

import org.js.carburettor.board.Square
import static org.js.carburettor.piece.Colour.BLACK
import static org.js.carburettor.piece.Colour.WHITE

class Pawn extends Piece {

    List<Square> getPossibleMoves() {
        def possibleSquares = []
        def aheadOneRank = board[position.file + (position.rank + 1)]

        if (aheadOneRank.isEmpty())
            possibleSquares << aheadOneRank

        def aheadTwoRanks = board[position.file + (position.rank + 2)]
        if (this.isAtInitialPosition() && aheadOneRank.isEmpty() && aheadTwoRanks.isEmpty())
            possibleSquares << aheadTwoRanks

        def captureSquares = getSphereOfInfluence()

        captureSquares.each {captureSquare ->
            if (captureSquare?.hasOpponentPiece(this))
                possibleSquares << captureSquare
        }

        return possibleSquares.findAll {it.isEmpty() || it.hasOpponentPiece(this)}
    }

    List<Square> getSphereOfInfluence() {
        def captureSquareOnNextFile = board[position.file.next() + (position.rank + 1)]
        def captureSquareOnPrevFile = board[position.file.previous() + (position.rank + 1)]
        return [captureSquareOnPrevFile, captureSquareOnNextFile]
    }

    private boolean isAtInitialPosition() {
        return (colour == WHITE && position.rank == 2) || (colour == BLACK && position.rank == 7)
    }
}
