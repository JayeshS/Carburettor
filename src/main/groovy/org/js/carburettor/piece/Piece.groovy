package org.js.carburettor.piece

import org.js.carburettor.IllegalMoveException
import org.js.carburettor.board.Board
import org.js.carburettor.board.BoardTraversal
import org.js.carburettor.board.Square

abstract class Piece {
    protected BoardTraversal boardTraversal = new BoardTraversal()

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
        calculateMoves(position, changeFile, changeRank, false, result)
    }

    def void getMoves(Closure changeFile, Closure changeRank, boolean limitStepsToOne, List<Square> result) {
        calculateMoves(position, changeFile, changeRank, limitStepsToOne, result)
    }


    private void calculateMoves(Square initialPosition, Closure changeFile, Closure changeRank, boolean limitStepsToOne, List<Square> result) {
        Square possibleSquare = Board.get(changeFile(initialPosition.file), changeRank(initialPosition.rank))
        if (possibleSquare == null || possibleSquare.hasOwnPiece(this)) {
            return
        }
        if (possibleSquare.hasOpponentPiece(this)) {
            result << possibleSquare
            return
        }
        if (possibleSquare.isEmpty()) {
            result << possibleSquare
            if (!limitStepsToOne) calculateMoves(possibleSquare, changeFile, changeRank, false, result)
        }
    }

    abstract List<Square> getPossibleMoves();
}
