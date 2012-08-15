package org.js.carburettor.board

class Square {
    String file
    int rank
    def piece

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

    String toString() {
        "$file$rank"
    }
}
