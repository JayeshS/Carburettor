package org.js.carburettor.board.rule

import org.js.carburettor.board.Board
import org.js.carburettor.piece.Colour

class MaterialWeightRule implements AnalysisRule {

    @Override
    @SuppressWarnings("GroovyAssignabilityCheck")
    Integer analyse(Board board) {
        def whitePieces = board.findPieces {it.colour == Colour.WHITE}

        def weightAccumulator = {sum, piece -> sum + piece.defaultWeight}
        Integer whiteWeight = whitePieces.inject(0, weightAccumulator)

        def blackPieces = board.findPieces {it.colour == Colour.BLACK}
        Integer blackWeight = blackPieces.inject(0, weightAccumulator)

        return whiteWeight - blackWeight
    }
}
