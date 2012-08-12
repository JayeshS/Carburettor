package org.js.carburettor.piece

import org.js.carburettor.board.Square
import org.js.carburettor.board.Squares
import static org.js.carburettor.piece.Colour.WHITE
import static org.js.carburettor.piece.Colour.BLACK
import org.js.carburettor.IllegalMoveException

class Pawn {
    Colour colour
    Square position

    Pawn(Colour colour, Square position) {
        this.colour = colour
        this.position = position
        setPosition(position)
    }

    def move (Square square) {
        if (!getPossibleMoves().contains(square))
            throw new IllegalMoveException("Can't move ${this.class.simpleName} from $position to $square")
        setPosition(square)
    }

    private def setPosition(Square square) {
        position = square
        position.piece = this
    }

    private List<Square> getPossibleMoves() {
        def possibleSquares = []
        def nextSquare = Squares.get(position.file, position.rank + 1)

        if (nextSquare.isEmpty())
            possibleSquares << nextSquare

        def advanceByTwo = Squares.get(position.file, position.rank + 2)
        if (this.isAtInitialPosition() && nextSquare.isEmpty() && advanceByTwo.isEmpty())
            possibleSquares << advanceByTwo

        def captureSquareOnNextFile = Squares.get(position.file.next(), position.rank + 1)
        def captureSquareOnPrevFile = Squares.get(position.file.previous(), position.rank + 1)

        [captureSquareOnNextFile, captureSquareOnPrevFile].each {captureSquare ->
            if (captureSquare?.hasOpponentPieceComparedTo(this))
                possibleSquares << captureSquare
        }

        return possibleSquares.findAll {it.isEmpty() || it.hasOpponentPieceComparedTo(this)}
    }

    private boolean isAtInitialPosition() {
        return (colour == WHITE && position.rank == 2) || (colour == BLACK && position.rank == 7)
    }
}
