package org.js.carburettor.board.rule

import org.js.carburettor.board.Board
import org.js.carburettor.piece.Colour

class MaterialWeightRule implements AnalysisRule {

    @Override
    @SuppressWarnings("GroovyAssignabilityCheck")
    Integer analyse(Board board) {
        Integer whiteWeight = calculatePieceWeightOf(Colour.WHITE, board)
        Integer blackWeight = calculatePieceWeightOf(Colour.BLACK, board)
        return whiteWeight - blackWeight
    }

    Integer calculatePieceWeightOf(Colour colour, Board board) {
        def pieces = board.findPieces {it.colour == colour}
        pieces.inject(0, {sum, piece ->
            sum + piece.defaultWeight
        })
    }
}
