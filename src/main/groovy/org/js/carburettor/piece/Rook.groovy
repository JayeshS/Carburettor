package org.js.carburettor.piece

import org.js.carburettor.board.Square
import org.js.carburettor.board.Squares

class Rook extends Piece {

    @Override
    List<Square> getPossibleMoves() {
        List<Square> possibleSquares = []
        def filesAhead = (position.file.next())..'H'
        def filesBehind = (position.file.previous())..'A'
        possibleSquares += getPossibleMovesOnCurrentRank(filesAhead) + getPossibleMovesOnCurrentRank(filesBehind)


        def ranksAbove = (position.rank.next())..8
        def ranksBelow = (position.rank.previous())..1
        possibleSquares += getPossibleMovesOnCurrentFile(ranksAbove) + getPossibleMovesOnCurrentFile(ranksBelow)

        return possibleSquares
    }

    private List<Square> getPossibleMovesOnCurrentFile(IntRange ranks) {
        List<Square> possibleSquares = []
        for (int currentRank in ranks) {
            Square possibleSquare = Squares.get(position.file, currentRank)
            if (possibleSquare == null) {
                continue
            }
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

    private def getPossibleMovesOnCurrentRank(ObjectRange files) {
        List<Square> possibleSquares = []
        for (String currentFile in files) {
            Square possibleSquare = Squares.get(currentFile, position.rank)
            if (possibleSquare == null) {
                continue
            }
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
