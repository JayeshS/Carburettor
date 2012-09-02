package org.js.carburettor.board

import org.js.carburettor.piece.*

@SuppressWarnings("GroovyAssignabilityCheck")
class Board {

    private List<Square> allSquares = []

    static Board setup(String fen) {
        Board board = createEmptyBoard()
        new FenParser(fen, board)
        return board
    }

    static Board setupNewGame() {
        Board board = createEmptyBoard()
        board.addAt(['a1', 'h1'], {new Rook(colour: Colour.WHITE)})
        board.addAt(['b1', 'g1'], {new Knight(colour: Colour.WHITE)})
        board.addAt(['c1', 'f1'], {new Bishop(colour: Colour.WHITE)})
        board.addAt(['d1'], {new Queen(colour: Colour.WHITE)})
        board.addAt(['e1'], {new King(colour: Colour.WHITE)})

        List allSquaresOnSecondRank = ('a'..'h').collect {it + '2'}
        board.addAt(allSquaresOnSecondRank, {new Pawn(colour: Colour.WHITE)})

        board.addAt(['a8', 'h8'], {new Rook(colour: Colour.BLACK)})
        board.addAt(['b8', 'g8'], {new Knight(colour: Colour.BLACK)})
        board.addAt(['c8', 'f8'], {new Bishop(colour: Colour.BLACK)})
        board.addAt(['d8'], {new Queen(colour: Colour.BLACK)})
        board.addAt(['e8'], {new King(colour: Colour.BLACK)})

        List allSquaresOnSeventhRank = ('a'..'h').collect {it + '7'}
        board.addAt(allSquaresOnSeventhRank, {new Pawn(colour: Colour.BLACK)})

        return board
    }

    private Board() {
        ('a'..'h').each {file ->
            (1..8).each {rank ->
                allSquares << new Square(file: file, rank: rank, board: this)
            }
        }
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
        def theSquare = this[square]
        assert theSquare != null, "Can not find square $square"
        piece.position = theSquare
        piece.board = this
    }

    boolean isSquareControlledBy(Square square, Colour colour) {
        allSquares.find {
            !it.isEmpty() &&
                    (it.piece.colour == colour) &&
                    it.piece.sphereOfInfluence?.contains(square)
        }
    }

    def addAt(List<Square> squares, Closure pieceCreator) {
        squares.each {square ->
            this.addAt(square, pieceCreator.call())
        }
    }

    List<Piece> findPieces(Closure criteria) {
        allSquares.findAll {square ->
            square.piece != null && criteria.call(square.piece)
        }*.piece
    }

    static Board createEmptyBoard() {
        return new Board()
    }
}
