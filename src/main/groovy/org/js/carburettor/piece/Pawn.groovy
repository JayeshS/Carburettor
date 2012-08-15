package org.js.carburettor.piece

import org.js.carburettor.board.Square
import org.js.carburettor.board.Squares
import static org.js.carburettor.piece.Colour.WHITE
import static org.js.carburettor.piece.Colour.BLACK

class Pawn extends Piece {

    List<Square> getPossibleMoves() {
        def possibleSquares = []
        def aheadOneRank = Squares.get(position.file, position.rank + 1)

        if (aheadOneRank.isEmpty())
            possibleSquares << aheadOneRank

        def aheadTwoRank = Squares.get(position.file, position.rank + 2)
        if (this.isAtInitialPosition() && aheadOneRank.isEmpty() && aheadTwoRank.isEmpty())
            possibleSquares << aheadTwoRank

        def captureSquareOnNextFile = Squares.get(position.file.next(), position.rank + 1)
        def captureSquareOnPrevFile = Squares.get(position.file.previous(), position.rank + 1)

        [captureSquareOnNextFile, captureSquareOnPrevFile].each {captureSquare ->
            if (captureSquare?.hasOpponentPiece(this))
                possibleSquares << captureSquare
        }

        return possibleSquares.findAll {it.isEmpty() || it.hasOpponentPiece(this)}
    }

    private boolean isAtInitialPosition() {
        return (colour == WHITE && position.rank == 2) || (colour == BLACK && position.rank == 7)
    }
}