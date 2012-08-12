package org.js.carburettor.piece

import org.js.carburettor.Colour
import org.js.carburettor.Square
import org.js.carburettor.Squares
import static org.js.carburettor.Colour.WHITE
import static org.js.carburettor.Colour.BLACK

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
        def possibleSquares = [Squares.get(position.file, position.rank + 1)]
        if (this.isAtInitialPosition())
            possibleSquares << Squares.get(position.file, position.rank + 2)

        return possibleSquares.findAll {it.isEmpty()}

    }

    private boolean isAtInitialPosition() {
        return (colour == WHITE && position.rank == 2) || (colour == BLACK && position.rank == 7)
    }
}
