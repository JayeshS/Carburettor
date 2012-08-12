package org.js.carburettor

class Square {
    String file
    int rank
    def piece

    String toString() {
        "$file$rank"
    }

    boolean isEmpty() {
        piece == null
    }
}
