package org.js.carburettor.board

import org.js.carburettor.piece.Colour
import org.js.carburettor.piece.Piece

@SuppressWarnings("GroovyAssignabilityCheck")
class Board {

    private List<Square> allSquares = []

    private Board() {
        ('a'..'h').each {file ->
            (1..8).each {rank ->
                allSquares << new Square(file: file, rank: rank, board: this)
            }
        }
    }
    
    static Board createEmptyBoard() {
        return new Board()
    }


    private Square get(String file, int rank) {
        return allSquares.find {
            it.rank == rank && it.file.equalsIgnoreCase(file)
        }
    }

    def getAt(String square) {
        assert square.length() == 2
        get(square[0], Integer.valueOf(square[1]))
    }

    def addAt(String square, Piece piece) {
        piece.position = this[square]
        piece.board = this
    }

    boolean isSquareControlledBy(Square square, Colour colour) {
        allSquares.find {
            !it.isEmpty() &&
            (it.piece.colour == colour) &&
            it.piece.sphereOfInfluence?.contains(square)
        }
    }
}
