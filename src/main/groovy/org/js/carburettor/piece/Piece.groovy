package org.js.carburettor.piece

import org.js.carburettor.IllegalMoveException
import org.js.carburettor.board.Board
import org.js.carburettor.board.BoardTraversal
import org.js.carburettor.board.Square

abstract class Piece {

    protected Board board

    protected BoardTraversal boardTraversal = new BoardTraversal()

    protected Colour colour
    protected Square position

    protected def setPosition(Square square) {
        position = square
        position.piece = this
    }

    List<Square> getSphereOfInfluence() {
        return getPossibleMoves()
    }

    def move(Square square) {
        if (!getPossibleMoves().contains(square))
            throw new IllegalMoveException("Can't move ${this.class.simpleName} from $position to $square")
        setPosition(square)
    }

    def void getMoves(Closure changeFile, Closure changeRank, List<Square> result,
                      boolean limitStepsToOne = false, Square initialPosition = position) {
        Square possibleSquare = board[changeFile(initialPosition.file) + changeRank(initialPosition.rank)]
        if (possibleSquare == null || possibleSquare.hasOwnPiece(this)) {
            return
        }
        if (possibleSquare.hasOpponentPiece(this)) {
            result << possibleSquare
            return
        }
        if (possibleSquare.isEmpty()) {
            result << possibleSquare
            if (!limitStepsToOne) getMoves(changeFile, changeRank, result, false, possibleSquare)
        }
    }

    abstract List<Square> getPossibleMoves()

    @Override
    String toString() {
        return "$colour ${this.class.simpleName} at $position"
    }

    @Override
    boolean equals(Object o) {
        if (o == null) return false
        if ((o.class != this.class)) return false
        return (o.colour == this.colour) && (o.position == this.position)
    }

}
