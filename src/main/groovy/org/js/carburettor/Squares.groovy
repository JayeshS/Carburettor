package org.js.carburettor

class Squares {
    static final Square A1 = new Square(file: 'A', rank: 1)
    static final Square A2 = new Square(file: 'A', rank: 2)
    static final Square A3 = new Square(file: 'A', rank: 3)
    static final Square A4 = new Square(file: 'A', rank: 4)
    static final Square A5 = new Square(file: 'A', rank: 5)
    static final Square A6 = new Square(file: 'A', rank: 6)
    static final Square A7 = new Square(file: 'A', rank: 7)
    static final Square A8 = new Square(file: 'A', rank: 8)

    static final Square B1 = new Square(file: 'B', rank: 1)
    static final Square B2 = new Square(file: 'B', rank: 2)
    static final Square B3 = new Square(file: 'B', rank: 3)
    static final Square B4 = new Square(file: 'B', rank: 4)
    static final Square B5 = new Square(file: 'B', rank: 5)
    static final Square B6 = new Square(file: 'B', rank: 6)
    static final Square B7 = new Square(file: 'B', rank: 7)
    static final Square B8 = new Square(file: 'B', rank: 8)

    static final Square C1 = new Square(file: 'C', rank: 1)
    static final Square C2 = new Square(file: 'C', rank: 2)
    static final Square C3 = new Square(file: 'C', rank: 3)
    static final Square C4 = new Square(file: 'C', rank: 4)
    static final Square C5 = new Square(file: 'C', rank: 5)
    static final Square C6 = new Square(file: 'C', rank: 6)
    static final Square C7 = new Square(file: 'C', rank: 7)
    static final Square C8 = new Square(file: 'C', rank: 8)

    static final Square D1 = new Square(file: 'D', rank: 1)
    static final Square D2 = new Square(file: 'D', rank: 2)
    static final Square D3 = new Square(file: 'D', rank: 3)
    static final Square D4 = new Square(file: 'D', rank: 4)
    static final Square D5 = new Square(file: 'D', rank: 5)
    static final Square D6 = new Square(file: 'D', rank: 6)
    static final Square D7 = new Square(file: 'D', rank: 7)
    static final Square D8 = new Square(file: 'D', rank: 8)

    static final Square E1 = new Square(file: 'E', rank: 1)
    static final Square E2 = new Square(file: 'E', rank: 2)
    static final Square E3 = new Square(file: 'E', rank: 3)
    static final Square E4 = new Square(file: 'E', rank: 4)
    static final Square E5 = new Square(file: 'E', rank: 5)
    static final Square E6 = new Square(file: 'E', rank: 6)
    static final Square E7 = new Square(file: 'E', rank: 7)
    static final Square E8 = new Square(file: 'E', rank: 8)

    static final Square F1 = new Square(file: 'F', rank: 1)
    static final Square F2 = new Square(file: 'F', rank: 2)
    static final Square F3 = new Square(file: 'F', rank: 3)
    static final Square F4 = new Square(file: 'F', rank: 4)
    static final Square F5 = new Square(file: 'F', rank: 5)
    static final Square F6 = new Square(file: 'F', rank: 6)
    static final Square F7 = new Square(file: 'F', rank: 7)
    static final Square F8 = new Square(file: 'F', rank: 8)

    static final Square G1 = new Square(file: 'G', rank: 1)
    static final Square G2 = new Square(file: 'G', rank: 2)
    static final Square G3 = new Square(file: 'G', rank: 3)
    static final Square G4 = new Square(file: 'G', rank: 4)
    static final Square G5 = new Square(file: 'G', rank: 5)
    static final Square G6 = new Square(file: 'G', rank: 6)
    static final Square G7 = new Square(file: 'G', rank: 7)
    static final Square G8 = new Square(file: 'G', rank: 8)

    static final Square H1 = new Square(file: 'H', rank: 1)
    static final Square H2 = new Square(file: 'H', rank: 2)
    static final Square H3 = new Square(file: 'H', rank: 3)
    static final Square H4 = new Square(file: 'H', rank: 4)
    static final Square H5 = new Square(file: 'H', rank: 5)
    static final Square H6 = new Square(file: 'H', rank: 6)
    static final Square H7 = new Square(file: 'H', rank: 7)
    static final Square H8 = new Square(file: 'H', rank: 8)
    
    static List<Square> ALL_SQUARES = [A1, A2, A3, A4, A5, A6, A7, A8,
                                B1, B2, B3, B4, B5, B6, B7, B8,
                                C1, C2, C3, C4, C5, C6, C7, C8,
                                D1, D2, D3, D4, D5, D6, D7, D8,
                                E1, E2, E3, E4, E5, E6, E7, E8,
                                F1, F2, F3, F4, F5, F6, F7, F8,
                                G1, G2, G3, G4, G5, G6, G7, G8,
                                H1, H2, H3, H4, H5, H6, H7, H8].asImmutable()

    static Square get(String file, int rank) {
        return ALL_SQUARES.find {
            it.rank.equals(rank) && it.file == file
        }
    }

}
