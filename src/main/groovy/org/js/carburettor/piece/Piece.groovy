package org.js.carburettor.piece

import org.js.carburettor.board.Square
import org.js.carburettor.IllegalMoveException
import org.js.carburettor.IllegalSquareException
import org.js.carburettor.board.Squares

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

    def void getMoves(Closure changeFile, Closure changeRank, List<Square> result) {
        getMoves(position, changeFile, changeRank, result)
    }


    private void getMoves(Square initialPosition, Closure changeFile, Closure changeRank, List<Square> result) {
        Square possibleSquare = Squares.get(changeFile(initialPosition.file), changeRank(initialPosition.rank))
        if (possibleSquare == null || possibleSquare.hasOwnPiece(this)) {
            return
        }
        if (possibleSquare.hasOpponentPiece(this)) {
            result << possibleSquare
            return
        }
        if (possibleSquare.isEmpty()) {
            result << possibleSquare
            getMoves(possibleSquare, changeFile, changeRank, result)
        }
    }

    abstract List<Square> getPossibleMoves();
}
