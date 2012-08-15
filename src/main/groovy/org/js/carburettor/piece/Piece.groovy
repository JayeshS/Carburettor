package org.js.carburettor.piece

import org.js.carburettor.board.Square
import org.js.carburettor.IllegalMoveException

abstract class Piece {
    protected Colour colour
    protected Square position

    protected def setPosition(Square square) {
        position = square
        position.piece = this
    }

    def move (Square square) {
        if (!getPossibleMoves().contains(square))
            throw new IllegalMoveException("Can't move ${this.class.simpleName} from $position to $square")
        setPosition(square)
    }

    abstract List<Square> getPossibleMoves();
}
