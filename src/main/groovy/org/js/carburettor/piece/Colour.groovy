package org.js.carburettor.piece

enum Colour {
    WHITE, BLACK

    Colour getOpponent() {
        this == WHITE ? BLACK : WHITE
    }
}
