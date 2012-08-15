package org.js.carburettor.piece

import org.js.carburettor.board.Square
import org.js.carburettor.board.Squares

class Bishop extends Piece {

    @Override
    List<Square> getPossibleMoves() {
        return getAllDiagonalSquares()
    }

    private List<Square> getAllDiagonalSquares() {
        List<Square> possibleSquares = []

        def filesAhead = (position.file.next())..'H'
        def filesBehind = (position.file.previous())..'A'
        def incrementRank = {rank -> rank + 1}
        def decrementRank = {rank -> rank - 1}

        possibleSquares += getSquaresFor(filesAhead, incrementRank)
        possibleSquares += getSquaresFor(filesBehind, incrementRank)
        possibleSquares += getSquaresFor(filesAhead, decrementRank)
        possibleSquares += getSquaresFor(filesBehind, decrementRank)
        return possibleSquares
    }

    private List<Square> getSquaresFor(def fileRange, Closure changeRank) {
        List<Square> possibleSquares = []
        def currentRank = position.rank
        for (String currentFile in fileRange) {
            currentRank = changeRank(currentRank)
            Square possibleSquare = Squares.get(currentFile, currentRank)
            if (possibleSquare == null) { continue }
            if (possibleSquare.isEmpty()) {
                possibleSquares << possibleSquare
                continue
            }
            if (possibleSquare.hasOpponentPiece(this)) {
                possibleSquares << possibleSquare
                break
            }
            if (possibleSquare.hasOwnPiece(this)) {
                break
            }
        }
        return possibleSquares
    }

}
