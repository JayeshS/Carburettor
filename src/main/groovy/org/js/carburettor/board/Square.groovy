package org.js.carburettor.board

import org.js.carburettor.piece.Colour

class Square {
    String file
    int rank
    def piece
    private Board board

    boolean isEmpty() {
        piece == null
    }

    void empty() {
        piece = null
    }

    boolean hasOpponentPiece(def piece) {
        if (this.isEmpty())
            return false
        this.piece.colour != piece.colour
    }

    boolean hasOwnPiece(def piece) {
        if (this.isEmpty())
            return false
        this.piece.colour == piece.colour
    }

    boolean isControlledBy (Colour colour) {
        board.isSquareControlledBy(this, colour)
    }

    String toString() {
        "$file$rank"
    }
}
