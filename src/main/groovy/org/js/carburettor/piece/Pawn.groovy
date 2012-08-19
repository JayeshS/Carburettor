package org.js.carburettor.piece

import org.js.carburettor.board.Square
import static org.js.carburettor.piece.Colour.BLACK
import static org.js.carburettor.piece.Colour.WHITE

class Pawn extends Piece {

    List<Square> getPossibleMoves() {
        def possibleSquares = []

        def nextSquare = board[position.file + nextRank()]

        if (nextSquare.isEmpty())
            possibleSquares << nextSquare

        def square2RanksAhead = board[position.file + twoRanksAhead()]
        if (this.isAtInitialPosition() && nextSquare.isEmpty() && square2RanksAhead.isEmpty())
            possibleSquares << square2RanksAhead

        def captureSquares = getSphereOfInfluence()

        captureSquares.each {captureSquare ->
            if (captureSquare?.hasOpponentPiece(this))
                possibleSquares << captureSquare
        }

        return possibleSquares.findAll {it.isEmpty() || it.hasOpponentPiece(this)}
    }
    List<Square> getSphereOfInfluence() {
        def captureSquareOnNextFile = board[position.file.next() + nextRank()]
        def captureSquareOnPrevFile = board[position.file.previous() + nextRank()]
        return [captureSquareOnPrevFile, captureSquareOnNextFile]
    }

    private boolean isAtInitialPosition() {
        return (colour == WHITE && position.rank == 2) || (colour == BLACK && position.rank == 7)
    }

    private Integer nextRank() {
        colour == WHITE ? position.rank + 1 : position.rank - 1
    }

    private Integer twoRanksAhead() {
        colour == WHITE ? position.rank + 2 : position.rank - 2
    }
}
