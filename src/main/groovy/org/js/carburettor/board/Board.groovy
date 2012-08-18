package org.js.carburettor.board

import org.js.carburettor.piece.Piece

class Board {
    private Square a1 = new Square(file: 'A', rank: 1)
    private Square a2 = new Square(file: 'A', rank: 2)
    private Square a3 = new Square(file: 'A', rank: 3)
    private Square a4 = new Square(file: 'A', rank: 4)
    private Square a5 = new Square(file: 'A', rank: 5)
    private Square a6 = new Square(file: 'A', rank: 6)
    private Square a7 = new Square(file: 'A', rank: 7)
    private Square a8 = new Square(file: 'A', rank: 8)

    private Square b1 = new Square(file: 'B', rank: 1)
    private Square b2 = new Square(file: 'B', rank: 2)
    private Square b3 = new Square(file: 'B', rank: 3)
    private Square b4 = new Square(file: 'B', rank: 4)
    private Square b5 = new Square(file: 'B', rank: 5)
    private Square b6 = new Square(file: 'B', rank: 6)
    private Square b7 = new Square(file: 'B', rank: 7)
    private Square b8 = new Square(file: 'B', rank: 8)

    private Square c1 = new Square(file: 'C', rank: 1)
    private Square c2 = new Square(file: 'C', rank: 2)
    private Square c3 = new Square(file: 'C', rank: 3)
    private Square c4 = new Square(file: 'C', rank: 4)
    private Square c5 = new Square(file: 'C', rank: 5)
    private Square c6 = new Square(file: 'C', rank: 6)
    private Square c7 = new Square(file: 'C', rank: 7)
    private Square c8 = new Square(file: 'C', rank: 8)

    private Square d1 = new Square(file: 'D', rank: 1)
    private Square d2 = new Square(file: 'D', rank: 2)
    private Square d3 = new Square(file: 'D', rank: 3)
    private Square d4 = new Square(file: 'D', rank: 4)
    private Square d5 = new Square(file: 'D', rank: 5)
    private Square d6 = new Square(file: 'D', rank: 6)
    private Square d7 = new Square(file: 'D', rank: 7)
    private Square d8 = new Square(file: 'D', rank: 8)

    private Square e1 = new Square(file: 'E', rank: 1)
    private Square e2 = new Square(file: 'E', rank: 2)
    private Square e3 = new Square(file: 'E', rank: 3)
    private Square e4 = new Square(file: 'E', rank: 4)
    private Square e5 = new Square(file: 'E', rank: 5)
    private Square e6 = new Square(file: 'E', rank: 6)
    private Square e7 = new Square(file: 'E', rank: 7)
    private Square e8 = new Square(file: 'E', rank: 8)

    private Square f1 = new Square(file: 'F', rank: 1)
    private Square f2 = new Square(file: 'F', rank: 2)
    private Square f3 = new Square(file: 'F', rank: 3)
    private Square f4 = new Square(file: 'F', rank: 4)
    private Square f5 = new Square(file: 'F', rank: 5)
    private Square f6 = new Square(file: 'F', rank: 6)
    private Square f7 = new Square(file: 'F', rank: 7)
    private Square f8 = new Square(file: 'F', rank: 8)

    private Square g1 = new Square(file: 'G', rank: 1)
    private Square g2 = new Square(file: 'G', rank: 2)
    private Square g3 = new Square(file: 'G', rank: 3)
    private Square g4 = new Square(file: 'G', rank: 4)
    private Square g5 = new Square(file: 'G', rank: 5)
    private Square g6 = new Square(file: 'G', rank: 6)
    private Square g7 = new Square(file: 'G', rank: 7)
    private Square g8 = new Square(file: 'G', rank: 8)

    private Square h1 = new Square(file: 'H', rank: 1)
    private Square h2 = new Square(file: 'H', rank: 2)
    private Square h3 = new Square(file: 'H', rank: 3)
    private Square h4 = new Square(file: 'H', rank: 4)
    private Square h5 = new Square(file: 'H', rank: 5)
    private Square h6 = new Square(file: 'H', rank: 6)
    private Square h7 = new Square(file: 'H', rank: 7)
    private Square h8 = new Square(file: 'H', rank: 8)
    
    private List<Square> allSquares = [a1, a2, a3, a4, a5, a6, a7, a8,
                                b1, b2, b3, b4, b5, b6, b7, b8,
                                c1, c2, c3, c4, c5, c6, c7, c8,
                                d1, d2, d3, d4, d5, d6, d7, d8,
                                e1, e2, e3, e4, e5, e6, e7, e8,
                                f1, f2, f3, f4, f5, f6, f7, f8,
                                g1, g2, g3, g4, g5, g6, g7, g8,
                                h1, h2, h3, h4, h5, h6, h7, h8].asImmutable()

    private Square get(String file, int rank) {
        return allSquares.find {
            it.rank == rank && it.file.equalsIgnoreCase(file)
        }
    }

    static Board createEmptyBoard() {
        return new Board()
    }

    def getAt(String square) {
        assert square.length() == 2
        get(square[0], Integer.valueOf(square[1]))
    }

    def addAt(String square, Piece piece) {
        piece.position = this[square]
        piece.board = this
    }

}
