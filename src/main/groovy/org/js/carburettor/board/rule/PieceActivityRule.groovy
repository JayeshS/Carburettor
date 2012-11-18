package org.js.carburettor.board.rule

import org.js.carburettor.board.Board
import org.js.carburettor.piece.Colour
import static org.js.carburettor.piece.Colour.WHITE
import static org.js.carburettor.piece.Colour.BLACK

class PieceActivityRule implements AnalysisRule {

    @Override
    Integer analyse(Board board) {
        int whiteSquares = findNumOfSquaresControlledBy(WHITE, board)
        int blackSquares = findNumOfSquaresControlledBy(BLACK, board)
        return whiteSquares - blackSquares
    }

    private def findNumOfSquaresControlledBy(Colour colour, Board board) {
        def pieces = board.findPieces {it.colour == colour}
        Integer controlledSquares = pieces.inject(0, {sum, piece ->
            sum + piece.possibleMoves.size()
        })
        return controlledSquares
    }
}
